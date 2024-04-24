package backend.application.dto;

import backend.infrastructure.out.repository.db.supplySpecialistGroup.SupplySpecialistGroup;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link SupplySpecialistGroup}
 */
public class SupplySpecialistGroupDto implements Serializable {
    private final Long id;
    private final SupplySpecialistDto supplySpecialist;
    private final GroupEtDto group;

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
}