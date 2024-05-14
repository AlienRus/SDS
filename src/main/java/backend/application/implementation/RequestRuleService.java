package backend.application.implementation;

import backend.application.dto.RequestRuleDto;
import backend.application.interfaces.in.IRequestRuleService;
import backend.application.interfaces.out.repository.IRequestRuleRepository;

import java.util.List;

public class RequestRuleService implements IRequestRuleService {

    private IRequestRuleRepository requestRuleRepository;

    @Override
    public void InjectRequestRuleRepository(IRequestRuleRepository requestRuleRepository) {
        this.requestRuleRepository = requestRuleRepository;
    }

    @Override
    public void createRequestRule(RequestRuleDto requestRuleDto) {
        requestRuleRepository.createRequestRule(requestRuleDto);
    }

    @Override
    public RequestRuleDto getRequestRuleById(Long id) {
        return requestRuleRepository.getRequestRuleById(id);
    }

    @Override
    public List<RequestRuleDto> getRequestRulesByLotId(Long lotId) {
        return requestRuleRepository.getRequestRulesByLotId(lotId);
    }

    @Override
    public List<RequestRuleDto> getRequestRulesBySupplierId(Long supplierId) {
        return requestRuleRepository.getRequestRulesBySupplierId(supplierId);
    }

    @Override
    public List<RequestRuleDto> getAllRequestRules() {
        return requestRuleRepository.getAllRequestRules();
    }

    @Override
    public void updateRequestRule(RequestRuleDto requestRuleDto) {
        requestRuleRepository.updateRequestRule(requestRuleDto);
    }

    @Override
    public void deleteRequestRule(RequestRuleDto requestRuleDto) {
        requestRuleRepository.deleteRequestRule(requestRuleDto);
    }
}
