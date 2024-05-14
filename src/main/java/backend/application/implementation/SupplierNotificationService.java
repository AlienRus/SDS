package backend.application.implementation;

import backend.application.dto.SupplierNotificationDto;
import backend.application.interfaces.in.ISupplierNotificationService;
import backend.application.interfaces.out.repository.ISupplierNotificationRepository;

import java.util.List;

public class SupplierNotificationService implements ISupplierNotificationService {

    private ISupplierNotificationRepository supplierNotificationRepository;

    @Override
    public void InjectSupplierNotificationRepository(ISupplierNotificationRepository supplierNotificationRepository) {
        this.supplierNotificationRepository = supplierNotificationRepository;
    }

    @Override
    public void createSupplierNotification(SupplierNotificationDto supplierNotificationDto) {
        supplierNotificationRepository.createSupplierNotification(supplierNotificationDto);
    }

    @Override
    public SupplierNotificationDto getSupplierNotificationById(Long id) {
        return supplierNotificationRepository.getSupplierNotificationById(id);
    }

    @Override
    public List<SupplierNotificationDto> getAllSupplierNotifications() {
        return supplierNotificationRepository.getAllSupplierNotifications();
    }

    @Override
    public void updateSupplierNotification(SupplierNotificationDto supplierNotificationDto) {
        supplierNotificationRepository.updateSupplierNotification(supplierNotificationDto);
    }

    @Override
    public void deleteSupplierNotification(SupplierNotificationDto supplierNotificationDto) {
        supplierNotificationRepository.deleteSupplierNotification(supplierNotificationDto);
    }
}
