package backend.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class RequestRulesShippingMethodDto implements Serializable {
    private Long id;
    private RequestRuleDto requestRules;
    private ShippingMethodDto shippingMethod;

    public RequestRulesShippingMethodDto() {

    }

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setRequestRules(RequestRuleDto requestRules) {
        this.requestRules = requestRules;
    }

    public void setShippingMethod(ShippingMethodDto shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}