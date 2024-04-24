package backend.infrastructure.out.repository.db.requestFile;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.RequestFileDto;

@Stateless
public class RequestFileRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createRequestFile(RequestFileDto requestFileDto) {
        RequestFile requestFile = RequestFileMapper.toEntity(requestFileDto);
        entityManager.persist(requestFile);
    }

    public RequestFileDto getRequestFileById(Long id) {
        RequestFile requestFile = entityManager.find(RequestFile.class, id);
        return RequestFileMapper.toDto(requestFile);
    }

    public List<RequestFileDto> getRequestFilesByLotId(Long lotId) {
        List<RequestFile> requestFiles = entityManager
                .createQuery("SELECT requestFile FROM RequestFile requestFile WHERE requestFile.lot.id = :lotId",
                        RequestFile.class)
                .setParameter("lotId", lotId)
                .getResultList();
        return requestFiles.stream()
                .map(RequestFileMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<RequestFileDto> getRequestFilesBySupplierId(Long supplierId) {
        List<RequestFile> requestFiles = entityManager
                .createQuery(
                        "SELECT requestFile FROM RequestFile requestFile WHERE requestFile.supplier.id = :supplierId",
                        RequestFile.class)
                .setParameter("supplierId", supplierId)
                .getResultList();
        return requestFiles.stream()
                .map(RequestFileMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<RequestFileDto> getAllRequestFiles() {
        List<RequestFile> requestFiles = entityManager
                .createQuery("SELECT requestFile FROM RequestFile requestFile", RequestFile.class)
                .getResultList();
        return requestFiles.stream()
                .map(RequestFileMapper::toDto)
                .collect(Collectors.toList());
    }

    public void updateRequestFile(RequestFileDto requestFileDto) {
        RequestFile requestFile = RequestFileMapper.toEntity(requestFileDto);
        entityManager.merge(requestFile);
    }

    public void deleteRequestFile(RequestFileDto requestFileDto) {
        RequestFile requestFile = RequestFileMapper.toEntity(requestFileDto);
        entityManager.remove(entityManager.contains(requestFile) ? requestFile : entityManager.merge(requestFile));
    }
}
