package backend.infrastructure.out.repository.db.lotRule;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.LotRuleDto;

@Stateless
public class LotRuleRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createLotRule(LotRuleDto lotRuleDto) {
        LotRule lotRule = LotRuleMapper.toEntity(lotRuleDto);
        entityManager.persist(lotRule);
    }

    public LotRuleDto getLotRuleById(Long id) {
        LotRule lotRule = entityManager.find(LotRule.class, id);
        return LotRuleMapper.toDto(lotRule);
    }

    public List<LotRuleDto> getAllLotRules() {
        List<LotRule> lotRules = entityManager.createQuery("SELECT lotRule FROM LotRule lotRule", LotRule.class)
                .getResultList();
        return lotRules.stream()
                .map(LotRuleMapper::toDto)
                .collect(Collectors.toList());
    }

    public void updateLotRule(LotRuleDto lotRuleDto) {
        LotRule lotRule = LotRuleMapper.toEntity(lotRuleDto);
        entityManager.merge(lotRule);
    }

    public void deleteLotRule(LotRuleDto lotRuleDto) {
        LotRule lotRule = LotRuleMapper.toEntity(lotRuleDto);
        entityManager.remove(entityManager.contains(lotRule) ? lotRule : entityManager.merge(lotRule));
    }
}
