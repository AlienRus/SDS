package backend.application.dto;

public class ListRuleDto {
    private String comment;
    private ListRulePaymentDto payment;
    private String shippingMethod;

    public ListRuleDto(String comment, ListRulePaymentDto payment, String shippingMethod) {
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

    public ListRulePaymentDto getPayment() {
        return payment;
    }

    public void setPayment(ListRulePaymentDto payment) {
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
        return "ListRuleDto [comment=" + comment + ", payment=" + payment + ", shippingMethod=" + shippingMethod + "]";
    }
}
