package backend.application.interfaces.in;

import backend.application.dto.PositionDto;
import backend.application.interfaces.out.repository.IPositionRepository;

import java.util.List;

public interface IPositionService {
    public void InjectPositionRepository(IPositionRepository positionRepository);

    void createPosition(PositionDto positionDto);

    PositionDto getPositionById(Long id);

    List<PositionDto> getAllPositions();

    void updatePosition(PositionDto positionDto);

    void deletePosition(PositionDto positionDto);
}
