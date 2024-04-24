package backend.infrastructure.out.repository.db.contact;

import backend.infrastructure.out.repository.db.groupET.GroupEt;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Contacts", indexes = {
        @Index(name = "group_ETS", columnList = "group_ETS")
})
public class Contact {
    @Id
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Size(max = 256)
    @NotNull
    @Column(name = "name", nullable = false, length = 256)
    private String name;

    @Size(max = 128)
    @NotNull
    @Column(name = "position", nullable = false, length = 128)
    private String position;

    @Size(max = 128)
    @Column(name = "email", length = 128)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_ETS")
    private GroupEt groupEts;

    @Size(max = 32)
    @Column(name = "phone", length = 32)
    private String phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GroupEt getGroupEts() {
        return groupEts;
    }

    public void setGroupEts(GroupEt groupEts) {
        this.groupEts = groupEts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}