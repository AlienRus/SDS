package backend.infrastructure.out.response;

import backend.application.dto.LotPositionDto;

public class PositionByLotIdResponse {
    private Long id;
    private String itemName;
    private Integer priceForOne;
    private Integer count;
    private String unitName;
    private Long winner;

    public PositionByLotIdResponse(LotPositionDto lotPositionDto) {
        this.id = lotPositionDto.getId();
        this.itemName = lotPositionDto.getPosition().getItemName();
        this.priceForOne = lotPositionDto.getPosition().getPriceForOne();
        this.count = lotPositionDto.getPosition().getCount();
        this.unitName = lotPositionDto.getPosition().getUnitName();
        if (lotPositionDto.getPosition().getWinner() == null) {
            this.winner = null;
        } else {
            this.winner = lotPositionDto.getPosition().getWinner().getId();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getWinner() {
        return winner;
    }

    public void setWinner(Long winner) {
        this.winner = winner;
    }
}
