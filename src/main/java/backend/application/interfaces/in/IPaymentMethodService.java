package backend.application.interfaces.in;

import backend.application.dto.PaymentMethodDto;
import backend.application.interfaces.out.repository.IPaymentMethodRepository;

import java.util.List;

public interface IPaymentMethodService {
    public void InjectPaymentMethodRepository(IPaymentMethodRepository paymentMethodRepository);
    
    void createPaymentMethod(PaymentMethodDto paymentMethodDto);

    PaymentMethodDto getPaymentMethodById(Long id);

    List<PaymentMethodDto> getAllPaymentMethods();

    void updatePaymentMethod(PaymentMethodDto paymentMethodDto);

    void deletePaymentMethod(PaymentMethodDto paymentMethodDto);
}
