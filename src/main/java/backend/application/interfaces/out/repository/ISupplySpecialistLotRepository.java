package backend.application.interfaces.out.repository;

import backend.application.dto.SupplySpecialistLotDto;

import java.util.List;

public interface ISupplySpecialistLotRepository {
    void createSupplySpecialistLot(SupplySpecialistLotDto supplySpecialistLotDto);

    SupplySpecialistLotDto getSupplySpecialistLotById(Long id);

    List<SupplySpecialistLotDto> getSupplySpecialistLotsByIdAndStatus(Long id, String status);

    List<SupplySpecialistLotDto> getAllSupplySpecialistLots();

    void updateSupplySpecialistLot(SupplySpecialistLotDto supplySpecialistLotDto);

    void deleteSupplySpecialistLot(SupplySpecialistLotDto supplySpecialistLotDto);
}
