package backend.infrastructure.in.rest.request.put.request;

public class UpdateRequestRequest {
    private Integer priceForOne;
    private Integer count;
    private String itemName;
    private Integer deliveryTime;

    public UpdateRequestRequest() {
    }

    public UpdateRequestRequest(Integer priceForOne, Integer count, String itemName, Integer deliveryTime) {
        this.priceForOne = priceForOne;
        this.count = count;
        this.itemName = itemName;
        this.deliveryTime = deliveryTime;
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
}
