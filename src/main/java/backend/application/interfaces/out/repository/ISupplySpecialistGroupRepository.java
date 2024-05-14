package backend.application.interfaces.out.repository;

import backend.application.dto.SupplySpecialistGroupDto;

import java.util.List;

public interface ISupplySpecialistGroupRepository {
    void createSupplySpecialistGroup(SupplySpecialistGroupDto supplySpecialistGroupDto);

    SupplySpecialistGroupDto getSupplySpecialistGroupById(Long id);

    List<SupplySpecialistGroupDto> getAllSupplySpecialistGroups();

    void updateSupplySpecialistGroup(SupplySpecialistGroupDto supplySpecialistGroupDto);

    void deleteSupplySpecialistGroup(SupplySpecialistGroupDto supplySpecialistGroupDto);
}
