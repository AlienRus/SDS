package backend.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class GroupEtsSignerDto implements Serializable {
    private Long id;
    private GroupEtDto groupEts;
    private String post;
    private String firstName;
    private String lastName;
    private String middleName;

    public GroupEtsSignerDto() {

    }

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setGroupEts(GroupEtDto groupEts) {
        this.groupEts = groupEts;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}