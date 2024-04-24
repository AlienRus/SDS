package backend.infrastructure.out.repository.db.supplierNotification;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.SupplierNotificationDto;

@Stateless
public class SupplierNotificationRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createSupplierNotification(SupplierNotificationDto supplierNotificationDto) {
        SupplierNotification supplierNotification = SupplierNotificationMapper.toEntity(supplierNotificationDto);
        entityManager.persist(supplierNotification);
    }

    public SupplierNotificationDto getSupplierNotificationById(Long id) {
        SupplierNotification supplierNotification = entityManager.find(SupplierNotification.class, id);
        return SupplierNotificationMapper.toDto(supplierNotification);
    }

    public List<SupplierNotificationDto> getAllSupplierNotifications() {
        List<SupplierNotification> supplierNotifications = entityManager
                .createQuery("SELECT sn FROM SupplierNotification sn", SupplierNotification.class).getResultList();
        return supplierNotifications.stream().map(SupplierNotificationMapper::toDto).collect(Collectors.toList());
    }

    public void updateSupplierNotification(SupplierNotificationDto supplierNotificationDto) {
        SupplierNotification supplierNotification = SupplierNotificationMapper.toEntity(supplierNotificationDto);
        entityManager.merge(supplierNotification);
    }

    public void deleteSupplierNotification(SupplierNotificationDto supplierNotificationDto) {
        SupplierNotification supplierNotification = SupplierNotificationMapper.toEntity(supplierNotificationDto);
        entityManager.remove(entityManager.contains(supplierNotification) ? supplierNotification
                : entityManager.merge(supplierNotification));
    }
}
