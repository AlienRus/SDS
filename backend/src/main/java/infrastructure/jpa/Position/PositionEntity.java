package com.sds.test.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Position")
public class PositionEntity {
    
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

    @Column(name = "unit_name")
    private String unitName;

    @Column(name = "recipient")
    private Integer recipient;

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
    
    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
 
    @ManyToOne()
    @JoinColumn(name = "winner")
    private SupplierEntity supplier;
    
    @Override
    public String toString() {
        return "PositionEntity{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", priceForOne='" + priceForOne + '\'' +
                ", count='" + count + '\'' +
                ", unitName='" + unitName + '\'' +
                ", recipient='" + recipient + '\'' +
                ", type of business='" + supplier.toString() + '\'' +
                '}';
    }
}
