package backend.infrastructure.out.repository.db.position;

import backend.application.dto.PositionDto;
import backend.infrastructure.out.repository.db.supplier.SupplierMapper;

public class PositionMapper {

    public static PositionDto toDto(Position position) {
        return new PositionDto(
                position.getId(),
                position.getItemName(),
                position.getPriceForOne(),
                position.getCount(),
                position.getUnitName(),
                SupplierMapper.toDto(position.getWinner()));
    }

    public static Position toEntity(PositionDto positionDto) {
        Position position = new Position();
        position.setId(positionDto.getId());
        position.setItemName(positionDto.getItemName());
        position.setPriceForOne(positionDto.getPriceForOne());
        position.setCount(positionDto.getCount());
        position.setUnitName(positionDto.getUnitName());
        
        position.setWinner(SupplierMapper.toEntity(positionDto.getWinner()));
        return position;
    }
}
