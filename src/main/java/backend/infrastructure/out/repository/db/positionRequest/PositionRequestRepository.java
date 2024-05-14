package backend.infrastructure.out.repository.db.positionRequest;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.PositionRequestDto;
import backend.application.dto.RequestDto;
import backend.application.interfaces.out.repository.IPositionRequestRepository;
import backend.infrastructure.out.repository.db.request.Request;
import backend.infrastructure.out.repository.db.request.RequestMapper;

import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class PositionRequestRepository implements IPositionRequestRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createPositionRequest(PositionRequestDto positionRequestDto) {
        Logger.getLogger(PositionRequestRepository.class.getName()).log(Level.WARNING, positionRequestDto.toString());
        PositionRequest positionRequest = PositionRequestMapper.toEntity(positionRequestDto);
        entityManager.persist(positionRequest);
    }

    public PositionRequestDto getPositionRequestById(Long id) {
        PositionRequest positionRequest = entityManager.find(PositionRequest.class, id);
        return PositionRequestMapper.toDto(positionRequest);
    }

    public List<RequestDto> getRequestsByPositionId(Long id) {
        List<Request> requests = entityManager
                .createQuery(
                        "SELECT positionRequest.request FROM PositionRequest positionRequest WHERE positionRequest.position.id=:id",
                        Request.class)
                .setParameter("id", id)
                .getResultList();
        return requests.stream()
                .map(RequestMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<PositionRequestDto> getAllPositionRequests() {
        List<PositionRequest> positionRequests = entityManager
                .createQuery("SELECT positionRequest FROM PositionRequest positionRequest", PositionRequest.class)
                .getResultList();
        return positionRequests.stream()
                .map(PositionRequestMapper::toDto)
                .collect(Collectors.toList());
    }

    public void updatePositionRequest(PositionRequestDto positionRequestDto) {
        PositionRequest positionRequest = PositionRequestMapper.toEntity(positionRequestDto);
        entityManager.merge(positionRequest);
    }

    public void deletePositionRequest(PositionRequestDto positionRequestDto) {
        Logger.getLogger(PositionRequestRepository.class.getName()).log(Level.WARNING, positionRequestDto.toString());
        PositionRequest positionRequest = PositionRequestMapper.toEntity(positionRequestDto);
        entityManager.remove(
                entityManager.contains(positionRequest) ? positionRequest : entityManager.merge(positionRequest));
    }

    public void deletePositionRequestByPositionId(PositionRequestDto positionRequestDto) {
        Long positionId = positionRequestDto.getPosition().getId();

        PositionRequest positionRequest = entityManager.createQuery(
                "SELECT pr FROM PositionRequest pr WHERE pr.position.id = :positionId", PositionRequest.class)
                .setParameter("positionId", positionId)
                .getSingleResult();

        if (positionRequest != null) {
            entityManager.remove(positionRequest);
        }
    }
}
