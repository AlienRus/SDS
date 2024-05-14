package backend.infrastructure.out.response;

import java.util.ArrayList;
import java.util.List;

import backend.application.dto.GroupEtDto;
import backend.application.dto.GroupEtsSignerDto;

public class GroupResponse {
    private Long id;
    private String name;
    private String managerPost;
    private String managerFirstName;
    private String managerLastName;
    private String managerMiddleName;
    private List<SignerResponse> signer;

    public GroupResponse(GroupEtDto group, List<GroupEtsSignerDto> signers) {
        this.id = group.getId();
        this.name = group.getGroupName();
        this.managerPost = group.getManagerPost();
        this.managerFirstName = group.getManagerFirstName();
        this.managerLastName = group.getManagerLastName();
        this.managerMiddleName = group.getManagerMiddleName();

        ArrayList<SignerResponse> signerResponses = new ArrayList<SignerResponse>();

        for (GroupEtsSignerDto signer : signers) {
            signerResponses.add(new SignerResponse(signer));
        }

        this.signer = signerResponses;
    }

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

    public List<SignerResponse> getSigner() {
        return signer;
    }

    public void setSigner(List<SignerResponse> signer) {
        this.signer = signer;
    }

}
