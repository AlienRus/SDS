package backend.application.interfaces.out.repository;

import backend.application.dto.RequestDto;

import java.util.List;

public interface IRequestRepository {
    void createRequest(RequestDto requestDto);

    RequestDto getRequestById(Long id);

    List<RequestDto> getAllRequests();

    void updateRequest(RequestDto requestDto);

    void deleteRequest(RequestDto requestDto);
}
