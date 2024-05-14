package backend.application.implementation;

import backend.application.dto.RequestDto;
import backend.application.interfaces.in.IRequestService;
import backend.application.interfaces.out.repository.IRequestRepository;

import java.util.List;

public class RequestService implements IRequestService {

    private IRequestRepository requestRepository;

    @Override
    public void InjectRequestRepository(IRequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public void createRequest(RequestDto requestDto) {
        requestRepository.createRequest(requestDto);
    }

    @Override
    public RequestDto getRequestById(Long id) {
        return requestRepository.getRequestById(id);
    }

    @Override
    public List<RequestDto> getAllRequests() {
        return requestRepository.getAllRequests();
    }

    @Override
    public void updateRequest(RequestDto requestDto) {
        requestRepository.updateRequest(requestDto);
    }

    @Override
    public void deleteRequest(RequestDto requestDto) {
        requestRepository.deleteRequest(requestDto);
    }
}
