package backend.infrastructure.in.rest.request;

public class NewRequestRequestDto {
    private Integer priceForOne;
    private Integer count;
    private String itemName;
    private Integer deliveryTime;
    private NewRequestFileRequestDto requestFiles;
    private LotRuleRequestDto requestRules;

    public NewRequestRequestDto(Integer priceForOne, Integer count, String itemName, Integer deliveryTime,
            NewRequestFileRequestDto requestFiles, LotRuleRequestDto requestRules) {
        this.priceForOne = priceForOne;
        this.count = count;
        this.itemName = itemName;
        this.deliveryTime = deliveryTime;
        this.requestFiles = requestFiles;
        this.requestRules = requestRules;
    }

    public NewRequestRequestDto() {
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

    public NewRequestFileRequestDto getRequestFiles() {
        return requestFiles;
    }

    public void setRequestFiles(NewRequestFileRequestDto requestFiles) {
        this.requestFiles = requestFiles;
    }

    public LotRuleRequestDto getRequestRules() {
        return requestRules;
    }

    public void setRequestRules(LotRuleRequestDto requestRules) {
        this.requestRules = requestRules;
    }
}
