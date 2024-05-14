package backend.application.interfaces.out.repository;

import backend.application.dto.SupplierNotificationDto;

import java.util.List;

public interface ISupplierNotificationRepository {
    void createSupplierNotification(SupplierNotificationDto supplierNotificationDto);

    SupplierNotificationDto getSupplierNotificationById(Long id);

    List<SupplierNotificationDto> getAllSupplierNotifications();

    void updateSupplierNotification(SupplierNotificationDto supplierNotificationDto);

    void deleteSupplierNotification(SupplierNotificationDto supplierNotificationDto);
}
