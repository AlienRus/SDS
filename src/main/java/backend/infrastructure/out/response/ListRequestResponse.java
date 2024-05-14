package backend.infrastructure.out.response;

public class ListRequestResponse {
    private Long id;
    private Integer priceForOne;
    private Integer count;
    private String itemName;
    private Integer deliveryTime;
    private ListSupplierResponse supplier;

    public ListRequestResponse(Long id, Integer priceForOne, Integer count, String itemName, Integer deliveryTime,
            ListSupplierResponse supplier) {
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

    public void setId(Long id) {
        this.id = id;
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
}
