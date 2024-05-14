package backend.application.interfaces.in;

import backend.application.dto.SupplySpecialistLotDto;
import backend.application.interfaces.out.repository.ISupplySpecialistLotRepository;

import java.util.List;

public interface ISupplySpecialistLotService {
    public void InjectSupplySpecialistLotRepository(ISupplySpecialistLotRepository supplySpecialistLotRepository);

    void createSupplySpecialistLot(SupplySpecialistLotDto supplySpecialistLotDto);

    SupplySpecialistLotDto getSupplySpecialistLotById(Long id);

    List<SupplySpecialistLotDto> getSupplySpecialistLotsByIdAndStatus(Long id, String status);

    List<SupplySpecialistLotDto> getAllSupplySpecialistLots();

    void updateSupplySpecialistLot(SupplySpecialistLotDto supplySpecialistLotDto);

    void deleteSupplySpecialistLot(SupplySpecialistLotDto supplySpecialistLotDto);
}
