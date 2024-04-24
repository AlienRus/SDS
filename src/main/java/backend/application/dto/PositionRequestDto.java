package backend.application.dto;

import backend.infrastructure.out.repository.db.positionRequest.PositionRequest;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link PositionRequest}
 */
public class PositionRequestDto implements Serializable {
    private final Long id;
    private final PositionDto position;
    private final RequestDto request;

    public PositionRequestDto(Long id, PositionDto position, RequestDto request) {
        this.id = id;
        this.position = position;
        this.request = request;
    }

    public Long getId() {
        return id;
    }

    public PositionDto getPosition() {
        return position;
    }

    public RequestDto getRequest() {
        return request;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PositionRequestDto entity = (PositionRequestDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.position, entity.position) &&
                Objects.equals(this.request, entity.request);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, position, request);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "position = " + position + ", " +
                "request = " + request + ")";
    }
}