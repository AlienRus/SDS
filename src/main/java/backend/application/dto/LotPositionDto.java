package backend.application.dto;

import backend.infrastructure.out.repository.db.lotPosition.LotPosition;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link LotPosition}
 */
public class LotPositionDto implements Serializable {
    private final Long id;
    private final LotDto lot;
    private final PositionDto position;

    public LotPositionDto(Long id, LotDto lot, PositionDto position) {
        this.id = id;
        this.lot = lot;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public LotDto getLot() {
        return lot;
    }

    public PositionDto getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LotPositionDto entity = (LotPositionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.lot, entity.lot) &&
                Objects.equals(this.position, entity.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lot, position);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "lot = " + lot + ", " +
                "position = " + position + ")";
    }
}