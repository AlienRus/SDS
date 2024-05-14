package backend.application.interfaces.in;

import backend.application.dto.RequestRuleDto;
import backend.application.interfaces.out.repository.IRequestRuleRepository;

import java.util.List;

public interface IRequestRuleService {
    public void InjectRequestRuleRepository(IRequestRuleRepository requestRuleRepository);

    void createRequestRule(RequestRuleDto requestRuleDto);

    RequestRuleDto getRequestRuleById(Long id);

    List<RequestRuleDto> getRequestRulesByLotId(Long lotId);

    List<RequestRuleDto> getRequestRulesBySupplierId(Long supplierId);

    List<RequestRuleDto> getAllRequestRules();

    void updateRequestRule(RequestRuleDto requestRuleDto);

    void deleteRequestRule(RequestRuleDto requestRuleDto);
}
