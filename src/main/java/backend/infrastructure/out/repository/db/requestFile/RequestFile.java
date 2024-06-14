package backend.infrastructure.out.repository.db.requestFile;

import backend.infrastructure.out.repository.db.supplier.Supplier;
import backend.infrastructure.out.repository.db.lot.Lot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Request_files", indexes = {
        @Index(name = "lot_id", columnList = "lot_id"),
        @Index(name = "supplier_id", columnList = "supplier_id")
})
public class RequestFile {
    @Id
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lot_id", nullable = false)
    private Lot lot;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @Size(max = 1024)
    @NotNull
    @Column(name = "path", nullable = false, length = 1024)
    private String path;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "RequestFile [id=" + id + ", lot=" + lot + ", supplier=" + supplier + ", path=" + path + "]";
    }

}