package backend.application.interfaces.in;

import backend.application.dto.SupplySpecialistGroupDto;
import backend.application.interfaces.out.repository.ISupplySpecialistGroupRepository;

import java.util.List;

public interface ISupplySpecialistGroupService {
    public void InjectSupplySpecialistGroupRepository(
            ISupplySpecialistGroupRepository supplySpecialistGroupRepository);

    void createSupplySpecialistGroup(SupplySpecialistGroupDto supplySpecialistGroupDto);

    SupplySpecialistGroupDto getSupplySpecialistGroupById(Long id);

    List<SupplySpecialistGroupDto> getAllSupplySpecialistGroups();

    void updateSupplySpecialistGroup(SupplySpecialistGroupDto supplySpecialistGroupDto);

    void deleteSupplySpecialistGroup(SupplySpecialistGroupDto supplySpecialistGroupDto);
}
