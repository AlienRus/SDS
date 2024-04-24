package backend.infrastructure.out.repository.db.groupEtsSigner;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.GroupEtsSignerDto;

@Stateless
public class GroupEtsSignerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createGroupEtsSigner(GroupEtsSignerDto groupEtsSignerDto) {
        GroupEtsSigner groupEtsSigner = GroupEtsSignerMapper.toEntity(groupEtsSignerDto);
        entityManager.persist(groupEtsSigner);
    }

    public GroupEtsSignerDto getGroupEtsSignerById(Long id) {
        GroupEtsSigner groupEtsSigner = entityManager.find(GroupEtsSigner.class, id);
        return GroupEtsSignerMapper.toDto(groupEtsSigner);
    }

    public List<GroupEtsSignerDto> getAllGroupEtsSignersByGroupEtsId(Long id) {
        List<GroupEtsSigner> groupEtsSigners = entityManager
                .createQuery("SELECT ges FROM GroupEtsSigner ges WHERE ges.groupEts.id=:id", GroupEtsSigner.class)
                .setParameter("id", id).getResultList();
        return groupEtsSigners.stream()
                .map(GroupEtsSignerMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<GroupEtsSignerDto> getAllGroupEtsSigners() {
        List<GroupEtsSigner> groupEtsSigners = entityManager
                .createQuery("SELECT ges FROM GroupEtsSigner ges", GroupEtsSigner.class).getResultList();
        return groupEtsSigners.stream()
                .map(GroupEtsSignerMapper::toDto)
                .collect(Collectors.toList());
    }

    public void updateGroupEtsSigner(GroupEtsSignerDto groupEtsSignerDto) {
        GroupEtsSigner groupEtsSigner = GroupEtsSignerMapper.toEntity(groupEtsSignerDto);
        entityManager.merge(groupEtsSigner);
    }

    public void deleteGroupEtsSigner(GroupEtsSignerDto groupEtsSignerDto) {
        GroupEtsSigner groupEtsSigner = GroupEtsSignerMapper.toEntity(groupEtsSignerDto);
        entityManager
                .remove(entityManager.contains(groupEtsSigner) ? groupEtsSigner : entityManager.merge(groupEtsSigner));
    }
}
