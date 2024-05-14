package backend.infrastructure.out.repository.db.lot;

import backend.infrastructure.out.repository.db.lotRule.LotRule;
import backend.infrastructure.out.repository.db.status.Status;
import backend.infrastructure.out.repository.db.supplySpecialist.SupplySpecialist;
import backend.infrastructure.out.repository.db.groupET.GroupEt;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "Lot", indexes = {
        @Index(name = "lots_ibfk_2", columnList = "status"),
        @Index(name = "lot_creator", columnList = "lot_creator"),
        @Index(name = "rules", columnList = "rules"),
        @Index(name = "group_ETS", columnList = "group_ETS")
})
public class Lot {
    @Id
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Size(max = 256)
    @NotNull
    @Column(name = "name", nullable = false, length = 256)
    private String name;

    @NotNull
    @Column(name = "open_date", nullable = false)
    private LocalDate openDate;

    @NotNull
    @Column(name = "close_date", nullable = false)
    private LocalDate closeDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status", nullable = false)
    private Status status;

    @NotNull
    @Column(name = "can_own_way", nullable = false)
    private Boolean canOwnWay = false;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lot_creator", nullable = false)
    private SupplySpecialist lotCreator;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "rules", nullable = false)
    private LotRule rules;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "group_ETS", nullable = false)
    private GroupEt groupEts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDate openDate) {
        this.openDate = openDate;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Boolean getCanOwnWay() {
        return canOwnWay;
    }

    public void setCanOwnWay(Boolean canOwnWay) {
        this.canOwnWay = canOwnWay;
    }

    public SupplySpecialist getLotCreator() {
        return lotCreator;
    }

    public void setLotCreator(SupplySpecialist lotCreator) {
        this.lotCreator = lotCreator;
    }

    public LotRule getRules() {
        return rules;
    }

    public void setRules(LotRule rules) {
        this.rules = rules;
    }

    public GroupEt getGroupEts() {
        return groupEts;
    }

    public void setGroupEts(GroupEt groupEts) {
        this.groupEts = groupEts;
    }

}