package backend.application.dto;

import java.io.Serializable;

public class RequestRuleDto implements Serializable {
    private Long id;
    private LotDto lot;
    private SupplierDto supplier;
    private String comment;
    private ShippingMethodDto shippingMethod;
    private PaymentMethodDto paymentMethod;
    private Integer paymentValue;

    public RequestRuleDto() {

    }

    public RequestRuleDto(LotDto lot, SupplierDto supplier, String comment, ShippingMethodDto shippingMethod,
            PaymentMethodDto paymentMethod, Integer paymentValue) {
        this.lot = lot;
        this.supplier = supplier;
        this.comment = comment;
        this.shippingMethod = shippingMethod;
        this.paymentMethod = paymentMethod;
        this.paymentValue = paymentValue;
    }

    public RequestRuleDto(Long id, LotDto lot, SupplierDto supplier, String comment, ShippingMethodDto shippingMethod,
            PaymentMethodDto paymentMethod, Integer paymentValue) {
        this.id = id;
        this.lot = lot;
        this.supplier = supplier;
        this.comment = comment;
        this.shippingMethod = shippingMethod;
        this.paymentMethod = paymentMethod;
        this.paymentValue = paymentValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LotDto getLot() {
        return lot;
    }

    public void setLot(LotDto lot) {
        this.lot = lot;
    }

    public SupplierDto getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDto supplier) {
        this.supplier = supplier;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ShippingMethodDto getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethodDto shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public PaymentMethodDto getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodDto paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getPaymentValue() {
        return paymentValue;
    }

    public void setPaymentValue(Integer paymentValue) {
        this.paymentValue = paymentValue;
    }

}