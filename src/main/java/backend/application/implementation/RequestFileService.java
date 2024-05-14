package backend.application.implementation;

import backend.application.dto.RequestFileDto;
import backend.application.interfaces.in.IRequestFileService;
import backend.application.interfaces.out.repository.IRequestFileRepository;

import java.util.List;

public class RequestFileService implements IRequestFileService {

    private IRequestFileRepository requestFileRepository;

    @Override
    public void InjectRequestFileRepository(IRequestFileRepository requestFileRepository) {
        this.requestFileRepository = requestFileRepository;
    }

    @Override
    public void createRequestFile(RequestFileDto requestFileDto) {
        requestFileRepository.createRequestFile(requestFileDto);
    }

    @Override
    public RequestFileDto getRequestFileById(Long id) {
        return requestFileRepository.getRequestFileById(id);
    }

    @Override
    public List<RequestFileDto> getRequestFilesByLotId(Long lotId) {
        return requestFileRepository.getRequestFilesByLotId(lotId);
    }

    @Override
    public List<RequestFileDto> getRequestFilesBySupplierId(Long supplierId) {
        return requestFileRepository.getRequestFilesBySupplierId(supplierId);
    }

    @Override
    public List<RequestFileDto> getAllRequestFiles() {
        return requestFileRepository.getAllRequestFiles();
    }

    @Override
    public void updateRequestFile(RequestFileDto requestFileDto) {
        requestFileRepository.updateRequestFile(requestFileDto);
    }

    @Override
    public void deleteRequestFile(RequestFileDto requestFileDto) {
        requestFileRepository.deleteRequestFile(requestFileDto);
    }
}
