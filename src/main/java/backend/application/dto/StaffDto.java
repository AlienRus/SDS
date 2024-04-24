package backend.application.dto;

import backend.infrastructure.out.repository.db.staff.Staff;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link Staff}
 */
public class StaffDto implements Serializable {
    private final Long id;
    private final String email;
    private final String password;
    private final RoleDto role;

    public StaffDto(Long id, String email, String password, RoleDto role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public RoleDto getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        StaffDto entity = (StaffDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.role, entity.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, role);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "email = " + email + ", " +
                "password = " + password + ", " +
                "role = " + role + ")";
    }
}