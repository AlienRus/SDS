package backend.infrastructure.out.response;

import backend.application.dto.LotFileDto;

public class LotFilesResponse {
    private Long lotId;
    private String path;

    public LotFilesResponse(LotFileDto lotFileDto) {
        this.lotId = lotFileDto.getLot().getId();
        this.path = lotFileDto.getPath();
    }

    public Long getLotId() {
        return lotId;
    }

    public void setLotId(Long lotId) {
        this.lotId = lotId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
