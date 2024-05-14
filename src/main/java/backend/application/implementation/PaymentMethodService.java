package backend.application.implementation;

import backend.application.dto.PaymentMethodDto;
import backend.application.interfaces.in.IPaymentMethodService;
import backend.application.interfaces.out.repository.IPaymentMethodRepository;

import java.util.List;

public class PaymentMethodService implements IPaymentMethodService {

    private IPaymentMethodRepository paymentMethodRepository;

    @Override
    public void InjectPaymentMethodRepository(IPaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public void createPaymentMethod(PaymentMethodDto paymentMethodDto) {
        paymentMethodRepository.createPaymentMethod(paymentMethodDto);
    }

    @Override
    public PaymentMethodDto getPaymentMethodById(Long id) {
        return paymentMethodRepository.getPaymentMethodById(id);
    }

    @Override
    public List<PaymentMethodDto> getAllPaymentMethods() {
        return paymentMethodRepository.getAllPaymentMethods();
    }

    @Override
    public void updatePaymentMethod(PaymentMethodDto paymentMethodDto) {
        paymentMethodRepository.updatePaymentMethod(paymentMethodDto);
    }

    @Override
    public void deletePaymentMethod(PaymentMethodDto paymentMethodDto) {
        paymentMethodRepository.deletePaymentMethod(paymentMethodDto);
    }
}
