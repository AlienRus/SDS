package backend.infrastructure.out.repository.db.supplySpecialistGroup;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.SupplySpecialistGroupDto;
import backend.application.interfaces.out.repository.ISupplySpecialistGroupRepository;

@Stateless
public class SupplySpecialistGroupRepository implements ISupplySpecialistGroupRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createSupplySpecialistGroup(SupplySpecialistGroupDto supplySpecialistGroupDto) {
        SupplySpecialistGroup supplySpecialistGroup = SupplySpecialistGroupMapper.toEntity(supplySpecialistGroupDto);
        entityManager.persist(supplySpecialistGroup);
    }

    public SupplySpecialistGroupDto getSupplySpecialistGroupById(Long id) {
        SupplySpecialistGroup supplySpecialistGroup = entityManager.find(SupplySpecialistGroup.class, id);
        return SupplySpecialistGroupMapper.toDto(supplySpecialistGroup);
    }

    public List<SupplySpecialistGroupDto> getAllSupplySpecialistGroups() {
        List<SupplySpecialistGroup> supplySpecialistGroups = entityManager
                .createQuery("SELECT ssg FROM SupplySpecialistGroup ssg", SupplySpecialistGroup.class).getResultList();
        return supplySpecialistGroups.stream().map(SupplySpecialistGroupMapper::toDto).collect(Collectors.toList());
    }

    public void updateSupplySpecialistGroup(SupplySpecialistGroupDto supplySpecialistGroupDto) {
        SupplySpecialistGroup supplySpecialistGroup = SupplySpecialistGroupMapper.toEntity(supplySpecialistGroupDto);
        entityManager.merge(supplySpecialistGroup);
    }

    public void deleteSupplySpecialistGroup(SupplySpecialistGroupDto supplySpecialistGroupDto) {
        SupplySpecialistGroup supplySpecialistGroup = SupplySpecialistGroupMapper.toEntity(supplySpecialistGroupDto);
        entityManager.remove(entityManager.contains(supplySpecialistGroup) ? supplySpecialistGroup
                : entityManager.merge(supplySpecialistGroup));
    }
}
