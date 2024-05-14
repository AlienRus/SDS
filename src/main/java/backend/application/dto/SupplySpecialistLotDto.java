package backend.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class SupplySpecialistLotDto implements Serializable {
    private Long id;
    private SupplySpecialistDto supplySpecialist;
    private LotDto lot;

    public SupplySpecialistLotDto() {

    }

    public SupplySpecialistLotDto(Long id, SupplySpecialistDto supplySpecialist, LotDto lot) {
        this.id = id;
        this.supplySpecialist = supplySpecialist;
        this.lot = lot;
    }

    public Long getId() {
        return id;
    }

    public SupplySpecialistDto getSupplySpecialist() {
        return supplySpecialist;
    }

    public LotDto getLot() {
        return lot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SupplySpecialistLotDto entity = (SupplySpecialistLotDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.supplySpecialist, entity.supplySpecialist) &&
                Objects.equals(this.lot, entity.lot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, supplySpecialist, lot);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "supplySpecialist = " + supplySpecialist + ", " +
                "lot = " + lot + ")";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSupplySpecialist(SupplySpecialistDto supplySpecialist) {
        this.supplySpecialist = supplySpecialist;
    }

    public void setLot(LotDto lot) {
        this.lot = lot;
    }
}