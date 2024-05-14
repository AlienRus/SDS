package backend.infrastructure.out.response;

import backend.application.dto.GroupEtsSignerDto;

public class SignerResponse {
    private String post;
    private String firstName;
    private String lastName;
    private String middleName;

    public SignerResponse(GroupEtsSignerDto signer) {
        this.post = signer.getPost();
        this.firstName = signer.getFirstName();
        this.lastName = signer.getLastName();
        this.middleName = signer.getMiddleName();
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
