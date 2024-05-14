package backend.application.interfaces.out.repository;

import backend.application.dto.LotPositionDto;

import java.util.List;

public interface ILotPositionRepository {
    void createLotPosition(LotPositionDto lotPositionDto);

    LotPositionDto getLotPositionById(Long id);

    List<LotPositionDto> getLotPositionByLotId(Long lotId);

    List<LotPositionDto> getAllLotPositions();

    void updateLotPosition(LotPositionDto lotPositionDto);

    void deleteLotPosition(LotPositionDto lotPositionDto);
}
