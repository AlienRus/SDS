package backend.infrastructure.out.repository.db.positionRequest;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.PositionRequestDto;

@Stateless
public class PositionRequestRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createPositionRequest(PositionRequestDto positionRequestDto) {
        PositionRequest positionRequest = PositionRequestMapper.toEntity(positionRequestDto);
        entityManager.persist(positionRequest);
    }

    public PositionRequestDto getPositionRequestById(Long id) {
        PositionRequest positionRequest = entityManager.find(PositionRequest.class, id);
        return PositionRequestMapper.toDto(positionRequest);
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
        PositionRequest positionRequest = PositionRequestMapper.toEntity(positionRequestDto);
        entityManager.remove(
                entityManager.contains(positionRequest) ? positionRequest : entityManager.merge(positionRequest));
    }
}
