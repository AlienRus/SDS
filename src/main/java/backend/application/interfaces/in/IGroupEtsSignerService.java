package backend.application.interfaces.in;

import backend.application.dto.GroupEtsSignerDto;
import backend.application.interfaces.out.repository.IGroupEtsSignerRepository;

import java.util.List;

public interface IGroupEtsSignerService {
    public void InjectGroupEtsSignerRepository(IGroupEtsSignerRepository groupEtsSignerRepository);

    void createGroupEtsSigner(GroupEtsSignerDto groupEtsSignerDto);

    GroupEtsSignerDto getGroupEtsSignerById(Long id);

    List<GroupEtsSignerDto> getAllGroupEtsSignersByGroupEtsId(Long id);

    List<GroupEtsSignerDto> getAllGroupEtsSigners();

    void updateGroupEtsSigner(GroupEtsSignerDto groupEtsSignerDto);

    void deleteGroupEtsSigner(GroupEtsSignerDto groupEtsSignerDto);
}
