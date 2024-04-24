package backend.infrastructure.out.repository.db.supplySpecialistLot;

import backend.infrastructure.out.repository.db.lot.Lot;
import backend.infrastructure.out.repository.db.supplySpecialist.SupplySpecialist;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Supply_specialist_Lots", indexes = {
        @Index(name = "supply_specialist_id", columnList = "supply_specialist_id"),
        @Index(name = "lot_id", columnList = "lot_id")
})
public class SupplySpecialistLot {
    @Id
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supply_specialist_id", nullable = false)
    private SupplySpecialist supplySpecialist;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lot_id", nullable = false)
    private Lot lot;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SupplySpecialist getSupplySpecialist() {
        return supplySpecialist;
    }

    public void setSupplySpecialist(SupplySpecialist supplySpecialist) {
        this.supplySpecialist = supplySpecialist;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

}