package backend.application.implementation;

import backend.application.dto.PositionDto;
import backend.application.interfaces.in.IPositionService;
import backend.application.interfaces.out.repository.IPositionRepository;

import java.util.List;

public class PositionService implements IPositionService {

    private IPositionRepository positionRepository;

    @Override
    public void InjectPositionRepository(IPositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public void createPosition(PositionDto positionDto) {
        positionRepository.createPosition(positionDto);
    }

    @Override
    public PositionDto getPositionById(Long id) {
        return positionRepository.getPositionById(id);
    }

    @Override
    public List<PositionDto> getAllPositions() {
        return positionRepository.getAllPositions();
    }

    @Override
    public void updatePosition(PositionDto positionDto) {
        positionRepository.updatePosition(positionDto);
    }

    @Override
    public void deletePosition(PositionDto positionDto) {
        positionRepository.deletePosition(positionDto);
    }
}
