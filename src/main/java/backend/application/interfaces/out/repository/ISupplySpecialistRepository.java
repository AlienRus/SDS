package backend.application.interfaces.out.repository;

import backend.application.dto.SupplySpecialistDto;

import java.util.List;

public interface ISupplySpecialistRepository {
    void createSupplySpecialist(SupplySpecialistDto supplySpecialistDto);

    SupplySpecialistDto getSupplySpecialistById(Long id);

    List<SupplySpecialistDto> getAllSupplySpecialists();

    void updateSupplySpecialist(SupplySpecialistDto supplySpecialistDto);

    void deleteSupplySpecialist(SupplySpecialistDto supplySpecialistDto);
}
