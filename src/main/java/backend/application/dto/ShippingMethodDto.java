package backend.application.dto;

import backend.infrastructure.out.repository.db.shippingMethod.ShippingMethod;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link ShippingMethod}
 */
public class ShippingMethodDto implements Serializable {
    private final Long id;
    private final String name;

    public ShippingMethodDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ShippingMethodDto entity = (ShippingMethodDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ")";
    }
}