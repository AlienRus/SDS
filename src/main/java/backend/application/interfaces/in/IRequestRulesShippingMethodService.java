package backend.application.interfaces.in;

import backend.application.dto.RequestRuleDto;
import backend.application.dto.RequestRulesShippingMethodDto;
import backend.application.interfaces.out.repository.IRequestRulesShippingMethodRepository;

import java.util.List;

public interface IRequestRulesShippingMethodService {
    public void InjectRequestRulesShippingMethodRepository(
            IRequestRulesShippingMethodRepository requestRulesShippingMethodRepository);

    void createRequestRulesShippingMethod(RequestRulesShippingMethodDto requestRulesShippingMethodDto);

    RequestRulesShippingMethodDto getRequestRulesShippingMethodById(Long id);

    List<RequestRulesShippingMethodDto> getRequestRulesShippingMethodsByRequestRule(RequestRuleDto requestRuleDto);

    List<RequestRulesShippingMethodDto> getAllRequestRulesShippingMethods();

    void updateRequestRulesShippingMethod(RequestRulesShippingMethodDto requestRulesShippingMethodDto);

    void deleteRequestRulesShippingMethod(RequestRulesShippingMethodDto requestRulesShippingMethodDto);
}
