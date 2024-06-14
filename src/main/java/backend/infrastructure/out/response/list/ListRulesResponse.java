package backend.infrastructure.out.response.list;

public class ListRulesResponse {
    private Long supplierId;
    private String comment;
    private ListRulesPaymentResponse payment;
    private String shippingMethod;

    public ListRulesResponse(Long supplierId, String comment, ListRulesPaymentResponse payment, String shippingMethod) {
        this.supplierId = supplierId;
        this.comment = comment;
        this.payment = payment;
        this.shippingMethod = shippingMethod;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ListRulesPaymentResponse getPayment() {
        return payment;
    }

    public void setPayment(ListRulesPaymentResponse payment) {
        this.payment = payment;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    @Override
    public String toString() {
        return "ListRulesResponse [supplierId=" + supplierId + ", comment=" + comment + ", payment=" + payment
                + ", shippingMethod=" + shippingMethod + "]";
    }

}
