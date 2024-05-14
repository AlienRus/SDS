package backend.application.interfaces.out.repository;

import backend.application.dto.LotFileDto;

import java.util.List;

public interface ILotFileRepository {
    void createLotFile(LotFileDto lotFileDto);

    LotFileDto getLotFileById(Long id);

    List<LotFileDto> getAllLotFilesByLotId(Long lotId);

    List<LotFileDto> getAllLotFiles();

    void updateLotFile(LotFileDto lotFileDto);

    void deleteLotFile(LotFileDto lotFileDto);
}
