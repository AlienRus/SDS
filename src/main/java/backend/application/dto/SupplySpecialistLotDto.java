package backend.application.dto;

import backend.infrastructure.out.repository.db.supplySpecialistLot.SupplySpecialistLot;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link SupplySpecialistLot}
 */
public class SupplySpecialistLotDto implements Serializable {
    private final Long id;
    private final SupplySpecialistDto supplySpecialist;
    private final LotDto lot;

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
}