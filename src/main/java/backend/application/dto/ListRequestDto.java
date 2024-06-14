package backend.application.dto;

import java.io.Serializable;

public class ListRequestDto implements Serializable {
    private Long id;
    private Long positionId;
    private Integer priceForOne;
    private Integer count;
    private String itemName;
    private Integer deliveryTime;
    private SupplierDto supplier;

    public ListRequestDto() {
    }

    public ListRequestDto(Long id, Long positionId, Integer priceForOne, Integer count, String itemName,
            Integer deliveryTime, SupplierDto supplier) {
        this.id = id;
        this.positionId = positionId;
        this.priceForOne = priceForOne;
        this.count = count;
        this.itemName = itemName;
        this.deliveryTime = deliveryTime;
        this.supplier = supplier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public SupplierDto getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDto supplier) {
        this.supplier = supplier;
    }
}
