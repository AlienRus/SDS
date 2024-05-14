package backend.application.implementation;

import backend.application.dto.LotRuleDto;
import backend.application.interfaces.in.ILotRuleService;
import backend.application.interfaces.out.repository.ILotRuleRepository;

import java.util.List;

public class LotRuleService implements ILotRuleService {

    private ILotRuleRepository lotRuleRepository;

    public void InjectLotRuleRepository(ILotRuleRepository lotRuleRepository) {
        this.lotRuleRepository = lotRuleRepository;
    }

    @Override
    public void createLotRule(LotRuleDto lotRuleDto) {
        lotRuleRepository.createLotRule(lotRuleDto);
    }

    @Override
    public LotRuleDto getLotRuleById(Long id) {
        return lotRuleRepository.getLotRuleById(id);
    }

    @Override
    public List<LotRuleDto> getAllLotRules() {
        return lotRuleRepository.getAllLotRules();
    }

    @Override
    public void updateLotRule(LotRuleDto lotRuleDto) {
        lotRuleRepository.updateLotRule(lotRuleDto);
    }

    @Override
    public void deleteLotRule(LotRuleDto lotRuleDto) {
        lotRuleRepository.deleteLotRule(lotRuleDto);
    }
}
