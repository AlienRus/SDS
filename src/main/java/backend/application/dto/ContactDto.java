package backend.application.dto;

import backend.infrastructure.out.repository.db.contact.Contact;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link Contact}
 */
public class ContactDto implements Serializable {
    private final Long id;
    private final String name;
    private final String position;
    private final String email;
    private final GroupEtDto groupEts;
    private final String phone;

    public ContactDto(Long id, String name, String position, String email, GroupEtDto groupEts, String phone) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.email = email;
        this.groupEts = groupEts;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public GroupEtDto getGroupEts() {
        return groupEts;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ContactDto entity = (ContactDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.position, entity.position) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.groupEts, entity.groupEts) &&
                Objects.equals(this.phone, entity.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, position, email, groupEts, phone);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "position = " + position + ", " +
                "email = " + email + ", " +
                "groupEts = " + groupEts + ", " +
                "phone = " + phone + ")";
    }
}