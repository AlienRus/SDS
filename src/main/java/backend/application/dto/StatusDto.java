package backend.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class StatusDto implements Serializable {
    private Long id;
    private String statusName;

    public StatusDto() {

    }

    public StatusDto(Long id, String statusName) {
        this.id = id;
        this.statusName = statusName;
    }

    public Long getId() {
        return id;
    }

    public String getStatusName() {
        return statusName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        StatusDto entity = (StatusDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.statusName, entity.statusName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, statusName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "statusName = " + statusName + ")";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}