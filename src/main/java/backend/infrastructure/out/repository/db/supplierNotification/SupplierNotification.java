package backend.infrastructure.out.repository.db.supplierNotification;

import backend.infrastructure.out.repository.db.groupET.GroupEt;
import backend.infrastructure.out.repository.db.supplier.Supplier;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Supplier_Notifications", indexes = {
        @Index(name = "supplier_id", columnList = "supplier_id"),
        @Index(name = "group_id", columnList = "group_id")
})
public class SupplierNotification {
    @Id
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "group_id", nullable = false)
    private GroupEt group;

    @NotNull
    @Column(name = "mail", nullable = false)
    private Byte mail;

    @NotNull
    @Column(name = "system", nullable = false)
    private Byte system;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public GroupEt getGroup() {
        return group;
    }

    public void setGroup(GroupEt group) {
        this.group = group;
    }

    public Byte getMail() {
        return mail;
    }

    public void setMail(Byte mail) {
        this.mail = mail;
    }

    public Byte getSystem() {
        return system;
    }

    public void setSystem(Byte system) {
        this.system = system;
    }

}