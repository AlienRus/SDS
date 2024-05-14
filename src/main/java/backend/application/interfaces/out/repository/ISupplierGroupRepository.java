package backend.application.interfaces.out.repository;

import backend.application.dto.SupplierGroupDto;

import java.util.List;

public interface ISupplierGroupRepository {
    void createSupplierGroup(SupplierGroupDto supplierGroupDto);

    SupplierGroupDto getSupplierGroupById(Long id);

    List<SupplierGroupDto> getAllSupplierGroups();

    void updateSupplierGroup(SupplierGroupDto supplierGroupDto);

    void deleteSupplierGroup(SupplierGroupDto supplierGroupDto);
}
