package backend.infrastructure.out.repository.db.positionRequest;

import backend.infrastructure.out.repository.db.request.Request;
import backend.infrastructure.out.repository.db.position.Position;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Position_Requests", indexes = {
        @Index(name = "position_id", columnList = "position_id"),
        @Index(name = "request_id", columnList = "request_id")
})
public class PositionRequest {
    @Id
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false , cascade = CascadeType.ALL)
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

}