package backend.infrastructure.out.repository.db.supplySpecialistGroup;

import backend.infrastructure.out.repository.db.groupET.GroupEt;
import backend.infrastructure.out.repository.db.supplySpecialist.SupplySpecialist;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Supply_specialist_group", indexes = {
        @Index(name = "supply_specialist_id", columnList = "supply_specialist_id"),
        @Index(name = "group_id", columnList = "group_id")
})
public class SupplySpecialistGroup {
    @Id
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supply_specialist_id", nullable = false)
    private SupplySpecialist supplySpecialist;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "group_id", nullable = false)
    private GroupEt group;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SupplySpecialist getSupplySpecialist() {
        return supplySpecialist;
    }

    public void setSupplySpecialist(SupplySpecialist supplySpecialist) {
        this.supplySpecialist = supplySpecialist;
    }

    public GroupEt getGroup() {
        return group;
    }

    public void setGroup(GroupEt group) {
        this.group = group;
    }

}