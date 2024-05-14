package backend.application.interfaces.in;

import backend.application.dto.LotPositionDto;
import backend.application.interfaces.out.repository.ILotPositionRepository;

import java.util.List;

public interface ILotPositionService {
    public void InjectLotPositionRepository(ILotPositionRepository lotPositionRepository);
    
    void createLotPosition(LotPositionDto lotPositionDto);

    LotPositionDto getLotPositionById(Long id);

    List<LotPositionDto> getLotPositionsByLotId(Long lotId);

    List<LotPositionDto> getAllLotPositions();

    void updateLotPosition(LotPositionDto lotPositionDto);

    void deleteLotPosition(LotPositionDto lotPositionDto);
}
