package backend.application.dto;

import backend.infrastructure.out.repository.db.groupET.GroupEt;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link GroupEt}
 */
public class GroupEtDto implements Serializable {
    private final Long id;
    private final String name;
    private final String managerPost;
    private final String managerFirstName;
    private final String managerMiddleName;
    private final String managerLastName;
    private final String notificationTest;

    public GroupEtDto(Long id, String groupName, String managerPost, String managerFirstName, String managerMiddleName,
            String managerLastName, String notificationTest) {
        this.id = id;
        this.name = groupName;
        this.managerPost = managerPost;
        this.managerFirstName = managerFirstName;
        this.managerMiddleName = managerMiddleName;
        this.managerLastName = managerLastName;
        this.notificationTest = notificationTest;
    }

    public Long getId() {
        return id;
    }

    public String getGroupName() {
        return name;
    }

    public String getManagerPost() {
        return managerPost;
    }

    public String getManagerFirstName() {
        return managerFirstName;
    }

    public String getManagerMiddleName() {
        return managerMiddleName;
    }

    public String getManagerLastName() {
        return managerLastName;
    }

    public String getNotificationTest() {
        return notificationTest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        GroupEtDto entity = (GroupEtDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.managerPost, entity.managerPost) &&
                Objects.equals(this.managerFirstName, entity.managerFirstName) &&
                Objects.equals(this.managerMiddleName, entity.managerMiddleName) &&
                Objects.equals(this.managerLastName, entity.managerLastName) &&
                Objects.equals(this.notificationTest, entity.notificationTest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, managerPost, managerFirstName, managerMiddleName, managerLastName,
                notificationTest);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "groupName = " + name + ", " +
                "managerPost = " + managerPost + ", " +
                "managerFirstName = " + managerFirstName + ", " +
                "managerMiddleName = " + managerMiddleName + ", " +
                "managerLastName = " + managerLastName + ", " +
                "notificationTest = " + notificationTest + ")";
    }
}