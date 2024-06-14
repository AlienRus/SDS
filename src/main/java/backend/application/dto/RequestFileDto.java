package backend.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class RequestFileDto implements Serializable {
    private Long id;
    private LotDto lot;
    private SupplierDto supplier;
    private String path;

    public RequestFileDto() {

    }

    public RequestFileDto(LotDto lot, SupplierDto supplier, String path) {
        this.lot = lot;
        this.supplier = supplier;
        this.path = path;
    }

    public RequestFileDto(Long id, LotDto lot, SupplierDto supplier, String path) {
        this.id = id;
        this.lot = lot;
        this.supplier = supplier;
        this.path = path;
    }

    public Long getId() {
        return id;
    }

    public LotDto getLot() {
        return lot;
    }

    public SupplierDto getSupplier() {
        return supplier;
    }

    public String getPath() {
        return path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        RequestFileDto entity = (RequestFileDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.lot, entity.lot) &&
                Objects.equals(this.supplier, entity.supplier) &&
                Objects.equals(this.path, entity.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lot, supplier, path);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "lot = " + lot + ", " +
                "supplier = " + supplier + ", " +
                "path = " + path + ")";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLot(LotDto lot) {
        this.lot = lot;
    }

    public void setSupplier(SupplierDto supplier) {
        this.supplier = supplier;
    }

    public void setPath(String path) {
        this.path = path;
    }
}