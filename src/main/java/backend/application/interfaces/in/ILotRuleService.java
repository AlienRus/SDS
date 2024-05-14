package backend.application.interfaces.in;

import backend.application.dto.LotRuleDto;
import backend.application.interfaces.out.repository.ILotRuleRepository;

import java.util.List;

public interface ILotRuleService {
    public void InjectLotRuleRepository(ILotRuleRepository lotRuleRepository);
    
    void createLotRule(LotRuleDto lotRuleDto);

    LotRuleDto getLotRuleById(Long id);

    List<LotRuleDto> getAllLotRules();

    void updateLotRule(LotRuleDto lotRuleDto);

    void deleteLotRule(LotRuleDto lotRuleDto);
}
