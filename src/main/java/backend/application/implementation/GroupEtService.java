package backend.application.implementation;

import backend.application.dto.GroupEtDto;
import backend.application.interfaces.in.IGroupEtService;
import backend.application.interfaces.out.repository.IGroupEtRepository;

import java.util.List;

public class GroupEtService implements IGroupEtService {
    private IGroupEtRepository groupEtRepository;

    public void InjectGroupEtRepository(IGroupEtRepository groupEtRepository) {
        this.groupEtRepository = groupEtRepository;
    }

    @Override
    public void createGroupEt(GroupEtDto groupEtDto) {
        groupEtRepository.createGroupEt(groupEtDto);
    }

    @Override
    public GroupEtDto getGroupEtById(Long id) {
        return groupEtRepository.getGroupEtById(id);
    }

    @Override
    public List<GroupEtDto> getAllGroupEts() {
        return groupEtRepository.getAllGroupEts();
    }

    @Override
    public void updateGroupEt(GroupEtDto groupEtDto) {
        groupEtRepository.updateGroupEt(groupEtDto);
    }

    @Override
    public void deleteGroupEt(GroupEtDto groupEtDto) {
        groupEtRepository.deleteGroupEt(groupEtDto);
    }
}
