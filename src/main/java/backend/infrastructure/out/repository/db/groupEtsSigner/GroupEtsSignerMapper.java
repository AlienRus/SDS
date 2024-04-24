package backend.infrastructure.out.repository.db.groupEtsSigner;

import backend.application.dto.GroupEtsSignerDto;
import backend.infrastructure.out.repository.db.groupET.GroupEtMapper;

public class GroupEtsSignerMapper {

    public static GroupEtsSignerDto toDto(GroupEtsSigner groupEtsSigner) {
        return new GroupEtsSignerDto(
                groupEtsSigner.getId(),
                groupEtsSigner.getGroupEts() != null ? GroupEtMapper.toDto(groupEtsSigner.getGroupEts()) : null,
                groupEtsSigner.getPost(),
                groupEtsSigner.getFirstName(),
                groupEtsSigner.getLastName(),
                groupEtsSigner.getMiddleName());
    }

    public static GroupEtsSigner toEntity(GroupEtsSignerDto groupEtsSignerDto) {
        GroupEtsSigner groupEtsSigner = new GroupEtsSigner();
        groupEtsSigner.setId(groupEtsSignerDto.getId());
        groupEtsSigner.setGroupEts(
                groupEtsSignerDto.getGroupEts() != null ? GroupEtMapper.toEntity(groupEtsSignerDto.getGroupEts())
                        : null);
        groupEtsSigner.setPost(groupEtsSignerDto.getPost());
        groupEtsSigner.setFirstName(groupEtsSignerDto.getFirstName());
        groupEtsSigner.setLastName(groupEtsSignerDto.getLastName());
        groupEtsSigner.setMiddleName(groupEtsSignerDto.getMiddleName());
        return groupEtsSigner;
    }
}
