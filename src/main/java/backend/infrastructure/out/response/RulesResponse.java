package backend.infrastructure.out.response;

import backend.application.dto.LotRuleDto;

public class RulesResponse {
    private String shippingMethod;
    private String paymentMethod;
    private String comment;

    public RulesResponse(LotRuleDto lotRuleDto) {
        this.shippingMethod = lotRuleDto.getShippingMethod().getName();
        this.paymentMethod = lotRuleDto.getPaymentMethod().getName();
        this.comment = lotRuleDto.getComment();
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
