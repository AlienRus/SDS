package backend.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class GroupEtDto implements Serializable {
    private Long id;
    private String name;
    private String managerPost;
    private String managerFirstName;
    private String managerMiddleName;
    private String managerLastName;
    private String notificationTest;

    public GroupEtDto() {

    }

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManagerPost(String managerPost) {
        this.managerPost = managerPost;
    }

    public void setManagerFirstName(String managerFirstName) {
        this.managerFirstName = managerFirstName;
    }

    public void setManagerMiddleName(String managerMiddleName) {
        this.managerMiddleName = managerMiddleName;
    }

    public void setManagerLastName(String managerLastName) {
        this.managerLastName = managerLastName;
    }

    public void setNotificationTest(String notificationTest) {
        this.notificationTest = notificationTest;
    }
}