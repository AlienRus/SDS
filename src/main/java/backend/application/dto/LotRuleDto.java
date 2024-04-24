package backend.application.dto;

import backend.infrastructure.out.repository.db.lotRule.LotRule;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link LotRule}
 */
public class LotRuleDto implements Serializable {
    private final Long id;
    private final ShippingMethodDto shippingMethod;
    private final PaymentMethodDto paymentMethod;
    private final String comment;

    public LotRuleDto(Long id, ShippingMethodDto shippingMethod, PaymentMethodDto paymentMethod, String comment) {
        this.id = id;
        this.shippingMethod = shippingMethod;
        this.paymentMethod = paymentMethod;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public ShippingMethodDto getShippingMethod() {
        return shippingMethod;
    }

    public PaymentMethodDto getPaymentMethod() {
        return paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LotRuleDto entity = (LotRuleDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.shippingMethod, entity.shippingMethod) &&
                Objects.equals(this.paymentMethod, entity.paymentMethod) &&
                Objects.equals(this.comment, entity.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shippingMethod, paymentMethod, comment);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "shippingMethod = " + shippingMethod + ", " +
                "paymentMethod = " + paymentMethod + ", " +
                "comment = " + comment + ")";
    }
}