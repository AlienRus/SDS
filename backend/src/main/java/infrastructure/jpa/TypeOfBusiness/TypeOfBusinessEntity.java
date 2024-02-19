package com.sds.test.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Type_of_business")
public class TypeOfBusinessEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "type_name")
    private String name;

    @Override
    public String toString() {
        return "TypeOfBusiness{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
