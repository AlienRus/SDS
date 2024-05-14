package backend.application.implementation;

import backend.application.dto.PositionRequestDto;
import backend.application.dto.RequestDto;
import backend.application.interfaces.in.IPositionRequestService;
import backend.application.interfaces.out.repository.IPositionRequestRepository;

import java.util.List;

public class PositionRequestService implements IPositionRequestService {

    private IPositionRequestRepository positionRequestRepository;

    @Override
    public void InjectPositionRequestRepository(IPositionRequestRepository positionRequestRepository) {
        this.positionRequestRepository = positionRequestRepository;
    }

    @Override
    public void createPositionRequest(PositionRequestDto positionRequestDto) {
        positionRequestRepository.createPositionRequest(positionRequestDto);
    }

    @Override
    public PositionRequestDto getPositionRequestById(Long id) {
        return positionRequestRepository.getPositionRequestById(id);
    }

    @Override
    public List<PositionRequestDto> getAllPositionRequests() {
        return positionRequestRepository.getAllPositionRequests();
    }

    @Override
    public void updatePositionRequest(PositionRequestDto positionRequestDto) {
        positionRequestRepository.updatePositionRequest(positionRequestDto);
    }

    @Override
    public void deletePositionRequest(PositionRequestDto positionRequestDto) {
        positionRequestRepository.deletePositionRequest(positionRequestDto);
    }

    @Override
    public void deletePositionRequestByPositionId(PositionRequestDto positionRequestDto) {
        positionRequestRepository.deletePositionRequestByPositionId(positionRequestDto);
    }

    @Override
    public List<RequestDto> getRequestsByPositionId(Long id) {
        return positionRequestRepository.getRequestsByPositionId(id);
    }
}
