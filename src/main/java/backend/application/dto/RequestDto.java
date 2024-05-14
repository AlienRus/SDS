package backend.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class RequestDto implements Serializable {
    private Long id;
    private Integer priceForOne;
    private Integer count;
    private String itemName;
    private Integer deliveryTime;
    private SupplierDto supplier;

    public RequestDto() {

    }

    public RequestDto(Integer priceForOne, Integer count, String itemName, Integer deliveryTime,
            SupplierDto supplier) {
        this.priceForOne = priceForOne;
        this.count = count;
        this.itemName = itemName;
        this.deliveryTime = deliveryTime;
        this.supplier = supplier;
    }

    public RequestDto(Long id, Integer priceForOne, Integer count, String itemName, Integer deliveryTime,
            SupplierDto supplier) {
        this.id = id;
        this.priceForOne = priceForOne;
        this.count = count;
        this.itemName = itemName;
        this.deliveryTime = deliveryTime;
        this.supplier = supplier;
    }

    public Long getId() {
        return id;
    }

    public Integer getPriceForOne() {
        return priceForOne;
    }

    public Integer getCount() {
        return count;
    }

    public String getItemName() {
        return itemName;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public SupplierDto getSupplier() {
        return supplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        RequestDto entity = (RequestDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.priceForOne, entity.priceForOne) &&
                Objects.equals(this.count, entity.count) &&
                Objects.equals(this.itemName, entity.itemName) &&
                Objects.equals(this.deliveryTime, entity.deliveryTime) &&
                Objects.equals(this.supplier, entity.supplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, priceForOne, count, itemName, deliveryTime, supplier);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "priceForOne = " + priceForOne + ", " +
                "count = " + count + ", " +
                "itemName = " + itemName + ", " +
                "deliveryTime = " + deliveryTime + ", " +
                "supplier = " + supplier + ")";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPriceForOne(Integer priceForOne) {
        this.priceForOne = priceForOne;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public void setSupplier(SupplierDto supplier) {
        this.supplier = supplier;
    }
}