package com.sds.test.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Supplier")
public class SupplierEntity {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "role")
    private RoleEntity role;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
    
    @ManyToOne()
    @JoinColumn(name = "type_of_business")
    private TypeOfBusinessEntity typeOfBusiness;

    @Column(name = "company")
    private String company;

    @Override
    public String toString() {
        return "SupplierEntity{" +
                "id=" + id +
                ", role='" + role.toString() + '\'' +
                ", email='" + email.toString() + '\'' +
                ", password='" + password.toString() + '\'' +
                ", type of business='" + typeOfBusiness.toString() + '\'' +
                ", company='" + company.toString() + '\'' +
                '}';
    }
}
