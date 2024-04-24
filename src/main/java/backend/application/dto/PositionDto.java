package backend.application.dto;

import backend.infrastructure.out.repository.db.position.Position;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link Position}
 */
public class PositionDto implements Serializable {
    private final Long id;
    private final String itemName;
    private final Integer priceForOne;
    private final Integer count;
    private final String unitName;
    private final SupplierDto winner;

    public PositionDto(Long id, String itemName, Integer priceForOne, Integer count, String unitName, SupplierDto winner) {
        this.id = id;
        this.itemName = itemName;
        this.priceForOne = priceForOne;
        this.count = count;
        this.unitName = unitName;
        this.winner = winner;
    }

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public Integer getPriceForOne() {
        return priceForOne;
    }

    public Integer getCount() {
        return count;
    }

    public String getUnitName() {
        return unitName;
    }

    public SupplierDto getWinner() {
        return winner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PositionDto entity = (PositionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.itemName, entity.itemName) &&
                Objects.equals(this.priceForOne, entity.priceForOne) &&
                Objects.equals(this.count, entity.count) &&
                Objects.equals(this.unitName, entity.unitName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemName, priceForOne, count, unitName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "itemName = " + itemName + ", " +
                "priceForOne = " + priceForOne + ", " +
                "count = " + count + ", " +
                "unitName = " + unitName + ")";
    }
}