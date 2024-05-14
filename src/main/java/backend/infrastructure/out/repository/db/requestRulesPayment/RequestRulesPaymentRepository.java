package backend.infrastructure.out.repository.db.requestRulesPayment;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.RequestRuleDto;
import backend.application.dto.RequestRulesPaymentDto;
import backend.application.interfaces.out.repository.IRequestRulesPaymentRepository;

@Stateless
public class RequestRulesPaymentRepository implements IRequestRulesPaymentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createRequestRulesPayment(RequestRulesPaymentDto requestRulesPaymentDto) {
        RequestRulesPayment requestRulesPayment = RequestRulesPaymentMapper.toEntity(requestRulesPaymentDto);
        entityManager.persist(requestRulesPayment);
    }

    public RequestRulesPaymentDto getRequestRulesPaymentById(Long id) {
        RequestRulesPayment requestRulesPayment = entityManager.find(RequestRulesPayment.class, id);
        return RequestRulesPaymentMapper.toDto(requestRulesPayment);
    }

    public List<RequestRulesPaymentDto> getRequestRulesPaymentsByRequestRule(RequestRuleDto requestRuleDTO) {
        List<RequestRulesPayment> requestRulesPayments = entityManager
                .createQuery(
                        "SELECT requestRulesPayment FROM RequestRulesPayment requestRulesPayment WHERE requestRulesPayment.requestRules.id=:id",
                        RequestRulesPayment.class)
                .setParameter("id", requestRuleDTO.getId())
                .getResultList();
        return requestRulesPayments.stream()
                .map(RequestRulesPaymentMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<RequestRulesPaymentDto> getAllRequestRulesPayments() {
        List<RequestRulesPayment> requestRulesPayments = entityManager
                .createQuery("SELECT requestRulesPayment FROM RequestRulesPayment requestRulesPayment",
                        RequestRulesPayment.class)
                .getResultList();
        return requestRulesPayments.stream()
                .map(RequestRulesPaymentMapper::toDto)
                .collect(Collectors.toList());
    }

    public void updateRequestRulesPayment(RequestRulesPaymentDto requestRulesPaymentDto) {
        RequestRulesPayment requestRulesPayment = RequestRulesPaymentMapper.toEntity(requestRulesPaymentDto);
        entityManager.merge(requestRulesPayment);
    }

    public void deleteRequestRulesPayment(RequestRulesPaymentDto requestRulesPaymentDto) {
        RequestRulesPayment requestRulesPayment = RequestRulesPaymentMapper.toEntity(requestRulesPaymentDto);
        entityManager.remove(entityManager.contains(requestRulesPayment) ? requestRulesPayment
                : entityManager.merge(requestRulesPayment));
    }
}
