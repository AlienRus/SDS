package backend.application.interfaces.in;

import backend.application.dto.SupplierGroupDto;
import backend.application.interfaces.out.repository.ISupplierGroupRepository;

import java.util.List;

public interface ISupplierGroupService {
    public void InjectSupplierGroupRepository(ISupplierGroupRepository supplierGroupRepository);

    void createSupplierGroup(SupplierGroupDto supplierGroupDto);

    SupplierGroupDto getSupplierGroupById(Long id);

    List<SupplierGroupDto> getAllSupplierGroups();

    void updateSupplierGroup(SupplierGroupDto supplierGroupDto);

    void deleteSupplierGroup(SupplierGroupDto supplierGroupDto);
}
