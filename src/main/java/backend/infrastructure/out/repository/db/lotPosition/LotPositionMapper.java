package backend.infrastructure.out.repository.db.lotPosition;

import backend.infrastructure.out.repository.db.position.PositionMapper;
import backend.application.dto.LotPositionDto;
import backend.infrastructure.out.repository.db.lot.LotMapper;

public class LotPositionMapper {

    public static LotPositionDto toDto(LotPosition lotPosition) {
        return new LotPositionDto(
                lotPosition.getId(),
                LotMapper.toDto(lotPosition.getLot()),
                PositionMapper.toDto(lotPosition.getPosition()));
    }

    public static LotPosition toEntity(LotPositionDto lotPositionDto) {
        LotPosition lotPosition = new LotPosition();
        lotPosition.setId(lotPositionDto.getId());
        lotPosition.setLot(LotMapper.toEntity(lotPositionDto.getLot()));
        lotPosition.setPosition(PositionMapper.toEntity(lotPositionDto.getPosition()));
        return lotPosition;
    }
}
