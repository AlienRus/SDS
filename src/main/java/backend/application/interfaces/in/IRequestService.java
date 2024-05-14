package backend.application.interfaces.in;

import backend.application.dto.RequestDto;
import backend.application.interfaces.out.repository.IRequestRepository;

import java.util.List;

public interface IRequestService {
    public void InjectRequestRepository(IRequestRepository requestRepository);

    void createRequest(RequestDto requestDto);

    RequestDto getRequestById(Long id);

    List<RequestDto> getAllRequests();

    void updateRequest(RequestDto requestDto);

    void deleteRequest(RequestDto requestDto);
}
