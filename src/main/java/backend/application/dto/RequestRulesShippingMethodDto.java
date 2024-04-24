package backend.application.dto;

import backend.infrastructure.out.repository.db.requestRulesShippingMethod.RequestRulesShippingMethod;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link RequestRulesShippingMethod}
 */
public class RequestRulesShippingMethodDto implements Serializable {
    private final Long id;
    private final RequestRuleDto requestRules;
    private final ShippingMethodDto shippingMethod;

    public RequestRulesShippingMethodDto(Long id, RequestRuleDto requestRules, ShippingMethodDto shippingMethod) {
        this.id = id;
        this.requestRules = requestRules;
        this.shippingMethod = shippingMethod;
    }

    public Long getId() {
        return id;
    }

    public RequestRuleDto getRequestRules() {
        return requestRules;
    }

    public ShippingMethodDto getShippingMethod() {
        return shippingMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        RequestRulesShippingMethodDto entity = (RequestRulesShippingMethodDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.requestRules, entity.requestRules) &&
                Objects.equals(this.shippingMethod, entity.shippingMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, requestRules, shippingMethod);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "requestRules = " + requestRules + ", " +
                "shippingMethod = " + shippingMethod + ")";
    }
}