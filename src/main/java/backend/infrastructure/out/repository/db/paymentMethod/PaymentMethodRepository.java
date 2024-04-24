package backend.infrastructure.out.repository.db.paymentMethod;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.PaymentMethodDto;

@Stateless
public class PaymentMethodRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createPaymentMethod(PaymentMethodDto paymentMethodDto) {
        PaymentMethod paymentMethod = PaymentMethodMapper.toEntity(paymentMethodDto);
        entityManager.persist(paymentMethod);
    }

    public PaymentMethodDto getPaymentMethodById(Long id) {
        PaymentMethod paymentMethod = entityManager.find(PaymentMethod.class, id);
        return PaymentMethodMapper.toDto(paymentMethod);
    }

    public List<PaymentMethodDto> getAllPaymentMethods() {
        List<PaymentMethod> paymentMethods = entityManager
                .createQuery("SELECT paymentMethod FROM PaymentMethod paymentMethod", PaymentMethod.class)
                .getResultList();
        return paymentMethods.stream()
                .map(PaymentMethodMapper::toDto)
                .collect(Collectors.toList());
    }

    public void updatePaymentMethod(PaymentMethodDto paymentMethodDto) {
        PaymentMethod paymentMethod = PaymentMethodMapper.toEntity(paymentMethodDto);
        entityManager.merge(paymentMethod);
    }

    public void deletePaymentMethod(PaymentMethodDto paymentMethodDto) {
        PaymentMethod paymentMethod = PaymentMethodMapper.toEntity(paymentMethodDto);
        entityManager
                .remove(entityManager.contains(paymentMethod) ? paymentMethod : entityManager.merge(paymentMethod));
    }
}
