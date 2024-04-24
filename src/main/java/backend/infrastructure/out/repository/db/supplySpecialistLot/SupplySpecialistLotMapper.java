package backend.infrastructure.out.repository.db.supplySpecialistLot;

import backend.application.dto.SupplySpecialistLotDto;
import backend.infrastructure.out.repository.db.lot.LotMapper;
import backend.infrastructure.out.repository.db.supplySpecialist.SupplySpecialistMapper;

public class SupplySpecialistLotMapper {

    public static SupplySpecialistLotDto toDto(SupplySpecialistLot supplySpecialistLot) {
        return new SupplySpecialistLotDto(
                supplySpecialistLot.getId(),
                SupplySpecialistMapper.toDto(supplySpecialistLot.getSupplySpecialist()),
                LotMapper.toDto(supplySpecialistLot.getLot()));
    }

    public static SupplySpecialistLot toEntity(SupplySpecialistLotDto supplySpecialistLotDto) {
        SupplySpecialistLot supplySpecialistLot = new SupplySpecialistLot();
        supplySpecialistLot.setId(supplySpecialistLotDto.getId());
        supplySpecialistLot
                .setSupplySpecialist(SupplySpecialistMapper.toEntity(supplySpecialistLotDto.getSupplySpecialist()));
        supplySpecialistLot.setLot(LotMapper.toEntity(supplySpecialistLotDto.getLot()));
        return supplySpecialistLot;
    }
}
