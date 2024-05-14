package backend.application.dto;

public class ListFileDto {
    private String path;
    private Long supplierId;

    public ListFileDto(String path, Long supplierId) {
        this.path = path;
        this.supplierId = supplierId;
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
