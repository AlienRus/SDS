package backend.infrastructure.out.repository.db.position;

import backend.infrastructure.out.repository.db.lot.Lot;
import backend.infrastructure.out.repository.db.supplier.Supplier;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Position", indexes = {
        @Index(name = "winner", columnList = "winner"),
        @Index(name = "lot_id", columnList = "lot_id")
})
public class Position {
    @Id
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 256)
    @NotNull
    @Column(name = "item_name", nullable = false, length = 256)
    private String itemName;

    @NotNull
    @Column(name = "price_for_one", nullable = false)
    private Integer priceForOne;

    @NotNull
    @Column(name = "count", nullable = false)
    private Integer count;

    @Size(max = 16)
    @NotNull
    @Column(name = "unit_name", nullable = false, length = 16)
    private String unitName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "winner", nullable = true)
    private Supplier winner;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "lot_id", nullable = false)
    private Lot lot;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getPriceForOne() {
        return priceForOne;
    }

    public void setPriceForOne(Integer priceForOne) {
        this.priceForOne = priceForOne;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Supplier getWinner() {
        return winner;
    }

    public void setWinner(Supplier winner) {
        this.winner = winner;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

}