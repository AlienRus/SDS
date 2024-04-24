package backend.infrastructure.out.repository.db.requestRule;

import backend.infrastructure.out.repository.db.supplier.SupplierMapper;
import backend.application.dto.RequestRuleDto;
import backend.infrastructure.out.repository.db.lot.LotMapper;

public class RequestRuleMapper {

    public static RequestRuleDto toDto(RequestRule requestRule) {
        return new RequestRuleDto(
                requestRule.getId(),
                LotMapper.toDto(requestRule.getLot()),
                SupplierMapper.toDto(requestRule.getSupplier()),
                requestRule.getComment());
    }

    public static RequestRule toEntity(RequestRuleDto requestRuleDto) {
        RequestRule requestRule = new RequestRule();
        requestRule.setId(requestRuleDto.getId());
        requestRule.setLot(LotMapper.toEntity(requestRuleDto.getLot()));
        requestRule.setSupplier(SupplierMapper.toEntity(requestRuleDto.getSupplier()));
        requestRule.setComment(requestRuleDto.getComment());
        return requestRule;
    }
}
