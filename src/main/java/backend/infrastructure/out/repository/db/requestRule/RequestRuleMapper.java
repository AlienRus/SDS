package backend.infrastructure.out.repository.db.requestRule;

import backend.infrastructure.out.repository.db.supplier.SupplierMapper;
import backend.application.dto.RequestRuleDto;
import backend.infrastructure.out.repository.db.lot.LotMapper;
import backend.infrastructure.out.repository.db.paymentMethod.PaymentMethodMapper;
import backend.infrastructure.out.repository.db.shippingMethod.ShippingMethodMapper;

public class RequestRuleMapper {

    public static RequestRuleDto toDto(RequestRule requestRule) {
        return new RequestRuleDto(
                requestRule.getId(),
                LotMapper.toDto(requestRule.getLot()),
                SupplierMapper.toDto(requestRule.getSupplier()),
                requestRule.getComment(),
                ShippingMethodMapper.toDto(requestRule.getShippingMethod()),
                PaymentMethodMapper.toDto(requestRule.getPaymentMethod()),
                requestRule.getPaymentValue());
    }

    public static RequestRule toEntity(RequestRuleDto requestRuleDto) {
        RequestRule requestRule = new RequestRule();
        requestRule.setId(requestRuleDto.getId());
        requestRule.setLot(LotMapper.toEntity(requestRuleDto.getLot()));
        requestRule.setSupplier(SupplierMapper.toEntity(requestRuleDto.getSupplier()));
        requestRule.setComment(requestRuleDto.getComment());
        requestRule.setShippingMethod(ShippingMethodMapper.toEntity(requestRuleDto.getShippingMethod()));
        requestRule.setPaymentMethod(PaymentMethodMapper.toEntity(requestRuleDto.getPaymentMethod()));
        requestRule.setPaymentValue(requestRuleDto.getPaymentValue());
        return requestRule;
    }
}
