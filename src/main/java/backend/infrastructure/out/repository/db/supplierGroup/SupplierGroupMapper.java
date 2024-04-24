package backend.infrastructure.out.repository.db.supplierGroup;

import backend.application.dto.SupplierGroupDto;
import backend.infrastructure.out.repository.db.groupET.GroupEtMapper;
import backend.infrastructure.out.repository.db.supplier.SupplierMapper;

public class SupplierGroupMapper {

    public static SupplierGroupDto toDto(SupplierGroup supplierGroup) {
        return new SupplierGroupDto(
                supplierGroup.getId(),
                SupplierMapper.toDto(supplierGroup.getSupplier()),
                GroupEtMapper.toDto(supplierGroup.getGroup()));
    }

    public static SupplierGroup toEntity(SupplierGroupDto supplierGroupDto) {
        SupplierGroup supplierGroup = new SupplierGroup();
        supplierGroup.setId(supplierGroupDto.getId());
        supplierGroup.setSupplier(SupplierMapper.toEntity(supplierGroupDto.getSupplier()));
        supplierGroup.setGroup(GroupEtMapper.toEntity(supplierGroupDto.getGroup()));
        return supplierGroup;
    }
}
