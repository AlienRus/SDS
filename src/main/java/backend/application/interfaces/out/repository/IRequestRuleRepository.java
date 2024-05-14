package backend.application.interfaces.out.repository;

import backend.application.dto.RequestRuleDto;

import java.util.List;

public interface IRequestRuleRepository {
    void createRequestRule(RequestRuleDto requestRuleDto);

    RequestRuleDto getRequestRuleById(Long id);

    List<RequestRuleDto> getRequestRulesByLotId(Long lotId);

    List<RequestRuleDto> getRequestRulesBySupplierId(Long supplierId);

    List<RequestRuleDto> getAllRequestRules();

    void updateRequestRule(RequestRuleDto requestRuleDto);

    void deleteRequestRule(RequestRuleDto requestRuleDto);

    public List<RequestRuleDto> getRequestRulesByLotIdAndSupplierId(Long lotId, Long supplierId);
}
