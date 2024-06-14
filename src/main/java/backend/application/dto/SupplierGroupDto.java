package backend.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class SupplierGroupDto implements Serializable {
    private Long id;
    private SupplierDto supplier;
    private GroupEtDto group;

    public SupplierGroupDto() {

    }

    public SupplierGroupDto(SupplierDto supplier, GroupEtDto group) {
        this.supplier = supplier;
        this.group = group;
    }

    public SupplierGroupDto(Long id, SupplierDto supplier, GroupEtDto group) {
        this.id = id;
        this.supplier = supplier;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public SupplierDto getSupplier() {
        return supplier;
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
        SupplierGroupDto entity = (SupplierGroupDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.supplier, entity.supplier) &&
                Objects.equals(this.group, entity.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, supplier, group);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "supplier = " + supplier + ", " +
                "group = " + group + ")";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSupplier(SupplierDto supplier) {
        this.supplier = supplier;
    }

    public void setGroup(GroupEtDto group) {
        this.group = group;
    }
}