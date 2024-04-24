package backend.infrastructure.out.repository.db.groupEtsSigner;

import backend.infrastructure.out.repository.db.groupET.GroupEt;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Group_ETS_signer", indexes = {
        @Index(name = "group_ETS_id", columnList = "group_ETS_id")
})
public class GroupEtsSigner {
    @Id
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "group_ETS_id", nullable = false)
    private GroupEt groupEts;

    @Size(max = 256)
    @NotNull
    @Column(name = "post", nullable = false, length = 256)
    private String post;

    @Size(max = 64)
    @NotNull
    @Column(name = "first_name", nullable = false, length = 64)
    private String firstName;

    @Size(max = 64)
    @NotNull
    @Column(name = "last_name", nullable = false, length = 64)
    private String lastName;

    @Size(max = 64)
    @NotNull
    @Column(name = "middle_name", nullable = false, length = 64)
    private String middleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GroupEt getGroupEts() {
        return groupEts;
    }

    public void setGroupEts(GroupEt groupEts) {
        this.groupEts = groupEts;
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