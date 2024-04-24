package backend.infrastructure.out.repository.db.request;

import backend.infrastructure.out.repository.db.supplier.Supplier;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Request", indexes = {
        @Index(name = "supplier", columnList = "supplier")
})
public class Request {
    @Id
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @NotNull
    @Column(name = "price_for_one", nullable = false)
    private Integer priceForOne;

    @NotNull
    @Column(name = "count", nullable = false)
    private Integer count;

    @Size(max = 256)
    @NotNull
    @Column(name = "item_name", nullable = false, length = 256)
    private String itemName;

    @NotNull
    @Column(name = "delivery_time", nullable = false)
    private Integer deliveryTime;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supplier", nullable = false)
    private Supplier supplier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPriceForOne() {
        return priceForOne;
    }

    public void setPriceForOne(Integer priceForOne) {
        this.priceForOne = priceForOne;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

}