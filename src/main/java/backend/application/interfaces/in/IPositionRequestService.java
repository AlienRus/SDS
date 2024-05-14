package backend.application.interfaces.in;

import backend.application.dto.PositionRequestDto;
import backend.application.dto.RequestDto;
import backend.application.interfaces.out.repository.IPositionRequestRepository;

import java.util.List;

public interface IPositionRequestService {
    public void InjectPositionRequestRepository(IPositionRequestRepository positionRequestRepository);

    void createPositionRequest(PositionRequestDto positionRequestDto);

    PositionRequestDto getPositionRequestById(Long id);

    List<PositionRequestDto> getAllPositionRequests();

    void updatePositionRequest(PositionRequestDto positionRequestDto);

    void deletePositionRequest(PositionRequestDto positionRequestDto);

    void deletePositionRequestByPositionId(PositionRequestDto positionRequestDto);

    List<RequestDto> getRequestsByPositionId(Long id);
}
