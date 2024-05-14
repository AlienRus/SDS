package backend.application.interfaces.out.repository;

import backend.application.dto.GroupEtsSignerDto;

import java.util.List;

public interface IGroupEtsSignerRepository {
    void createGroupEtsSigner(GroupEtsSignerDto groupEtsSignerDto);

    GroupEtsSignerDto getGroupEtsSignerById(Long id);

    List<GroupEtsSignerDto> getAllGroupEtsSignersByGroupEtsId(Long id);

    List<GroupEtsSignerDto> getAllGroupEtsSigners();

    void updateGroupEtsSigner(GroupEtsSignerDto groupEtsSignerDto);

    void deleteGroupEtsSigner(GroupEtsSignerDto groupEtsSignerDto);
}
