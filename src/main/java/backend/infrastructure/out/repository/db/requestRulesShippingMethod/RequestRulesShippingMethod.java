package backend.infrastructure.out.repository.db.requestRulesShippingMethod;

import backend.infrastructure.out.repository.db.shippingMethod.ShippingMethod;
import backend.infrastructure.out.repository.db.requestRule.RequestRule;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Request_rules_Shipping_method", indexes = {
        @Index(name = "request_rules_id", columnList = "request_rules_id"),
        @Index(name = "shipping_method_id", columnList = "shipping_method_id")
})
public class RequestRulesShippingMethod {
    @Id
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "request_rules_id", nullable = false)
    private RequestRule requestRules;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shipping_method_id", nullable = false)
    private ShippingMethod shippingMethod;

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

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

}