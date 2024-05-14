package backend.application.interfaces.in;

import backend.application.dto.SupplierNotificationDto;
import backend.application.interfaces.out.repository.ISupplierNotificationRepository;

import java.util.List;

public interface ISupplierNotificationService {
    public void InjectSupplierNotificationRepository(ISupplierNotificationRepository supplierNotificationRepository);

    void createSupplierNotification(SupplierNotificationDto supplierNotificationDto);

    SupplierNotificationDto getSupplierNotificationById(Long id);

    List<SupplierNotificationDto> getAllSupplierNotifications();

    void updateSupplierNotification(SupplierNotificationDto supplierNotificationDto);

    void deleteSupplierNotification(SupplierNotificationDto supplierNotificationDto);
}
