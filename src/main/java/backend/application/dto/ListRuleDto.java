package backend.application.dto;

public class ListRuleDto {
    private Long supplierId;
    private String comment;
    private ListRulePaymentDto payment;
    private String shippingMethod;

    public ListRuleDto(Long supplierId, String comment, ListRulePaymentDto payment, String shippingMethod) {
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
        return "ListRuleDto [supplierId=" + supplierId + ", comment=" + comment + ", payment=" + payment
                + ", shippingMethod=" + shippingMethod + "]";
    }

}
