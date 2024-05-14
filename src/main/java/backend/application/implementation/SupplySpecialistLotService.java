package backend.application.implementation;

import backend.application.dto.SupplySpecialistLotDto;
import backend.application.interfaces.in.ISupplySpecialistLotService;
import backend.application.interfaces.out.repository.ISupplySpecialistLotRepository;

import java.util.List;

public class SupplySpecialistLotService implements ISupplySpecialistLotService {

    private ISupplySpecialistLotRepository supplySpecialistLotRepository;

    @Override
    public void InjectSupplySpecialistLotRepository(ISupplySpecialistLotRepository supplySpecialistLotRepository) {
        this.supplySpecialistLotRepository = supplySpecialistLotRepository;
    }

    @Override
    public void createSupplySpecialistLot(SupplySpecialistLotDto supplySpecialistLotDto) {
        supplySpecialistLotRepository.createSupplySpecialistLot(supplySpecialistLotDto);
    }

    @Override
    public SupplySpecialistLotDto getSupplySpecialistLotById(Long id) {
        return supplySpecialistLotRepository.getSupplySpecialistLotById(id);
    }

    @Override
    public List<SupplySpecialistLotDto> getSupplySpecialistLotsByIdAndStatus(Long id, String status) {
        return supplySpecialistLotRepository.getSupplySpecialistLotsByIdAndStatus(id, status);
    }

    @Override
    public List<SupplySpecialistLotDto> getAllSupplySpecialistLots() {
        return supplySpecialistLotRepository.getAllSupplySpecialistLots();
    }

    @Override
    public void updateSupplySpecialistLot(SupplySpecialistLotDto supplySpecialistLotDto) {
        supplySpecialistLotRepository.updateSupplySpecialistLot(supplySpecialistLotDto);
    }

    @Override
    public void deleteSupplySpecialistLot(SupplySpecialistLotDto supplySpecialistLotDto) {
        supplySpecialistLotRepository.deleteSupplySpecialistLot(supplySpecialistLotDto);
    }
}
