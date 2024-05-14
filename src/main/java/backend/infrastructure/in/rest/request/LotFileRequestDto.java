package backend.infrastructure.in.rest.request;

public class LotFileRequestDto {
    private Long lotId;
    private String path;

    public LotFileRequestDto(Long lotId, String path) {
        this.lotId = lotId;
        this.path = path;
    }

    public LotFileRequestDto() {
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

    @Override
    public String toString() {
        return "LotFileRequestDto [lotId=" + lotId + ", path=" + path + "]";
    }
}
