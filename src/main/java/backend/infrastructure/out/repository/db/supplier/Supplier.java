package backend.infrastructure.out.repository.db.supplier;

import backend.infrastructure.out.repository.db.typeOfBusiness.TypeOfBusiness;
import backend.infrastructure.out.repository.db.role.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Supplier", indexes = {
        @Index(name = "role", columnList = "role"),
        @Index(name = "type_of_business", columnList = "type_of_business")
})
public class Supplier {
    @Id
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role")
    private Role role;

    @Size(max = 128)
    @NotNull
    @Column(name = "email", nullable = false, length = 128)
    private String email;

    @Size(max = 64)
    @NotNull
    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_of_business")
    private TypeOfBusiness typeOfBusiness;

    @Size(max = 128)
    @NotNull
    @Column(name = "company", nullable = false, length = 128)
    private String company;

    @Size(max = 64)
    @NotNull
    @Column(name = "first_name", nullable = false, length = 64)
    private String firstName;

    @Size(max = 64)
    @NotNull
    @Column(name = "middle_name", nullable = false, length = 64)
    private String middleName;

    @Size(max = 64)
    @NotNull
    @Column(name = "last_name", nullable = false, length = 64)
    private String lastName;

    @Size(max = 64)
    @Column(name = "phone_number", length = 64)
    private String phoneNumber;

    @Size(max = 256)
    @NotNull
    @Column(name = "region_or_address", nullable = false, length = 256)
    private String regionOrAddress;

    @NotNull
    @Column(name = "NDS", nullable = false)
    private Boolean nds = false;

    @Size(max = 512)
    @Column(name = "site", length = 512)
    private String site;

    @NotNull
    @Column(name = "INN", nullable = false)
    private Integer inn;

    @NotNull
    @Column(name = "KPP", nullable = false)
    private Integer kpp;

    @NotNull
    @Column(name = "is_approved", nullable = false)
    private Boolean isApproved = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TypeOfBusiness getTypeOfBusiness() {
        return typeOfBusiness;
    }

    public void setTypeOfBusiness(TypeOfBusiness typeOfBusiness) {
        this.typeOfBusiness = typeOfBusiness;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRegionOrAddress() {
        return regionOrAddress;
    }

    public void setRegionOrAddress(String regionOrAddress) {
        this.regionOrAddress = regionOrAddress;
    }

    public Boolean getNds() {
        return nds;
    }

    public void setNds(Boolean nds) {
        this.nds = nds;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Integer getInn() {
        return inn;
    }

    public void setInn(Integer inn) {
        this.inn = inn;
    }

    public Integer getKpp() {
        return kpp;
    }

    public void setKpp(Integer kpp) {
        this.kpp = kpp;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

}