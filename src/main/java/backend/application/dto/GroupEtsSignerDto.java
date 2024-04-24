package backend.application.dto;

import backend.infrastructure.out.repository.db.groupEtsSigner.GroupEtsSigner;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link GroupEtsSigner}
 */
public class GroupEtsSignerDto implements Serializable {
    private final Long id;
    private final GroupEtDto groupEts;
    private final String post;
    private final String firstName;
    private final String lastName;
    private final String middleName;

    public GroupEtsSignerDto(Long id, GroupEtDto groupEts, String post, String firstName, String lastName,
            String middleName) {
        this.id = id;
        this.groupEts = groupEts;
        this.post = post;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public Long getId() {
        return id;
    }

    public GroupEtDto getGroupEts() {
        return groupEts;
    }

    public String getPost() {
        return post;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        GroupEtsSignerDto entity = (GroupEtsSignerDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.groupEts, entity.groupEts) &&
                Objects.equals(this.post, entity.post) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.middleName, entity.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupEts, post, firstName, lastName, middleName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "groupEts = " + groupEts + ", " +
                "post = " + post + ", " +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "middleName = " + middleName + ")";
    }
}