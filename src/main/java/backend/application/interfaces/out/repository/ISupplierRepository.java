package backend.application.interfaces.out.repository;

import backend.application.dto.SupplierDto;

import java.util.List;

public interface ISupplierRepository {
    void createSupplier(SupplierDto supplierDto);

    SupplierDto getSupplierById(Long id);

    List<SupplierDto> getAllSuppliers();

    void updateSupplier(SupplierDto supplierDto);

    void deleteSupplier(SupplierDto supplierDto);
}
