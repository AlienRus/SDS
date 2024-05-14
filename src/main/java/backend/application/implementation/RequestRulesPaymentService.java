package backend.application.implementation;

import backend.application.dto.RequestRuleDto;
import backend.application.dto.RequestRulesPaymentDto;
import backend.application.interfaces.in.IRequestRulesPaymentService;
import backend.application.interfaces.out.repository.IRequestRulesPaymentRepository;

import java.util.List;

public class RequestRulesPaymentService implements IRequestRulesPaymentService {

    private IRequestRulesPaymentRepository requestRulesPaymentRepository;

    @Override
    public void InjectRequestRulesPaymentRepository(IRequestRulesPaymentRepository requestRulesPaymentRepository) {
        this.requestRulesPaymentRepository = requestRulesPaymentRepository;
    }

    @Override
    public void createRequestRulesPayment(RequestRulesPaymentDto requestRulesPaymentDto) {
        requestRulesPaymentRepository.createRequestRulesPayment(requestRulesPaymentDto);
    }

    @Override
    public RequestRulesPaymentDto getRequestRulesPaymentById(Long id) {
        return requestRulesPaymentRepository.getRequestRulesPaymentById(id);
    }

    @Override
    public List<RequestRulesPaymentDto> getRequestRulesPaymentsByRequestRule(RequestRuleDto requestRuleDto) {
        return requestRulesPaymentRepository.getRequestRulesPaymentsByRequestRule(requestRuleDto);
    }

    @Override
    public List<RequestRulesPaymentDto> getAllRequestRulesPayments() {
        return requestRulesPaymentRepository.getAllRequestRulesPayments();
    }

    @Override
    public void updateRequestRulesPayment(RequestRulesPaymentDto requestRulesPaymentDto) {
        requestRulesPaymentRepository.updateRequestRulesPayment(requestRulesPaymentDto);
    }

    @Override
    public void deleteRequestRulesPayment(RequestRulesPaymentDto requestRulesPaymentDto) {
        requestRulesPaymentRepository.deleteRequestRulesPayment(requestRulesPaymentDto);
    }
}
