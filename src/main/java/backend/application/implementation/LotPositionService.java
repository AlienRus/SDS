package backend.application.implementation;

import backend.application.dto.LotPositionDto;
import backend.application.interfaces.in.ILotPositionService;
import backend.application.interfaces.out.repository.ILotPositionRepository;

import java.util.List;

public class LotPositionService implements ILotPositionService {

    private ILotPositionRepository lotPositionRepository;

    @Override
    public void InjectLotPositionRepository(ILotPositionRepository lotPositionRepository) {
        this.lotPositionRepository = lotPositionRepository;
    }

    @Override
    public void createLotPosition(LotPositionDto lotPositionDto) {
        lotPositionRepository.createLotPosition(lotPositionDto);
    }

    @Override
    public LotPositionDto getLotPositionById(Long id) {
        return lotPositionRepository.getLotPositionById(id);
    }

    @Override
    public List<LotPositionDto> getLotPositionsByLotId(Long lotId) {
        return lotPositionRepository.getLotPositionByLotId(lotId);
    }

    @Override
    public List<LotPositionDto> getAllLotPositions() {
        return lotPositionRepository.getAllLotPositions();
    }

    @Override
    public void updateLotPosition(LotPositionDto lotPositionDto) {
        lotPositionRepository.updateLotPosition(lotPositionDto);
    }

    @Override
    public void deleteLotPosition(LotPositionDto lotPositionDto) {
        lotPositionRepository.deleteLotPosition(lotPositionDto);
    }

}
