package backend.infrastructure.out.repository.db.requestRulesPayment;

import backend.application.dto.RequestRulesPaymentDto;
import backend.infrastructure.out.repository.db.paymentMethod.PaymentMethodMapper;
import backend.infrastructure.out.repository.db.requestRule.RequestRuleMapper;

public class RequestRulesPaymentMapper {

    public static RequestRulesPaymentDto toDto(RequestRulesPayment requestRulesPayment) {
        return new RequestRulesPaymentDto(
                requestRulesPayment.getId(),
                RequestRuleMapper.toDto(requestRulesPayment.getRequestRules()),
                PaymentMethodMapper.toDto(requestRulesPayment.getPaymentMethod()),
                requestRulesPayment.getPaymentValue());
    }

    public static RequestRulesPayment toEntity(RequestRulesPaymentDto requestRulesPaymentDto) {
        RequestRulesPayment requestRulesPayment = new RequestRulesPayment();
        requestRulesPayment.setId(requestRulesPaymentDto.getId());
        requestRulesPayment.setRequestRules(RequestRuleMapper.toEntity(requestRulesPaymentDto.getRequestRules()));
        requestRulesPayment.setPaymentMethod(PaymentMethodMapper.toEntity(requestRulesPaymentDto.getPaymentMethod()));
        requestRulesPayment.setPaymentValue(requestRulesPaymentDto.getPaymentValue());
        return requestRulesPayment;
    }
}
