package backend.application.dto;

import backend.infrastructure.out.repository.db.status.Status;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link Status}
 */
public class StatusDto implements Serializable {
    private final Long id;
    private final String statusName;

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
}