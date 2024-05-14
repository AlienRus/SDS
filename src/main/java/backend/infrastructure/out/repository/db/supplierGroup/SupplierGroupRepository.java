package backend.infrastructure.out.repository.db.supplierGroup;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.SupplierGroupDto;
import backend.application.interfaces.out.repository.ISupplierGroupRepository;

@Stateless
public class SupplierGroupRepository implements ISupplierGroupRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createSupplierGroup(SupplierGroupDto supplierGroupDto) {
        SupplierGroup supplierGroup = SupplierGroupMapper.toEntity(supplierGroupDto);
        entityManager.persist(supplierGroup);
    }

    public SupplierGroupDto getSupplierGroupById(Long id) {
        SupplierGroup supplierGroup = entityManager.find(SupplierGroup.class, id);
        return SupplierGroupMapper.toDto(supplierGroup);
    }

    public List<SupplierGroupDto> getAllSupplierGroups() {
        List<SupplierGroup> supplierGroups = entityManager
                .createQuery("SELECT sg FROM SupplierGroup sg", SupplierGroup.class).getResultList();
        return supplierGroups.stream().map(SupplierGroupMapper::toDto).collect(Collectors.toList());
    }

    public void updateSupplierGroup(SupplierGroupDto supplierGroupDto) {
        SupplierGroup supplierGroup = SupplierGroupMapper.toEntity(supplierGroupDto);
        entityManager.merge(supplierGroup);
    }

    public void deleteSupplierGroup(SupplierGroupDto supplierGroupDto) {
        SupplierGroup supplierGroup = SupplierGroupMapper.toEntity(supplierGroupDto);
        entityManager
                .remove(entityManager.contains(supplierGroup) ? supplierGroup : entityManager.merge(supplierGroup));
    }
}
