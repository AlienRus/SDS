package backend.infrastructure.out.response;

public class ListRulesResponse {
    private String comment;
    private ListRulesPaymentResponse payment;
    private String shippingMethod;

    public ListRulesResponse(String comment, ListRulesPaymentResponse payment, String shippingMethod) {
        this.comment = comment;
        this.payment = payment;
        this.shippingMethod = shippingMethod;
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
        return "ListRulesResponse [comment=" + comment + ", payment=" + payment + ", shippingMethod=" + shippingMethod
                + "]";
    }
}
