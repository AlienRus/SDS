package backend.infrastructure.in.rest.request;

public class NewRequestFileRequestDto {
    private String path;
    private Long supplierId;

    public NewRequestFileRequestDto(String path, Long supplierId) {
        this.path = path;
        this.supplierId = supplierId;
    }

    public NewRequestFileRequestDto() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}
