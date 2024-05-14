package backend.application.interfaces.in;

import backend.application.dto.GroupEtDto;
import backend.application.interfaces.out.repository.IGroupEtRepository;

import java.util.List;

public interface IGroupEtService {
    public void InjectGroupEtRepository(IGroupEtRepository groupEtRepository);

    void createGroupEt(GroupEtDto groupEtDto);

    GroupEtDto getGroupEtById(Long id);

    List<GroupEtDto> getAllGroupEts();

    void updateGroupEt(GroupEtDto groupEtDto);

    void deleteGroupEt(GroupEtDto groupEtDto);
}
