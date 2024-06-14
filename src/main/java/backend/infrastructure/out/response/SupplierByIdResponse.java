package backend.infrastructure.out.response;

import backend.application.dto.SupplierDto;

public class SupplierByIdResponse {
    private Long id;
    private String email;
    private String typeOfBusiness;
    private String company;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
    private String regionOrAddress;
    private String site;
    private Long inn;
    private Long kpp;

    public SupplierByIdResponse(SupplierDto supplierDto) {
        this.id = supplierDto.getId();
        this.email = supplierDto.getEmail();
        if (supplierDto.getTypeOfBusiness() == null) {
            this.typeOfBusiness = null;
        } else {
            this.typeOfBusiness = supplierDto.getTypeOfBusiness().getTypeName();
        }
        this.company = supplierDto.getCompany();
        this.firstName = supplierDto.getFirstName();
        this.lastName = supplierDto.getLastName();
        this.middleName = supplierDto.getMiddleName();
        this.phoneNumber = supplierDto.getPhoneNumber();
        this.regionOrAddress = supplierDto.getRegionOrAddress();
        this.site = supplierDto.getSite();
        this.inn = supplierDto.getInn();
        this.kpp = supplierDto.getInn();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeOfBusiness() {
        return typeOfBusiness;
    }

    public void setTypeOfBusiness(String typeOfBusiness) {
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }

    public Long getKpp() {
        return kpp;
    }

    public void setKpp(Long kpp) {
        this.kpp = kpp;
    }
}
