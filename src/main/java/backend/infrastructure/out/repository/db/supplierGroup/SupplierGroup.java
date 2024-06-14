package backend.infrastructure.out.repository.db.supplierGroup;

import backend.infrastructure.out.repository.db.groupET.GroupEt;
import backend.infrastructure.out.repository.db.supplier.Supplier;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Supplier_group", indexes = {
        @Index(name = "supplier_id", columnList = "supplier_id"),
        @Index(name = "group_id", columnList = "group_id")
})
public class SupplierGroup {
    @Id
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "group_id", nullable = false)
    private GroupEt group;

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

}