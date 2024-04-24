package backend.infrastructure.out.repository.db.requestRulesShippingMethod;

import backend.infrastructure.out.repository.db.shippingMethod.ShippingMethodMapper;
import backend.application.dto.RequestRulesShippingMethodDto;
import backend.infrastructure.out.repository.db.requestRule.RequestRuleMapper;

public class RequestRulesShippingMethodMapper {

    public static RequestRulesShippingMethodDto toDto(RequestRulesShippingMethod requestRulesShippingMethod) {
        return new RequestRulesShippingMethodDto(
                requestRulesShippingMethod.getId(),
                RequestRuleMapper.toDto(requestRulesShippingMethod.getRequestRules()),
                ShippingMethodMapper.toDto(requestRulesShippingMethod.getShippingMethod()));
    }

    public static RequestRulesShippingMethod toEntity(RequestRulesShippingMethodDto requestRulesShippingMethodDto) {
        RequestRulesShippingMethod requestRulesShippingMethod = new RequestRulesShippingMethod();
        requestRulesShippingMethod.setId(requestRulesShippingMethodDto.getId());
        requestRulesShippingMethod
                .setRequestRules(RequestRuleMapper.toEntity(requestRulesShippingMethodDto.getRequestRules()));
        requestRulesShippingMethod
                .setShippingMethod(ShippingMethodMapper.toEntity(requestRulesShippingMethodDto.getShippingMethod()));
        return requestRulesShippingMethod;
    }
}
