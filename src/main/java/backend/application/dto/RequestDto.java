package backend.application.dto;

import backend.infrastructure.out.repository.db.request.Request;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link Request}
 */
public class RequestDto implements Serializable {
    private final Long id;
    private final Integer priceForOne;
    private final Integer count;
    private final String itemName;
    private final Integer deliveryTime;
    private final SupplierDto supplier;

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
}