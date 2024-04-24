package backend.infrastructure.out.repository.db.lotFile;

import backend.application.dto.LotFileDto;
import backend.infrastructure.out.repository.db.lot.LotMapper;

public class LotFileMapper {

    public static LotFileDto toDto(LotFile lotFile) {
        return new LotFileDto(
                lotFile.getId(),
                LotMapper.toDto(lotFile.getLot()),
                lotFile.getPath());
    }

    public static LotFile toEntity(LotFileDto lotFileDto) {
        LotFile lotFile = new LotFile();
        lotFile.setId(lotFileDto.getId());
        lotFile.setLot(LotMapper.toEntity(lotFileDto.getLot()));
        lotFile.setPath(lotFileDto.getPath());
        return lotFile;
    }
}