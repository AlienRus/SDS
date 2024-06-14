package backend.infrastructure.in.rest.request;

import java.util.List;

public class AddPositionsToLotRequestDto {
    private List<AddPositionsToLotRequestDataDto> data;

    public AddPositionsToLotRequestDto() {
    }

    public AddPositionsToLotRequestDto(List<AddPositionsToLotRequestDataDto> data) {
        this.data = data;
    }

    public List<AddPositionsToLotRequestDataDto> getData() {
        return data;
    }

    public void setData(List<AddPositionsToLotRequestDataDto> data) {
        this.data = data;
    }
}
