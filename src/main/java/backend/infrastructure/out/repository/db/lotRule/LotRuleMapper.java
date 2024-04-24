package backend.infrastructure.out.repository.db.lotRule;

import backend.application.dto.LotRuleDto;
import backend.infrastructure.out.repository.db.paymentMethod.PaymentMethodMapper;
import backend.infrastructure.out.repository.db.shippingMethod.ShippingMethodMapper;

public class LotRuleMapper {

    public static LotRuleDto toDto(LotRule lotRule) {
        return new LotRuleDto(
                lotRule.getId(),
                ShippingMethodMapper.toDto(lotRule.getShippingMethod()),
                PaymentMethodMapper.toDto(lotRule.getPaymentMethod()),
                lotRule.getComment());
    }

    public static LotRule toEntity(LotRuleDto lotRuleDto) {
        LotRule lotRule = new LotRule();
        lotRule.setId(lotRuleDto.getId());
        lotRule.setShippingMethod(ShippingMethodMapper.toEntity(lotRuleDto.getShippingMethod()));
        lotRule.setPaymentMethod(PaymentMethodMapper.toEntity(lotRuleDto.getPaymentMethod()));
        lotRule.setComment(lotRuleDto.getComment());
        return lotRule;
    }
}
