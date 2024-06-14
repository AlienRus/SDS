package backend.infrastructure.in.rest.request;

public class AddPositionsToLotRequestDataDto {
    private String itemName;
    private Integer priceForOne;
    private Integer count;
    private String unitName;

    public AddPositionsToLotRequestDataDto() {
    }

    public AddPositionsToLotRequestDataDto(String itemName, Integer priceForOne, Integer count, String unitName) {
        this.itemName = itemName;
        this.priceForOne = priceForOne;
        this.count = count;
        this.unitName = unitName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
