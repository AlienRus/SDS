package backend.infrastructure.out.repository.db.requestRulesPayment;

import backend.infrastructure.out.repository.db.paymentMethod.PaymentMethod;
import backend.infrastructure.out.repository.db.requestRule.RequestRule;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Request_rules_payment", indexes = {
        @Index(name = "request_rules_id", columnList = "request_rules_id"),
        @Index(name = "payment_method_id", columnList = "payment_method_id")
})
public class RequestRulesPayment {
    @Id
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "request_rules_id", nullable = false)
    private RequestRule requestRules;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_method_id", nullable = false)
    private PaymentMethod paymentMethod;

    @Column(name = "payment_value")
    private Integer paymentValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RequestRule getRequestRules() {
        return requestRules;
    }

    public void setRequestRules(RequestRule requestRules) {
        this.requestRules = requestRules;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getPaymentValue() {
        return paymentValue;
    }

    public void setPaymentValue(Integer paymentValue) {
        this.paymentValue = paymentValue;
    }

}