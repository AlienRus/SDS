package backend.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class SupplySpecialistDto implements Serializable {
    private Long id;
    private RoleDto role;
    private String email;
    private String password;
    private String company;
    private Boolean isApproved;

    public SupplySpecialistDto() {

    }

    public SupplySpecialistDto(Long id, RoleDto role, String email, String password,
            String company, Boolean isApproved) {
        this.id = id;
        this.role = role;
        this.email = email;
        this.password = password;
        this.company = company;
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

    public String getCompany() {
        return company;
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
        SupplySpecialistDto entity = (SupplySpecialistDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.role, entity.role) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.company, entity.company) &&
                Objects.equals(this.isApproved, entity.isApproved);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, email, password, company, isApproved);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "role = " + role + ", " +
                "email = " + email + ", " +
                "password = " + password + ", " +
                "company = " + company + ", " +
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

    public void setCompany(String company) {
        this.company = company;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }
}