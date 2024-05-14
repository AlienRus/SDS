package backend.application.interfaces.in;

import backend.application.dto.SupplySpecialistDto;
import backend.application.interfaces.out.repository.ISupplySpecialistRepository;

import java.util.List;

public interface ISupplySpecialistService {
    public void InjectSupplySpecialistRepository(ISupplySpecialistRepository supplySpecialistRepository);

    void createSupplySpecialist(SupplySpecialistDto supplySpecialistDto);

    SupplySpecialistDto getSupplySpecialistById(Long id);

    List<SupplySpecialistDto> getAllSupplySpecialists();

    void updateSupplySpecialist(SupplySpecialistDto supplySpecialistDto);

    void deleteSupplySpecialist(SupplySpecialistDto supplySpecialistDto);
}
