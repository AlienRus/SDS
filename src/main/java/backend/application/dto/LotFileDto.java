package backend.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class LotFileDto implements Serializable {
    private Long id;
    private LotDto lot;
    private String path;

    public LotFileDto() {

    }

    public LotFileDto(Long id, LotDto lot, String path) {
        this.id = id;
        this.lot = lot;
        this.path = path;
    }

    public Long getId() {
        return id;
    }

    public LotDto getLot() {
        return lot;
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
        LotFileDto entity = (LotFileDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.lot, entity.lot) &&
                Objects.equals(this.path, entity.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lot, path);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "lot = " + lot + ", " +
                "path = " + path + ")";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLot(LotDto lot) {
        this.lot = lot;
    }

    public void setPath(String path) {
        this.path = path;
    }
}