package backend.infrastructure.in.rest.request.put.group;

public class UpdateGroupEt {
    private String name;
    private String managerPost;
    private String managerFirstName;
    private String managerLastName;
    private String managerMiddleName;

    public UpdateGroupEt() {
    }

    public UpdateGroupEt(String name, String managerPost, String managerFirstName, String managerLastName,
            String managerMiddleName) {
        this.name = name;
        this.managerPost = managerPost;
        this.managerFirstName = managerFirstName;
        this.managerLastName = managerLastName;
        this.managerMiddleName = managerMiddleName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getManagerLastName() {
        return managerLastName;
    }

    public void setManagerLastName(String managerLastName) {
        this.managerLastName = managerLastName;
    }

    public String getManagerMiddleName() {
        return managerMiddleName;
    }

    public void setManagerMiddleName(String managerMiddleName) {
        this.managerMiddleName = managerMiddleName;
    }

}
