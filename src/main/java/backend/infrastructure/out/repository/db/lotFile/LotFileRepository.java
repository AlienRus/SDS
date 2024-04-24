package backend.infrastructure.out.repository.db.lotFile;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.LotFileDto;

@Stateless
public class LotFileRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createLotFile(LotFileDto lotFileDto) {
        LotFile lotFile = LotFileMapper.toEntity(lotFileDto);
        entityManager.persist(lotFile);
    }

    public LotFileDto getLotFileById(Long id) {
        LotFile lotFile = entityManager.find(LotFile.class, id);
        return LotFileMapper.toDto(lotFile);
    }

    public List<LotFileDto> getAllLotFilesByLotId(Long lotId) {
        List<LotFile> lotFiles = entityManager
                .createQuery("SELECT lotFile FROM LotFile lotFile WHERE lotFile.lot.id=:id", LotFile.class)
                .setParameter("id", lotId)
                .getResultList();
        return lotFiles.stream()
                .map(LotFileMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<LotFileDto> getAllLotFiles() {
        List<LotFile> lotFiles = entityManager.createQuery("SELECT lotFile FROM LotFile lotFile", LotFile.class)
                .getResultList();
        return lotFiles.stream()
                .map(LotFileMapper::toDto)
                .collect(Collectors.toList());
    }

    public void updateLotFile(LotFileDto lotFileDto) {
        LotFile lotFile = LotFileMapper.toEntity(lotFileDto);
        entityManager.merge(lotFile);
    }

    public void deleteLotFile(LotFileDto lotFileDto) {
        LotFile lotFile = LotFileMapper.toEntity(lotFileDto);
        entityManager.remove(entityManager.contains(lotFile) ? lotFile : entityManager.merge(lotFile));
    }
}
