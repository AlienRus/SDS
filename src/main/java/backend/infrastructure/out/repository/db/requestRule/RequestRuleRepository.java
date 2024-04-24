package backend.infrastructure.out.repository.db.requestRule;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.RequestRuleDto;

@Stateless
public class RequestRuleRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createRequestRule(RequestRuleDto requestRuleDto) {
        RequestRule requestRule = RequestRuleMapper.toEntity(requestRuleDto);
        entityManager.persist(requestRule);
    }

    public RequestRuleDto getRequestRuleById(Long id) {
        RequestRule requestRule = entityManager.find(RequestRule.class, id);
        return RequestRuleMapper.toDto(requestRule);
    }

    public List<RequestRuleDto> getRequestRulesByLotId(Long lotId) {
        List<RequestRule> requestRules = entityManager
                .createQuery("SELECT requestRule FROM RequestRule requestRule WHERE requestRule.lot.id = :lotId",
                        RequestRule.class)
                .setParameter("lotId", lotId)
                .getResultList();
        return requestRules.stream()
                .map(RequestRuleMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<RequestRuleDto> getRequestRulesBySupplierId(Long supplierId) {
        List<RequestRule> requestRules = entityManager
                .createQuery(
                        "SELECT requestRule FROM RequestRule requestRule WHERE requestRule.supplier.id = :supplierId",
                        RequestRule.class)
                .setParameter("supplierId", supplierId)
                .getResultList();
        return requestRules.stream()
                .map(RequestRuleMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<RequestRuleDto> getAllRequestRules() {
        List<RequestRule> requestRules = entityManager
                .createQuery("SELECT requestRule FROM RequestRule requestRule", RequestRule.class)
                .getResultList();
        return requestRules.stream()
                .map(RequestRuleMapper::toDto)
                .collect(Collectors.toList());
    }

    public void updateRequestRule(RequestRuleDto requestRuleDto) {
        RequestRule requestRule = RequestRuleMapper.toEntity(requestRuleDto);
        entityManager.merge(requestRule);
    }

    public void deleteRequestRule(RequestRuleDto requestRuleDto) {
        RequestRule requestRule = RequestRuleMapper.toEntity(requestRuleDto);
        entityManager.remove(entityManager.contains(requestRule) ? requestRule : entityManager.merge(requestRule));
    }
}
