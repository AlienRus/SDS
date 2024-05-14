package backend.application.interfaces.out.repository;

import backend.application.dto.GroupEtDto;

import java.util.List;

public interface IGroupEtRepository {
    void createGroupEt(GroupEtDto groupEtDto);

    GroupEtDto getGroupEtById(Long id);

    List<GroupEtDto> getAllGroupEts();

    void updateGroupEt(GroupEtDto groupEtDto);

    void deleteGroupEt(GroupEtDto groupEtDto);
}
