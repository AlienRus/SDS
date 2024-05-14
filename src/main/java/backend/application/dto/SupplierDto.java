package backend.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class SupplierDto implements Serializable {
    private Long id;
    private RoleDto role;
    private String email;
    private String password;
    private TypeOfBusinessDto typeOfBusiness;
    private String company;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String regionOrAddress;
    private Boolean nds;
    private String site;
    private Long inn;
    private Long kpp;
    private Boolean isApproved;

    public SupplierDto() {

    }

    public SupplierDto(Long id, RoleDto role, String email, String password, TypeOfBusinessDto typeOfBusiness,
            String company, String firstName, String middleName, String lastName, String phoneNumber,
            String regionOrAddress, Boolean nds, String site, Long inn, Long kpp, Boolean isApproved) {
        this.id = id;
        this.role = role;
        this.email = email;
        this.password = password;
        this.typeOfBusiness = typeOfBusiness;
        this.company = company;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.regionOrAddress = regionOrAddress;
        this.nds = nds;
        this.site = site;
        this.inn = inn;
        this.kpp = kpp;
        this.isApproved = isApproved;
    }

    public Long getId() {
        return id;
    }

    public RoleDto getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public TypeOfBusinessDto getTypeOfBusiness() {
        return typeOfBusiness;
    }

    public String getCompany() {
        return company;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRegionOrAddress() {
        return regionOrAddress;
    }

    public Boolean getNds() {
        return nds;
    }

    public String getSite() {
        return site;
    }

    public Long getInn() {
        return inn;
    }

    public Long getKpp() {
        return kpp;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SupplierDto entity = (SupplierDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.role, entity.role) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.typeOfBusiness, entity.typeOfBusiness) &&
                Objects.equals(this.company, entity.company) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.middleName, entity.middleName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.phoneNumber, entity.phoneNumber) &&
                Objects.equals(this.regionOrAddress, entity.regionOrAddress) &&
                Objects.equals(this.nds, entity.nds) &&
                Objects.equals(this.site, entity.site) &&
                Objects.equals(this.inn, entity.inn) &&
                Objects.equals(this.kpp, entity.kpp) &&
                Objects.equals(this.isApproved, entity.isApproved);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, email, password, typeOfBusiness, company, firstName, middleName, lastName,
                phoneNumber, regionOrAddress, nds, site, inn, kpp, isApproved);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "role = " + role + ", " +
                "email = " + email + ", " +
                "password = " + password + ", " +
                "typeOfBusiness = " + typeOfBusiness + ", " +
                "company = " + company + ", " +
                "firstName = " + firstName + ", " +
                "middleName = " + middleName + ", " +
                "lastName = " + lastName + ", " +
                "phoneNumber = " + phoneNumber + ", " +
                "regionOrAddress = " + regionOrAddress + ", " +
                "nds = " + nds + ", " +
                "site = " + site + ", " +
                "inn = " + inn + ", " +
                "kpp = " + kpp + ", " +
                "isApproved = " + isApproved + ")";
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRole(RoleDto role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTypeOfBusiness(TypeOfBusinessDto typeOfBusiness) {
        this.typeOfBusiness = typeOfBusiness;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setRegionOrAddress(String regionOrAddress) {
        this.regionOrAddress = regionOrAddress;
    }

    public void setNds(Boolean nds) {
        this.nds = nds;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }

    public void setKpp(Long kpp) {
        this.kpp = kpp;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }
}