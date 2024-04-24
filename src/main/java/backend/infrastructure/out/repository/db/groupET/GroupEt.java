package backend.infrastructure.out.repository.db.groupET;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Group_ETS")
public class GroupEt {
    @Id
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Size(max = 128)
    @NotNull
    @Column(name = "group_name", nullable = false, length = 128)
    private String groupName;

    @Size(max = 256)
    @NotNull
    @Column(name = "manager_post", nullable = false, length = 256)
    private String managerPost;

    @Size(max = 64)
    @NotNull
    @Column(name = "manager_first_name", nullable = false, length = 64)
    private String managerFirstName;

    @Size(max = 64)
    @NotNull
    @Column(name = "manager_middle_name", nullable = false, length = 64)
    private String managerMiddleName;

    @Size(max = 64)
    @NotNull
    @Column(name = "manager_last_name", nullable = false, length = 64)
    private String managerLastName;

    @Size(max = 1024)
    @Column(name = "notification_test", length = 1024)
    private String notificationTest;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getManagerPost() {
        return managerPost;
    }

    public void setManagerPost(String managerPost) {
        this.managerPost = managerPost;
    }

    public String getManagerFirstName() {
        return managerFirstName;
    }

    public void setManagerFirstName(String managerFirstName) {
        this.managerFirstName = managerFirstName;
    }

    public String getManagerMiddleName() {
        return managerMiddleName;
    }

    public void setManagerMiddleName(String managerMiddleName) {
        this.managerMiddleName = managerMiddleName;
    }

    public String getManagerLastName() {
        return managerLastName;
    }

    public void setManagerLastName(String managerLastName) {
        this.managerLastName = managerLastName;
    }

    public String getNotificationTest() {
        return notificationTest;
    }

    public void setNotificationTest(String notificationTest) {
        this.notificationTest = notificationTest;
    }

}