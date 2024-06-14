package backend.application.implementation;

import backend.application.dto.SupplierDto;
import backend.application.interfaces.in.ISupplierService;
import backend.application.interfaces.out.repository.ISupplierRepository;

import java.util.List;

public class SupplierService implements ISupplierService {

    private ISupplierRepository supplierRepository;

    @Override
    public void InjectSupplierRepository(ISupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void createSupplier(SupplierDto supplierDto) {
        supplierRepository.createSupplier(supplierDto);
    }

    @Override
    public SupplierDto getSupplierById(Long id) {
        return supplierRepository.getSupplierById(id);
    }

    @Override
    public List<SupplierDto> getAllSuppliers() {
        return supplierRepository.getAllSuppliers();
    }

    @Override
    public void updateSupplier(SupplierDto supplierDto) {
        supplierRepository.updateSupplier(supplierDto);
    }

    @Override
    public void deleteSupplier(SupplierDto supplierDto) {
        supplierRepository.deleteSupplier(supplierDto);
    }

    @Override
    public SupplierDto getSupplierByEmailAndPassword(String email, String password) {
        return supplierRepository.getSupplierByEmailAndPassword(email, password);
    }

    @Override
    public SupplierDto getSupplierByEmail(String email) {
        return supplierRepository.getSupplierByEmail(email);
    }
}
