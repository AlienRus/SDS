package backend.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class RequestRulesPaymentDto implements Serializable {
    private Long id;
    private RequestRuleDto requestRules;
    private PaymentMethodDto paymentMethod;
    private Integer paymentValue;

    public RequestRulesPaymentDto() {

    }

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setRequestRules(RequestRuleDto requestRules) {
        this.requestRules = requestRules;
    }

    public void setPaymentMethod(PaymentMethodDto paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentValue(Integer paymentValue) {
        this.paymentValue = paymentValue;
    }
}