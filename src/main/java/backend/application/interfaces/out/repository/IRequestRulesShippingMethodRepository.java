package backend.application.interfaces.out.repository;

import backend.application.dto.RequestRuleDto;
import backend.application.dto.RequestRulesShippingMethodDto;

import java.util.List;

public interface IRequestRulesShippingMethodRepository {
        void createRequestRulesShippingMethod(RequestRulesShippingMethodDto requestRulesShippingMethodDto);

        RequestRulesShippingMethodDto getRequestRulesShippingMethodById(Long id);

        List<RequestRulesShippingMethodDto> getRequestRulesShippingMethodsByRequestRule(RequestRuleDto requestRuleDto);

        List<RequestRulesShippingMethodDto> getAllRequestRulesShippingMethods();

        void updateRequestRulesShippingMethod(RequestRulesShippingMethodDto requestRulesShippingMethodDto);

        void deleteRequestRulesShippingMethod(RequestRulesShippingMethodDto requestRulesShippingMethodDto);
}
