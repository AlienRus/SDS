package backend.application.interfaces.out.repository;

import backend.application.dto.PositionDto;

import java.util.List;

public interface IPositionRepository {
    void createPosition(PositionDto positionDto);

    PositionDto getPositionById(Long id);

    List<PositionDto> getAllPositions();

    void updatePosition(PositionDto positionDto);

    void deletePosition(PositionDto positionDto);
}
