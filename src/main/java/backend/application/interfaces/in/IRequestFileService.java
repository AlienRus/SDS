package backend.application.interfaces.in;

import backend.application.dto.RequestFileDto;
import backend.application.interfaces.out.repository.IRequestFileRepository;

import java.util.List;

public interface IRequestFileService {
    public void InjectRequestFileRepository(IRequestFileRepository requestFileRepository);

    void createRequestFile(RequestFileDto requestFileDto);

    RequestFileDto getRequestFileById(Long id);

    List<RequestFileDto> getRequestFilesByLotId(Long lotId);

    List<RequestFileDto> getRequestFilesBySupplierId(Long supplierId);

    List<RequestFileDto> getAllRequestFiles();

    void updateRequestFile(RequestFileDto requestFileDto);

    void deleteRequestFile(RequestFileDto requestFileDto);
}
