package com.sds.test.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Request")
public class RequestEntity {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "price_for_one")
    private Integer priceForOne;

    @Column(name = "count")
    private Integer count;

    @Column(name = "delivery_time")
    private Integer deliveryTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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
    
    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @ManyToOne()
    @JoinColumn(name = "supplier")
    private SupplierEntity supplier;
    
    @Override
    public String toString() {
        return "RequestEntity{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", priceForOne='" + priceForOne + '\'' +
                ", count='" + count + '\'' +
                ", deliveryTime='" + deliveryTime + '\'' +
                ", supplier='" + supplier.toString() + '\'' +
                '}';
    }
}
