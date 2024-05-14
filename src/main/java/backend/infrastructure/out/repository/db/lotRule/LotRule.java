package backend.infrastructure.out.repository.db.lotRule;

import backend.infrastructure.out.repository.db.paymentMethod.PaymentMethod;
import backend.infrastructure.out.repository.db.shippingMethod.ShippingMethod;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Lot_rules", indexes = {
        @Index(name = "shipping_method", columnList = "shipping_method"),
        @Index(name = "payment_method", columnList = "payment_method")
})
public class LotRule {
    @Id
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_method")
    private ShippingMethod shippingMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_method")
    private PaymentMethod paymentMethod;

    @Size(max = 256)
    @Column(name = "comment", length = 256)
    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}