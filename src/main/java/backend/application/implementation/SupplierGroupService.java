package backend.application.implementation;

import backend.application.dto.SupplierGroupDto;
import backend.application.interfaces.in.ISupplierGroupService;
import backend.application.interfaces.out.repository.ISupplierGroupRepository;

import java.util.List;

public class SupplierGroupService implements ISupplierGroupService {

    private ISupplierGroupRepository supplierGroupRepository;

    @Override
    public void InjectSupplierGroupRepository(ISupplierGroupRepository supplierGroupRepository) {
        this.supplierGroupRepository = supplierGroupRepository;
    }

    @Override
    public void createSupplierGroup(SupplierGroupDto supplierGroupDto) {
        supplierGroupRepository.createSupplierGroup(supplierGroupDto);
    }

    @Override
    public SupplierGroupDto getSupplierGroupById(Long id) {
        return supplierGroupRepository.getSupplierGroupById(id);
    }

    @Override
    public List<SupplierGroupDto> getAllSupplierGroups() {
        return supplierGroupRepository.getAllSupplierGroups();
    }

    @Override
    public void updateSupplierGroup(SupplierGroupDto supplierGroupDto) {
        supplierGroupRepository.updateSupplierGroup(supplierGroupDto);
    }

    @Override
    public void deleteSupplierGroup(SupplierGroupDto supplierGroupDto) {
        supplierGroupRepository.deleteSupplierGroup(supplierGroupDto);
    }
}
