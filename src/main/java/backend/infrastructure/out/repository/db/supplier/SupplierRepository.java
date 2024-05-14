package backend.infrastructure.out.repository.db.supplier;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.SupplierDto;
import backend.application.interfaces.out.repository.ISupplierRepository;

@Stateless
public class SupplierRepository implements ISupplierRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createSupplier(SupplierDto supplierDto) {
        Supplier supplier = SupplierMapper.toEntity(supplierDto);
        entityManager.persist(supplier);
    }

    public SupplierDto getSupplierById(Long id) {
        Supplier supplier = entityManager.find(Supplier.class, id);
        return SupplierMapper.toDto(supplier);
    }

    public List<SupplierDto> getAllSuppliers() {
        List<Supplier> suppliers = entityManager.createQuery("SELECT s FROM Supplier s", Supplier.class)
                .getResultList();
        return suppliers.stream().map(SupplierMapper::toDto).collect(Collectors.toList());
    }

    public void updateSupplier(SupplierDto supplierDto) {
        Supplier supplier = SupplierMapper.toEntity(supplierDto);
        entityManager.merge(supplier);
    }

    public void deleteSupplier(SupplierDto supplierDto) {
        Supplier supplier = SupplierMapper.toEntity(supplierDto);
        entityManager.remove(entityManager.contains(supplier) ? supplier : entityManager.merge(supplier));
    }
}
