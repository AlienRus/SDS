package backend.infrastructure.in.rest.request.put.user;

public class UpdateUserRequest {
    private String email;
    private String password;
    private String company;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;
    private String regionOrAddress;
    private String site;
    private Long inn;
    private Long kpp;
    private Boolean nds;

    public UpdateUserRequest() {
    }

    public UpdateUserRequest(String email, String password, String company, String firstName, String lastName,
            String middleName, String phoneNumber, String regionOrAddress, String site, Long inn, Long kpp,
            Boolean nds) {
        this.email = email;
        this.password = password;
        this.company = company;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.regionOrAddress = regionOrAddress;
        this.site = site;
        this.inn = inn;
        this.kpp = kpp;
        this.nds = nds;
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

    public Boolean getNds() {
        return nds;
    }

    public void setNds(Boolean nds) {
        this.nds = nds;
    }

}
