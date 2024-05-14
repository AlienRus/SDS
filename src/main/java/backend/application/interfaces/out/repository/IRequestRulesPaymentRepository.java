package backend.application.interfaces.out.repository;

import backend.application.dto.RequestRuleDto;
import backend.application.dto.RequestRulesPaymentDto;

import java.util.List;

public interface IRequestRulesPaymentRepository {
    void createRequestRulesPayment(RequestRulesPaymentDto requestRulesPaymentDto);

    RequestRulesPaymentDto getRequestRulesPaymentById(Long id);

    List<RequestRulesPaymentDto> getRequestRulesPaymentsByRequestRule(RequestRuleDto requestRule);

    List<RequestRulesPaymentDto> getAllRequestRulesPayments();

    void updateRequestRulesPayment(RequestRulesPaymentDto requestRulesPaymentDto);

    void deleteRequestRulesPayment(RequestRulesPaymentDto requestRulesPaymentDto);
}
