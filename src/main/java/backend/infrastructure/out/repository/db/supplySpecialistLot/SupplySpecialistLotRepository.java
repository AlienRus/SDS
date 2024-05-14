package backend.infrastructure.out.repository.db.supplySpecialistLot;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.SupplySpecialistLotDto;
import backend.application.interfaces.out.repository.ISupplySpecialistLotRepository;

@Stateless
public class SupplySpecialistLotRepository implements ISupplySpecialistLotRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createSupplySpecialistLot(SupplySpecialistLotDto supplySpecialistLotDto) {
        SupplySpecialistLot supplySpecialistLot = SupplySpecialistLotMapper.toEntity(supplySpecialistLotDto);
        entityManager.persist(supplySpecialistLot);
    }

    public SupplySpecialistLotDto getSupplySpecialistLotById(Long id) {
        SupplySpecialistLot supplySpecialistLot = entityManager.find(SupplySpecialistLot.class, id);
        return SupplySpecialistLotMapper.toDto(supplySpecialistLot);
    }

    public List<SupplySpecialistLotDto> getSupplySpecialistLotsByIdAndStatus(Long id, String status) {
        List<SupplySpecialistLot> supplySpecialistLots = entityManager
                .createQuery(
                        "SELECT ssl FROM SupplySpecialistLot ssl WHERE ssl.supplySpecialist.id=:id AND ssl.lot.status.statusName=:status",
                        SupplySpecialistLot.class)
                .setParameter("id", id)
                .setParameter("status", status)
                .getResultList();

        return supplySpecialistLots.stream()
                .map(SupplySpecialistLotMapper::toDto).collect(Collectors.toList());
    }

    public List<SupplySpecialistLotDto> getAllSupplySpecialistLots() {
        List<SupplySpecialistLot> supplySpecialistLots = entityManager
                .createQuery("SELECT ssl FROM SupplySpecialistLot ssl", SupplySpecialistLot.class).getResultList();
        return supplySpecialistLots.stream().map(SupplySpecialistLotMapper::toDto).collect(Collectors.toList());
    }

    public void updateSupplySpecialistLot(SupplySpecialistLotDto supplySpecialistLotDto) {
        SupplySpecialistLot supplySpecialistLot = SupplySpecialistLotMapper.toEntity(supplySpecialistLotDto);
        entityManager.merge(supplySpecialistLot);
    }

    public void deleteSupplySpecialistLot(SupplySpecialistLotDto supplySpecialistLotDto) {
        SupplySpecialistLot supplySpecialistLot = SupplySpecialistLotMapper.toEntity(supplySpecialistLotDto);
        entityManager.remove(entityManager.contains(supplySpecialistLot) ? supplySpecialistLot
                : entityManager.merge(supplySpecialistLot));
    }
}
