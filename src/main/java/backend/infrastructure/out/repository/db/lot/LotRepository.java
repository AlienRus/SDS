package backend.infrastructure.out.repository.db.lot;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.LotDto;
import backend.application.interfaces.out.repository.ILotRepository;

@Stateless
public class LotRepository implements ILotRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createLot(LotDto lotDto) {
        Lot lot = LotMapper.toEntity(lotDto);
        entityManager.persist(lot);
    }

    public LotDto getLotById(Long id) {
        Lot lot = entityManager.find(Lot.class, id);
        return LotMapper.toDto(lot);
    }

    public List<LotDto> getAllLots() {
        List<Lot> lots = entityManager.createQuery("SELECT lot FROM Lot lot", Lot.class).getResultList();
        return lots.stream()
                .map(LotMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<LotDto> getAllLotsByGroup(Long groupId) {
        List<Lot> lots = entityManager.createQuery("SELECT lot FROM Lot lot WHERE lot.groupEts.id=:id", Lot.class)
                .setParameter("id", groupId).getResultList();
        return lots.stream()
                .map(LotMapper::toDto)
                .collect(Collectors.toList());
    }

    public void updateLot(LotDto lotDto) {
        Lot lot = LotMapper.toEntity(lotDto);
        entityManager.merge(lot);
    }

    public void deleteLot(LotDto lotDto) {
        Lot lot = LotMapper.toEntity(lotDto);
        entityManager.remove(entityManager.contains(lot) ? lot : entityManager.merge(lot));
    }

    @Override
    public Long getLatestLotId() {
        Long latestLotId = (Long) entityManager.createQuery("SELECT MAX(lot.id) FROM Lot lot")
                .getSingleResult();
        return latestLotId != null ? latestLotId : 0L; // если база данных пуста, возвращаем 0
    }
}
