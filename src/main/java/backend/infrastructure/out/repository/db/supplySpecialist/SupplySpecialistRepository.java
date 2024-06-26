package backend.infrastructure.out.repository.db.supplySpecialist;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.SupplySpecialistDto;
import backend.application.interfaces.out.repository.ISupplySpecialistRepository;

@Stateless
public class SupplySpecialistRepository implements ISupplySpecialistRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createSupplySpecialist(SupplySpecialistDto supplySpecialistDto) {
        SupplySpecialist supplySpecialist = SupplySpecialistMapper.toEntity(supplySpecialistDto);
        entityManager.persist(supplySpecialist);
    }

    public SupplySpecialistDto getSupplySpecialistById(Long id) {
        SupplySpecialist supplySpecialist = entityManager.find(SupplySpecialist.class, id);
        return SupplySpecialistMapper.toDto(supplySpecialist);
    }

    public List<SupplySpecialistDto> getAllSupplySpecialists() {
        List<SupplySpecialist> supplySpecialists = entityManager
                .createQuery("SELECT ss FROM SupplySpecialist ss", SupplySpecialist.class).getResultList();
        return supplySpecialists.stream().map(SupplySpecialistMapper::toDto).collect(Collectors.toList());
    }

    public void updateSupplySpecialist(SupplySpecialistDto supplySpecialistDto) {
        SupplySpecialist supplySpecialist = SupplySpecialistMapper.toEntity(supplySpecialistDto);
        entityManager.merge(supplySpecialist);
    }

    public void deleteSupplySpecialist(SupplySpecialistDto supplySpecialistDto) {
        SupplySpecialist supplySpecialist = SupplySpecialistMapper.toEntity(supplySpecialistDto);
        entityManager.remove(
                entityManager.contains(supplySpecialist) ? supplySpecialist : entityManager.merge(supplySpecialist));
    }

    @Override
    public SupplySpecialistDto getSupplySpecialistByEmailAndPassword(String email, String password) {
        List<SupplySpecialist> supplySpecialist = entityManager
                .createQuery("SELECT ss FROM SupplySpecialist ss WHERE ss.email=:email AND ss.password=:password",
                        SupplySpecialist.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getResultList();
        if (supplySpecialist.isEmpty()) {
            return null;
        }

        return SupplySpecialistMapper.toDto(supplySpecialist.get(0));
    }
}
