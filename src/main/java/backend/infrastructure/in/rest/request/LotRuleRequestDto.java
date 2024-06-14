package backend.infrastructure.in.rest.request;

public class LotRuleRequestDto {
    private Long shippingMethodId;
    private Long paymentMethodId;
    private String comment;
    private Integer paymentValue;

    public LotRuleRequestDto() {
    }

    public LotRuleRequestDto(Long shippingMethodId, Long paymentMethodId, String comment, Integer paymentValue) {
        this.shippingMethodId = shippingMethodId;
        this.paymentMethodId = paymentMethodId;
        this.comment = comment;
        this.paymentValue = paymentValue;
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

    public Integer getPaymentValue() {
        return paymentValue;
    }

    public void setPaymentValue(Integer paymentValue) {
        this.paymentValue = paymentValue;
    }

}
