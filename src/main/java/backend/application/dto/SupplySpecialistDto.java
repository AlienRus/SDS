package backend.application.dto;

import backend.infrastructure.out.repository.db.supplySpecialist.SupplySpecialist;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link SupplySpecialist}
 */
public class SupplySpecialistDto implements Serializable {
    private final Long id;
    private final RoleDto role;
    private final String email;
    private final String password;
    private final TypeOfBusinessDto typeOfBusiness;
    private final String company;
    private final Boolean isApproved;

    public SupplySpecialistDto(Long id, RoleDto role, String email, String password, TypeOfBusinessDto typeOfBusiness,
            String company, Boolean isApproved) {
        this.id = id;
        this.role = role;
        this.email = email;
        this.password = password;
        this.typeOfBusiness = typeOfBusiness;
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

    public TypeOfBusinessDto getTypeOfBusiness() {
        return typeOfBusiness;
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
                Objects.equals(this.typeOfBusiness, entity.typeOfBusiness) &&
                Objects.equals(this.company, entity.company) &&
                Objects.equals(this.isApproved, entity.isApproved);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, email, password, typeOfBusiness, company, isApproved);
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
                "isApproved = " + isApproved + ")";
    }
}