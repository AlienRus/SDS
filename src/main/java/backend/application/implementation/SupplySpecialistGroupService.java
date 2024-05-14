package backend.application.implementation;

import backend.application.dto.SupplySpecialistGroupDto;
import backend.application.interfaces.in.ISupplySpecialistGroupService;
import backend.application.interfaces.out.repository.ISupplySpecialistGroupRepository;

import java.util.List;

public class SupplySpecialistGroupService implements ISupplySpecialistGroupService {

    private ISupplySpecialistGroupRepository supplySpecialistGroupRepository;

    @Override
    public void InjectSupplySpecialistGroupRepository(
            ISupplySpecialistGroupRepository supplySpecialistGroupRepository) {
        this.supplySpecialistGroupRepository = supplySpecialistGroupRepository;
    }

    @Override
    public void createSupplySpecialistGroup(SupplySpecialistGroupDto supplySpecialistGroupDto) {
        supplySpecialistGroupRepository.createSupplySpecialistGroup(supplySpecialistGroupDto);
    }

    @Override
    public SupplySpecialistGroupDto getSupplySpecialistGroupById(Long id) {
        return supplySpecialistGroupRepository.getSupplySpecialistGroupById(id);
    }

    @Override
    public List<SupplySpecialistGroupDto> getAllSupplySpecialistGroups() {
        return supplySpecialistGroupRepository.getAllSupplySpecialistGroups();
    }

    @Override
    public void updateSupplySpecialistGroup(SupplySpecialistGroupDto supplySpecialistGroupDto) {
        supplySpecialistGroupRepository.updateSupplySpecialistGroup(supplySpecialistGroupDto);
    }

    @Override
    public void deleteSupplySpecialistGroup(SupplySpecialistGroupDto supplySpecialistGroupDto) {
        supplySpecialistGroupRepository.deleteSupplySpecialistGroup(supplySpecialistGroupDto);
    }
}
