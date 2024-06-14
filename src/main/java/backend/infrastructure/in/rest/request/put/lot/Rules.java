package backend.infrastructure.in.rest.request.put.lot;

public class Rules {
    private Long shippingMethodId;
    private Long paymentMethodId;
    private String comment;

    public Rules() {
    }

    public Rules(Long shippingMethodId, Long paymentMethodId, String comment) {
        this.shippingMethodId = shippingMethodId;
        this.paymentMethodId = paymentMethodId;
        this.comment = comment;
    }

    public Long getShippingMethodId() {
        return shippingMethodId;
    }

    public void setShippingMethodId(Long shippingMethodId) {
        this.shippingMethodId = shippingMethodId;
    }

    public Long getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}