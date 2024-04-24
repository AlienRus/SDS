package backend.infrastructure.out.repository.db.requestRule;

import backend.infrastructure.out.repository.db.supplier.Supplier;
import backend.infrastructure.out.repository.db.lot.Lot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Request_rules", indexes = {
        @Index(name = "lot_id", columnList = "lot_id"),
        @Index(name = "supplier", columnList = "supplier")
})
public class RequestRule {
    @Id
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lot_id", nullable = false)
    private Lot lot;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supplier", nullable = false)
    private Supplier supplier;

    @Size(max = 256)
    @Column(name = "comment", length = 256)
    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}