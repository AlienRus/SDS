package backend.infrastructure.out.repository.db.status;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.StatusDto;
import backend.application.interfaces.out.repository.IStatusRepository;

@Stateless
public class StatusRepository implements IStatusRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createStatus(StatusDto statusDto) {
        Status status = StatusMapper.toEntity(statusDto);
        entityManager.persist(status);
    }

    public StatusDto getStatusById(Long id) {
        Status status = entityManager.find(Status.class, id);
        return StatusMapper.toDto(status);
    }

    public List<StatusDto> getAllStatuses() {
        List<Status> statusList = entityManager.createQuery("SELECT s FROM Status s", Status.class).getResultList();
        return statusList.stream().map(StatusMapper::toDto).collect(Collectors.toList());
    }

    public void updateStatus(StatusDto statusDto) {
        Status status = StatusMapper.toEntity(statusDto);
        entityManager.merge(status);
    }

    public void deleteStatus(StatusDto statusDto) {
        Status status = StatusMapper.toEntity(statusDto);
        entityManager.remove(entityManager.contains(status) ? status : entityManager.merge(status));
    }
}
