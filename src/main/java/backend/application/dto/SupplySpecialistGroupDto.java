package backend.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class SupplySpecialistGroupDto implements Serializable {
    private Long id;
    private SupplySpecialistDto supplySpecialist;
    private GroupEtDto group;

    public SupplySpecialistGroupDto() {

    }

    public SupplySpecialistGroupDto(SupplySpecialistDto supplySpecialist, GroupEtDto group) {
        this.supplySpecialist = supplySpecialist;
        this.group = group;
    }

    public SupplySpecialistGroupDto(Long id, SupplySpecialistDto supplySpecialist, GroupEtDto group) {
        this.id = id;
        this.supplySpecialist = supplySpecialist;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public SupplySpecialistDto getSupplySpecialist() {
        return supplySpecialist;
    }

    public GroupEtDto getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SupplySpecialistGroupDto entity = (SupplySpecialistGroupDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.supplySpecialist, entity.supplySpecialist) &&
                Objects.equals(this.group, entity.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, supplySpecialist, group);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "supplySpecialist = " + supplySpecialist + ", " +
                "group = " + group + ")";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSupplySpecialist(SupplySpecialistDto supplySpecialist) {
        this.supplySpecialist = supplySpecialist;
    }

    public void setGroup(GroupEtDto group) {
        this.group = group;
    }
}