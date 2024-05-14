package backend.application.implementation;

import backend.application.dto.RequestRuleDto;
import backend.application.dto.RequestRulesShippingMethodDto;
import backend.application.interfaces.in.IRequestRulesShippingMethodService;
import backend.application.interfaces.out.repository.IRequestRulesShippingMethodRepository;

import java.util.List;

public class RequestRulesShippingMethodService implements IRequestRulesShippingMethodService {

    private IRequestRulesShippingMethodRepository requestRulesShippingMethodRepository;

    @Override
    public void InjectRequestRulesShippingMethodRepository(
            IRequestRulesShippingMethodRepository requestRulesShippingMethodRepository) {
        this.requestRulesShippingMethodRepository = requestRulesShippingMethodRepository;
    }

    @Override
    public void createRequestRulesShippingMethod(RequestRulesShippingMethodDto requestRulesShippingMethodDto) {
        requestRulesShippingMethodRepository.createRequestRulesShippingMethod(requestRulesShippingMethodDto);
    }

    @Override
    public RequestRulesShippingMethodDto getRequestRulesShippingMethodById(Long id) {
        return requestRulesShippingMethodRepository.getRequestRulesShippingMethodById(id);
    }

    @Override
    public List<RequestRulesShippingMethodDto> getRequestRulesShippingMethodsByRequestRule(
            RequestRuleDto requestRuleDto) {
        return requestRulesShippingMethodRepository.getRequestRulesShippingMethodsByRequestRule(requestRuleDto);
    }

    @Override
    public List<RequestRulesShippingMethodDto> getAllRequestRulesShippingMethods() {
        return requestRulesShippingMethodRepository.getAllRequestRulesShippingMethods();
    }

    @Override
    public void updateRequestRulesShippingMethod(RequestRulesShippingMethodDto requestRulesShippingMethodDto) {
        requestRulesShippingMethodRepository.updateRequestRulesShippingMethod(requestRulesShippingMethodDto);
    }

    @Override
    public void deleteRequestRulesShippingMethod(RequestRulesShippingMethodDto requestRulesShippingMethodDto) {
        requestRulesShippingMethodRepository.deleteRequestRulesShippingMethod(requestRulesShippingMethodDto);
    }

}
