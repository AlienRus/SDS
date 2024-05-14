package backend.application.interfaces.out.repository;

import backend.application.dto.LotRuleDto;

import java.util.List;

public interface ILotRuleRepository {
    void createLotRule(LotRuleDto lotRuleDto);

    LotRuleDto getLotRuleById(Long id);

    List<LotRuleDto> getAllLotRules();

    void updateLotRule(LotRuleDto lotRuleDto);

    void deleteLotRule(LotRuleDto lotRuleDto);
}
