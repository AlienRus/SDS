package backend.application.dto;

import backend.infrastructure.out.repository.db.requestRulesPayment.RequestRulesPayment;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link RequestRulesPayment}
 */
public class RequestRulesPaymentDto implements Serializable {
    private final Long id;
    private final RequestRuleDto requestRules;
    private final PaymentMethodDto paymentMethod;
    private final Integer paymentValue;

    public RequestRulesPaymentDto(Long id, RequestRuleDto requestRules, PaymentMethodDto paymentMethod,
            Integer paymentValue) {
        this.id = id;
        this.requestRules = requestRules;
        this.paymentMethod = paymentMethod;
        this.paymentValue = paymentValue;
    }

    public Long getId() {
        return id;
    }

    public RequestRuleDto getRequestRules() {
        return requestRules;
    }

    public PaymentMethodDto getPaymentMethod() {
        return paymentMethod;
    }

    public Integer getPaymentValue() {
        return paymentValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        RequestRulesPaymentDto entity = (RequestRulesPaymentDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.requestRules, entity.requestRules) &&
                Objects.equals(this.paymentMethod, entity.paymentMethod) &&
                Objects.equals(this.paymentValue, entity.paymentValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, requestRules, paymentMethod, paymentValue);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "requestRules = " + requestRules + ", " +
                "paymentMethod = " + paymentMethod + ", " +
                "paymentValue = " + paymentValue + ")";
    }
}