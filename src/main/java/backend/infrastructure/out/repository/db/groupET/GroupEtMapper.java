package backend.infrastructure.out.repository.db.groupET;

import backend.application.dto.GroupEtDto;

public class GroupEtMapper {

    public static GroupEtDto toDto(GroupEt groupEt) {
        return new GroupEtDto(
                groupEt.getId(),
                groupEt.getGroupName(),
                groupEt.getManagerPost(),
                groupEt.getManagerFirstName(),
                groupEt.getManagerMiddleName(),
                groupEt.getManagerLastName(),
                groupEt.getNotificationTest());
    }

    public static GroupEt toEntity(GroupEtDto groupEtDto) {
        GroupEt groupEt = new GroupEt();
        groupEt.setId(groupEtDto.getId());
        groupEt.setGroupName(groupEtDto.getGroupName());
        groupEt.setManagerPost(groupEtDto.getManagerPost());
        groupEt.setManagerFirstName(groupEtDto.getManagerFirstName());
        groupEt.setManagerMiddleName(groupEtDto.getManagerMiddleName());
        groupEt.setManagerLastName(groupEtDto.getManagerLastName());
        groupEt.setNotificationTest(groupEtDto.getNotificationTest());
        return groupEt;
    }
}
