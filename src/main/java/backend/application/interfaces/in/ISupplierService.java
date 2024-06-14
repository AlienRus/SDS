package backend.application.interfaces.in;

import backend.application.dto.SupplierDto;
import backend.application.interfaces.out.repository.ISupplierRepository;

import java.util.List;

public interface ISupplierService {
    public void InjectSupplierRepository(ISupplierRepository supplierRepository);

    void createSupplier(SupplierDto supplierDto);

    SupplierDto getSupplierById(Long id);

    SupplierDto getSupplierByEmailAndPassword(String email, String password);

    SupplierDto getSupplierByEmail(String email);

    List<SupplierDto> getAllSuppliers();

    void updateSupplier(SupplierDto supplierDto);

    void deleteSupplier(SupplierDto supplierDto);
}
