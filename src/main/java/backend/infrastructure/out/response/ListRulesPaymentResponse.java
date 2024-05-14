package backend.infrastructure.out.response;

public class ListRulesPaymentResponse {
    private String method;
    private Integer value;

    public ListRulesPaymentResponse(String method, Integer value) {
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
        return "ListRulesPaymentResponse [method=" + method + ", value=" + value + "]";
    }
}
