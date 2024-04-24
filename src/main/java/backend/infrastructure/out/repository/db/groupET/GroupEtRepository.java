package backend.infrastructure.out.repository.db.groupET;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.GroupEtDto;

@Stateless
public class GroupEtRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createGroupEt(GroupEtDto groupEtDto) {
        GroupEt groupEt = GroupEtMapper.toEntity(groupEtDto);
        entityManager.persist(groupEt);
    }

    public GroupEtDto getGroupEtById(Long id) {
        GroupEt groupEt = entityManager.find(GroupEt.class, id);
        return GroupEtMapper.toDto(groupEt);
    }

    public List<GroupEtDto> getAllGroupEts() {
        List<GroupEt> groupEts = entityManager.createQuery("SELECT g FROM GroupEt g", GroupEt.class).getResultList();
        return groupEts.stream()
                .map(GroupEtMapper::toDto)
                .collect(Collectors.toList());
    }

    public void updateGroupEt(GroupEtDto groupEtDto) {
        GroupEt groupEt = GroupEtMapper.toEntity(groupEtDto);
        entityManager.merge(groupEt);
    }

    public void deleteGroupEt(GroupEtDto groupEtDto) {
        GroupEt groupEt = GroupEtMapper.toEntity(groupEtDto);
        entityManager.remove(entityManager.contains(groupEt) ? groupEt : entityManager.merge(groupEt));
    }
}
