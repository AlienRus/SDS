package backend.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class PositionDto implements Serializable {
    private Long id;
    private String itemName;
    private Integer priceForOne;
    private Integer count;
    private String unitName;
    private SupplierDto winner;
    private LotDto lot;

    public PositionDto() {

    }

    public PositionDto(String itemName, Integer priceForOne, Integer count, String unitName, LotDto lot) {
        this.itemName = itemName;
        this.priceForOne = priceForOne;
        this.count = count;
        this.unitName = unitName;
        this.lot = lot;
    }

    public PositionDto(Long id, String itemName, Integer priceForOne, Integer count, String unitName,
            SupplierDto winner, LotDto lot) {
        this.id = id;
        this.itemName = itemName;
        this.priceForOne = priceForOne;
        this.count = count;
        this.unitName = unitName;
        this.winner = winner;
        this.lot = lot;
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

    public LotDto getLot() {
        return lot;
    }

    public void setLot(LotDto lot) {
        this.lot = lot;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPriceForOne(Integer priceForOne) {
        this.priceForOne = priceForOne;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public void setWinner(SupplierDto winner) {
        this.winner = winner;
    }
}