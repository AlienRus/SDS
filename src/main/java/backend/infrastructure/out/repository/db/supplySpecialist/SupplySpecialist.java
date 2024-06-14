package backend.infrastructure.out.repository.db.supplySpecialist;

import backend.infrastructure.out.repository.db.role.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Supply_specialist", indexes = {
        @Index(name = "role", columnList = "role"),
        @Index(name = "type_of_business", columnList = "type_of_business")
})
public class SupplySpecialist {
    @Id
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role", nullable = false)
    private Role role;

    @Size(max = 128)
    @NotNull
    @Column(name = "email", nullable = false, length = 128, unique = true)
    private String email;

    @Size(max = 64)
    @NotNull
    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @Size(max = 128)
    @NotNull
    @Column(name = "company", nullable = false, length = 128)
    private String company;

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

}