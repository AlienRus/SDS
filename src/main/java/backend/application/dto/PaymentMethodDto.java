package backend.application.dto;

import backend.infrastructure.out.repository.db.paymentMethod.PaymentMethod;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link PaymentMethod}
 */
public class PaymentMethodDto implements Serializable {
    private final Long id;
    private final String name;

    public PaymentMethodDto(Long id, String name) {
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
        PaymentMethodDto entity = (PaymentMethodDto) o;
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