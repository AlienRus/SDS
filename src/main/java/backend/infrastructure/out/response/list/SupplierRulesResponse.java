package backend.infrastructure.out.response.list;

import backend.application.dto.LotRuleDto;

public class SupplierRulesResponse {
    private Long supplierId;
    private String shippingMethod;
    private String paymentMethod;
    private String comment;

    public SupplierRulesResponse() {
    }

    public SupplierRulesResponse(LotRuleDto lotRuleDto, Long supplierId) {
        this.supplierId = supplierId;
        this.shippingMethod = lotRuleDto.getShippingMethod().getName();
        this.paymentMethod = lotRuleDto.getPaymentMethod().getName();
        this.comment = lotRuleDto.getComment();
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
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
