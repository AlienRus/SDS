package backend.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class RequestRuleDto implements Serializable {
    private Long id;
    private LotDto lot;
    private SupplierDto supplier;
    private String comment;

    public RequestRuleDto() {
        
    }

    public RequestRuleDto(Long id, LotDto lot, SupplierDto supplier, String comment) {
        this.id = id;
        this.lot = lot;
        this.supplier = supplier;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public LotDto getLot() {
        return lot;
    }

    public SupplierDto getSupplier() {
        return supplier;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        RequestRuleDto entity = (RequestRuleDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.lot, entity.lot) &&
                Objects.equals(this.supplier, entity.supplier) &&
                Objects.equals(this.comment, entity.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lot, supplier, comment);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "lot = " + lot + ", " +
                "supplier = " + supplier + ", " +
                "comment = " + comment + ")";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLot(LotDto lot) {
        this.lot = lot;
    }

    public void setSupplier(SupplierDto supplier) {
        this.supplier = supplier;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}