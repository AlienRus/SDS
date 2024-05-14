package backend.application.interfaces.in;

import backend.application.dto.RequestRuleDto;
import backend.application.dto.RequestRulesPaymentDto;
import backend.application.interfaces.out.repository.IRequestRulesPaymentRepository;

import java.util.List;

public interface IRequestRulesPaymentService {
    public void InjectRequestRulesPaymentRepository(IRequestRulesPaymentRepository requestRulesPaymentRepository);

    void createRequestRulesPayment(RequestRulesPaymentDto requestRulesPaymentDto);

    RequestRulesPaymentDto getRequestRulesPaymentById(Long id);

    List<RequestRulesPaymentDto> getRequestRulesPaymentsByRequestRule(RequestRuleDto requestRuleDTO);

    List<RequestRulesPaymentDto> getAllRequestRulesPayments();

    void updateRequestRulesPayment(RequestRulesPaymentDto requestRulesPaymentDto);

    void deleteRequestRulesPayment(RequestRulesPaymentDto requestRulesPaymentDto);
}
