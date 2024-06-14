package backend.infrastructure.in.rest.request;

import java.util.List;

public class NewUserRequestDto {
    private Long id;
    private String role;
    private String email;
    private String password;
    private Long typeOfBusinessId;
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
    private List<Long> groupEtsId;

    public NewUserRequestDto(Long id, String role, String email, String password, Long typeOfBusinessId, String company,
            String firstName, String middleName, String lastName, String phoneNumber, String regionOrAddress,
            Boolean nds, String site, Long inn, Long kpp, List<Long> groupEtsId) {
        this.id = id;
        this.role = role;
        this.email = email;
        this.password = password;
        this.typeOfBusinessId = typeOfBusinessId;
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
        this.groupEtsId = groupEtsId;
    }

    public NewUserRequestDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
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

    public Long getTypeOfBusinessId() {
        return typeOfBusinessId;
    }

    public void setTypeOfBusinessId(Long typeOfBusinessId) {
        this.typeOfBusinessId = typeOfBusinessId;
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

    public List<Long> getGroupEtsId() {
        return groupEtsId;
    }

    public void setGroupEtsId(List<Long> groupEtsId) {
        this.groupEtsId = groupEtsId;
    }

}
