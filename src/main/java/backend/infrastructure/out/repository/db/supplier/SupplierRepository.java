package backend.infrastructure.out.repository.db.supplier;

import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        try {
            Supplier supplier = SupplierMapper.toEntity(supplierDto);
            entityManager.merge(supplier);

        } catch (ConstraintViolationException e) {
            for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
                Logger.getLogger(SupplierRepository.class.getName()).log(Level.SEVERE,
                        violation.getPropertyPath() + " " + violation.getMessage());
            }
            throw e;
        } catch (Exception e) {
            Logger.getLogger(SupplierRepository.class.getName()).log(Level.SEVERE, "Exception ", e);
            throw new EJBException("Error creating LotPosition", e);
        }
    }

    public void deleteSupplier(SupplierDto supplierDto) {
        Supplier supplier = SupplierMapper.toEntity(supplierDto);
        entityManager.remove(entityManager.contains(supplier) ? supplier : entityManager.merge(supplier));
    }

    @Override
    public SupplierDto getSupplierByEmailAndPassword(String email, String password) {
        List<Supplier> supplier = entityManager.createQuery(
                "SELECT supplier FROM Supplier supplier WHERE supplier.email=:email AND supplier.password=:password",
                Supplier.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getResultList();
        if (supplier.isEmpty()) {
            return null;
        }

        return SupplierMapper.toDto(supplier.get(0));
    }

    @Override
    public SupplierDto getSupplierByEmail(String email) {
        List<Supplier> supplier = entityManager.createQuery(
                "SELECT supplier FROM Supplier supplier WHERE supplier.email=:email",
                Supplier.class)
                .setParameter("email", email)
                .getResultList();
        if (supplier.isEmpty()) {
            return null;
        }

        return SupplierMapper.toDto(supplier.get(0));
    }
}
