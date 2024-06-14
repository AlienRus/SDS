package backend.infrastructure.out.response.list;

public class ListRequestResponse {
    private Long id;
    private Long positionId;
    private Integer priceForOne;
    private Integer count;
    private String itemName;
    private Integer deliveryTime;
    private ListSupplierResponse supplier;

    public ListRequestResponse() {
    }

    public ListRequestResponse(Long id, Long positionId, Integer priceForOne, Integer count, String itemName,
            Integer deliveryTime, ListSupplierResponse supplier) {
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

    public ListSupplierResponse getSupplier() {
        return supplier;
    }

    public void setSupplier(ListSupplierResponse supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "ListRequestResponse [id=" + id + ", positionId=" + positionId + ", priceForOne=" + priceForOne
                + ", count=" + count + ", itemName=" + itemName + ", deliveryTime=" + deliveryTime + ", supplier="
                + supplier + "]";
    }

}
