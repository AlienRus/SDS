package backend.infrastructure.out.repository.db.lotPosition;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import backend.application.dto.LotPositionDto;
import backend.application.interfaces.out.repository.ILotPositionRepository;

@Stateless
public class LotPositionRepository implements ILotPositionRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createLotPosition(LotPositionDto lotPositionDto) {
        LotPosition lotPosition = LotPositionMapper.toEntity(lotPositionDto);

        Logger.getLogger(LotPositionRepository.class.getName()).log(Level.INFO, lotPosition.toString());
        entityManager.persist(lotPosition);
    }

    public LotPositionDto getLotPositionById(Long id) {
        LotPosition lotPosition = entityManager.find(LotPosition.class, id);
        return LotPositionMapper.toDto(lotPosition);
    }

    public List<LotPositionDto> getLotPositionByLotId(Long lotId) {
        List<LotPosition> lotPositions = entityManager
                .createQuery("SELECT lotPosition FROM LotPosition lotPosition WHERE lotPosition.lot.id=:id",
                        LotPosition.class)
                .setParameter("id", lotId)
                .getResultList();
        return lotPositions.stream()
                .map(LotPositionMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<LotPositionDto> getAllLotPositions() {
        List<LotPosition> lotPositions = entityManager
                .createQuery("SELECT lotPosition FROM LotPosition lotPosition", LotPosition.class)
                .getResultList();
        return lotPositions.stream()
                .map(LotPositionMapper::toDto)
                .collect(Collectors.toList());
    }

    public void updateLotPosition(LotPositionDto lotPositionDto) {
        LotPosition lotPosition = LotPositionMapper.toEntity(lotPositionDto);
        entityManager.merge(lotPosition);
    }

    public void deleteLotPosition(LotPositionDto lotPositionDto) {
        LotPosition lotPosition = LotPositionMapper.toEntity(lotPositionDto);
        entityManager.remove(entityManager.contains(lotPosition) ? lotPosition : entityManager.merge(lotPosition));
    }
}
