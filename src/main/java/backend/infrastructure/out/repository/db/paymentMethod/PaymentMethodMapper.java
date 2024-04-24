package backend.infrastructure.out.repository.db.paymentMethod;

import backend.application.dto.PaymentMethodDto;

public class PaymentMethodMapper {

    public static PaymentMethodDto toDto(PaymentMethod paymentMethod) {
        return new PaymentMethodDto(
                paymentMethod.getId(),
                paymentMethod.getName());
    }

    public static PaymentMethod toEntity(PaymentMethodDto paymentMethodDto) {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setId(paymentMethodDto.getId());
        paymentMethod.setName(paymentMethodDto.getName());
        return paymentMethod;
    }
}