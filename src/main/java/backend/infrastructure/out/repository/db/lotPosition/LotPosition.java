package backend.infrastructure.out.repository.db.lotPosition;

import backend.infrastructure.out.repository.db.position.Position;
import backend.infrastructure.out.repository.db.lot.Lot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Lot_Positions", indexes = {
        @Index(name = "lot_id", columnList = "lot_id"),
        @Index(name = "position_id", columnList = "position_id")
})
public class LotPosition {
    @Id
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lot_id", nullable = false)
    private Lot lot;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false,  cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}