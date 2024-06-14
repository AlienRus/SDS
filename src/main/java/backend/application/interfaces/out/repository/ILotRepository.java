package backend.application.interfaces.out.repository;

import backend.application.dto.LotDto;

import java.util.List;

public interface ILotRepository {
    void createLot(LotDto lotDto);

    LotDto getLotById(Long id);

    List<LotDto> getAllLots();

    List<LotDto> getAllLotsByGroup(Long groupId);

    Long getLatestLotId();

    void updateLot(LotDto lotDto);

    void deleteLot(LotDto lotDto);
}
