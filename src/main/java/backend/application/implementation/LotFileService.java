package backend.application.implementation;

import backend.application.dto.LotFileDto;
import backend.application.interfaces.in.ILotFileService;
import backend.application.interfaces.out.repository.ILotFileRepository;

import java.util.List;

public class LotFileService implements ILotFileService {

    private ILotFileRepository lotFileRepository;

    @Override
    public void InjectLotFileRepository(ILotFileRepository lotFileRepository) {
        this.lotFileRepository = lotFileRepository;
    }

    @Override
    public void createLotFile(LotFileDto lotFileDto) {
        lotFileRepository.createLotFile(lotFileDto);
    }

    @Override
    public LotFileDto getLotFileById(Long id) {
        return lotFileRepository.getLotFileById(id);
    }

    @Override
    public List<LotFileDto> getAllLotFilesByLotId(Long lotId) {
        return lotFileRepository.getAllLotFilesByLotId(lotId);
    }

    @Override
    public List<LotFileDto> getAllLotFiles() {
        return lotFileRepository.getAllLotFiles();
    }

    @Override
    public void updateLotFile(LotFileDto lotFileDto) {
        lotFileRepository.updateLotFile(lotFileDto);
    }

    @Override
    public void deleteLotFile(LotFileDto lotFileDto) {
        lotFileRepository.deleteLotFile(lotFileDto);
    }
}
