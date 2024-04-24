package backend.infrastructure.out.repository.db.supplierNotification;

import backend.application.dto.SupplierNotificationDto;
import backend.infrastructure.out.repository.db.groupET.GroupEtMapper;
import backend.infrastructure.out.repository.db.supplier.SupplierMapper;

public class SupplierNotificationMapper {

    public static SupplierNotificationDto toDto(SupplierNotification supplierNotification) {
        return new SupplierNotificationDto(
                supplierNotification.getId(),
                SupplierMapper.toDto(supplierNotification.getSupplier()),
                GroupEtMapper.toDto(supplierNotification.getGroup()),
                supplierNotification.getMail(),
                supplierNotification.getSystem());
    }

    public static SupplierNotification toEntity(SupplierNotificationDto supplierNotificationDto) {
        SupplierNotification supplierNotification = new SupplierNotification();
        supplierNotification.setId(supplierNotificationDto.getId());
        supplierNotification.setSupplier(SupplierMapper.toEntity(supplierNotificationDto.getSupplier()));
        supplierNotification.setGroup(GroupEtMapper.toEntity(supplierNotificationDto.getGroup()));
        supplierNotification.setMail(supplierNotificationDto.getMail());
        supplierNotification.setSystem(supplierNotificationDto.getSystem());
        return supplierNotification;
    }
}
