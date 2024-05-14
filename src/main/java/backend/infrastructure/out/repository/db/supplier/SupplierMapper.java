package backend.infrastructure.out.repository.db.supplier;

import backend.infrastructure.out.repository.db.typeOfBusiness.TypeOfBusinessMapper;
import backend.application.dto.SupplierDto;
import backend.infrastructure.out.repository.db.role.RoleMapper;

public class SupplierMapper {

    public static SupplierDto toDto(Supplier supplier) {
        if (supplier == null) {
            return null;
        }
        return new SupplierDto(
                supplier.getId(),
                RoleMapper.toDto(supplier.getRole()),
                supplier.getEmail(),
                supplier.getPassword(),
                TypeOfBusinessMapper.toDto(supplier.getTypeOfBusiness()),
                supplier.getCompany(),
                supplier.getFirstName(),
                supplier.getMiddleName(),
                supplier.getLastName(),
                supplier.getPhoneNumber(),
                supplier.getRegionOrAddress(),
                supplier.getNds(),
                supplier.getSite(),
                supplier.getInn(),
                supplier.getKpp(),
                supplier.getIsApproved());
    }

    public static Supplier toEntity(SupplierDto supplierDto) {
        if (supplierDto == null) {
            return null;
        }

        Supplier supplier = new Supplier();
        supplier.setId(supplierDto.getId());
        supplier.setRole(RoleMapper.toEntity(supplierDto.getRole()));
        supplier.setEmail(supplierDto.getEmail());
        supplier.setPassword(supplierDto.getPassword());
        supplier.setTypeOfBusiness(TypeOfBusinessMapper.toEntity(supplierDto.getTypeOfBusiness()));
        supplier.setCompany(supplierDto.getCompany());
        supplier.setFirstName(supplierDto.getFirstName());
        supplier.setMiddleName(supplierDto.getMiddleName());
        supplier.setLastName(supplierDto.getLastName());
        supplier.setPhoneNumber(supplierDto.getPhoneNumber());
        supplier.setRegionOrAddress(supplierDto.getRegionOrAddress());
        supplier.setNds(supplierDto.getNds());
        supplier.setSite(supplierDto.getSite());
        supplier.setInn(supplierDto.getInn());
        supplier.setKpp(supplierDto.getKpp());
        supplier.setIsApproved(supplierDto.getIsApproved());
        return supplier;
    }
}
