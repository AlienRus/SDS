package backend.infrastructure.out.repository.db.requestRulesShippingMethod;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.infrastructure.out.repository.db.requestRule.RequestRule;
import backend.application.dto.RequestRulesShippingMethodDto;

@Stateless
public class RequestRulesShippingMethodRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createRequestRulesShippingMethod(RequestRulesShippingMethodDto requestRulesShippingMethodDto) {
        RequestRulesShippingMethod requestRulesShippingMethod = RequestRulesShippingMethodMapper
                .toEntity(requestRulesShippingMethodDto);
        entityManager.persist(requestRulesShippingMethod);
    }

    public RequestRulesShippingMethodDto getRequestRulesShippingMethodById(Long id) {
        RequestRulesShippingMethod requestRulesShippingMethod = entityManager.find(RequestRulesShippingMethod.class,
                id);
        return RequestRulesShippingMethodMapper.toDto(requestRulesShippingMethod);
    }

    public List<RequestRulesShippingMethodDto> getRequestRulesShippingMethodsByRequestRule(RequestRule requestRule) {
        List<RequestRulesShippingMethod> requestRulesShippingMethods = entityManager.createQuery(
                "SELECT requestRulesShippingMethod FROM RequestRulesShippingMethod requestRulesShippingMethod WHERE requestRulesShippingMethod.requestRule = :requestRule",
                RequestRulesShippingMethod.class)
                .setParameter("requestRule", requestRule)
                .getResultList();
        return requestRulesShippingMethods.stream()
                .map(RequestRulesShippingMethodMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<RequestRulesShippingMethodDto> getAllRequestRulesShippingMethods() {
        List<RequestRulesShippingMethod> requestRulesShippingMethods = entityManager.createQuery(
                "SELECT requestRulesShippingMethod FROM RequestRulesShippingMethod requestRulesShippingMethod",
                RequestRulesShippingMethod.class).getResultList();
        return requestRulesShippingMethods.stream()
                .map(RequestRulesShippingMethodMapper::toDto)
                .collect(Collectors.toList());
    }

    public void updateRequestRulesShippingMethod(RequestRulesShippingMethodDto requestRulesShippingMethodDto) {
        RequestRulesShippingMethod requestRulesShippingMethod = RequestRulesShippingMethodMapper
                .toEntity(requestRulesShippingMethodDto);
        entityManager.merge(requestRulesShippingMethod);
    }

    public void deleteRequestRulesShippingMethod(RequestRulesShippingMethodDto requestRulesShippingMethodDto) {
        RequestRulesShippingMethod requestRulesShippingMethod = RequestRulesShippingMethodMapper
                .toEntity(requestRulesShippingMethodDto);
        entityManager.remove(entityManager.contains(requestRulesShippingMethod) ? requestRulesShippingMethod
                : entityManager.merge(requestRulesShippingMethod));
    }
}
