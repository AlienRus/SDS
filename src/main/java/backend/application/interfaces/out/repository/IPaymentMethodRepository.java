package backend.application.interfaces.out.repository;

import backend.application.dto.PaymentMethodDto;

import java.util.List;

public interface IPaymentMethodRepository {
    void createPaymentMethod(PaymentMethodDto paymentMethodDto);

    PaymentMethodDto getPaymentMethodById(Long id);

    List<PaymentMethodDto> getAllPaymentMethods();

    void updatePaymentMethod(PaymentMethodDto paymentMethodDto);

    void deletePaymentMethod(PaymentMethodDto paymentMethodDto);
}
