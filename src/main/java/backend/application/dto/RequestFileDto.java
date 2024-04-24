package backend.application.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for
 * {@link backend.infrastructure.out.repository.db.requestFile.RequestFile}
 */
public class RequestFileDto implements Serializable {
    private final Long id;
    private final LotDto lot;
    private final SupplierDto supplier;
    private final String path;

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
}