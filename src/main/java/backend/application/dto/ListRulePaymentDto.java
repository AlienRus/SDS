package backend.application.dto;

public class ListRulePaymentDto {
    private String method;
    private Integer value;

    public ListRulePaymentDto(String method, Integer value) {
        this.method = method;
        this.value = value;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ListRulePaymentDto [method=" + method + ", value=" + value + "]";
    }
}
