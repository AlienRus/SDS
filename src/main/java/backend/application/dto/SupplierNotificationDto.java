package backend.application.dto;

import backend.infrastructure.out.repository.db.supplierNotification.SupplierNotification;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link SupplierNotification}
 */
public class SupplierNotificationDto implements Serializable {
    private final Long id;
    private final SupplierDto supplier;
    private final GroupEtDto group;
    private final Byte mail;
    private final Byte system;

    public SupplierNotificationDto(Long id, SupplierDto supplier, GroupEtDto group, Byte mail, Byte system) {
        this.id = id;
        this.supplier = supplier;
        this.group = group;
        this.mail = mail;
        this.system = system;
    }

    public Long getId() {
        return id;
    }

    public SupplierDto getSupplier() {
        return supplier;
    }

    public GroupEtDto getGroup() {
        return group;
    }

    public Byte getMail() {
        return mail;
    }

    public Byte getSystem() {
        return system;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SupplierNotificationDto entity = (SupplierNotificationDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.supplier, entity.supplier) &&
                Objects.equals(this.group, entity.group) &&
                Objects.equals(this.mail, entity.mail) &&
                Objects.equals(this.system, entity.system);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, supplier, group, mail, system);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "supplier = " + supplier + ", " +
                "group = " + group + ", " +
                "mail = " + mail + ", " +
                "system = " + system + ")";
    }
}