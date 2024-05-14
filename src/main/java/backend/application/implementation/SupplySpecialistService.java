package backend.application.implementation;

import backend.application.dto.SupplySpecialistDto;
import backend.application.interfaces.in.ISupplySpecialistService;
import backend.application.interfaces.out.repository.ISupplySpecialistRepository;

import java.util.List;

public class SupplySpecialistService implements ISupplySpecialistService {

    private ISupplySpecialistRepository supplySpecialistRepository;

    @Override
    public void InjectSupplySpecialistRepository(ISupplySpecialistRepository supplySpecialistRepository) {
        this.supplySpecialistRepository = supplySpecialistRepository;
    }

    @Override
    public void createSupplySpecialist(SupplySpecialistDto supplySpecialistDto) {
        supplySpecialistRepository.createSupplySpecialist(supplySpecialistDto);
    }

    @Override
    public SupplySpecialistDto getSupplySpecialistById(Long id) {
        return supplySpecialistRepository.getSupplySpecialistById(id);
    }

    @Override
    public List<SupplySpecialistDto> getAllSupplySpecialists() {
        return supplySpecialistRepository.getAllSupplySpecialists();
    }

    @Override
    public void updateSupplySpecialist(SupplySpecialistDto supplySpecialistDto) {
        supplySpecialistRepository.updateSupplySpecialist(supplySpecialistDto);
    }

    @Override
    public void deleteSupplySpecialist(SupplySpecialistDto supplySpecialistDto) {
        supplySpecialistRepository.deleteSupplySpecialist(supplySpecialistDto);
    }
}
