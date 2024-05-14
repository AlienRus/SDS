package backend.application.interfaces.out.repository;

import backend.application.dto.RequestFileDto;

import java.util.List;

public interface IRequestFileRepository {
    void createRequestFile(RequestFileDto requestFileDto);

    RequestFileDto getRequestFileById(Long id);

    List<RequestFileDto> getRequestFilesByLotId(Long lotId);

    List<RequestFileDto> getRequestFilesBySupplierId(Long supplierId);

    List<RequestFileDto> getAllRequestFiles();

    void updateRequestFile(RequestFileDto requestFileDto);

    void deleteRequestFile(RequestFileDto requestFileDto);
}
