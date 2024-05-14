package backend.application.interfaces.out.repository;

import backend.application.dto.PositionRequestDto;
import backend.application.dto.RequestDto;

import java.util.List;

public interface IPositionRequestRepository {
    void createPositionRequest(PositionRequestDto positionRequestDto);

    PositionRequestDto getPositionRequestById(Long id);

    List<PositionRequestDto> getAllPositionRequests();

    void updatePositionRequest(PositionRequestDto positionRequestDto);

    void deletePositionRequest(PositionRequestDto positionRequestDto);

    void deletePositionRequestByPositionId(PositionRequestDto positionRequestDto);

    List<RequestDto> getRequestsByPositionId(Long id);
}
