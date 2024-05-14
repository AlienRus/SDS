package backend.infrastructure.out.repository.db.request;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.RequestDto;
import backend.application.interfaces.out.repository.IRequestRepository;

@Stateless
public class RequestRepository implements IRequestRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createRequest(RequestDto requestDto) {
        Request request = RequestMapper.toEntity(requestDto);
        entityManager.persist(request);
    }

    public RequestDto getRequestById(Long id) {
        Request request = entityManager.find(Request.class, id);
        return RequestMapper.toDto(request);
    }

    public List<RequestDto> getAllRequests() {
        List<Request> requests = entityManager.createQuery("SELECT request FROM Request request", Request.class)
                .getResultList();
        return requests.stream()
                .map(RequestMapper::toDto)
                .collect(Collectors.toList());
    }

    public void updateRequest(RequestDto requestDto) {
        Request request = RequestMapper.toEntity(requestDto);
        entityManager.merge(request);
    }

    public void deleteRequest(RequestDto requestDto) {
        Request request = RequestMapper.toEntity(requestDto);
        entityManager.remove(entityManager.contains(request) ? request : entityManager.merge(request));
    }
}
