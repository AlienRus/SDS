package backend.application.implementation;

import backend.application.dto.GroupEtsSignerDto;
import backend.application.interfaces.in.IGroupEtsSignerService;
import backend.application.interfaces.out.repository.IGroupEtsSignerRepository;

import java.util.List;

public class GroupEtsSignerService implements IGroupEtsSignerService {

    private IGroupEtsSignerRepository groupEtsSignerRepository;

    @Override
    public void InjectGroupEtsSignerRepository(IGroupEtsSignerRepository groupEtsSignerRepository) {
        this.groupEtsSignerRepository = groupEtsSignerRepository;
    }

    @Override
    public void createGroupEtsSigner(GroupEtsSignerDto groupEtsSignerDto) {
        groupEtsSignerRepository.createGroupEtsSigner(groupEtsSignerDto);
    }

    @Override
    public GroupEtsSignerDto getGroupEtsSignerById(Long id) {
        return groupEtsSignerRepository.getGroupEtsSignerById(id);
    }

    @Override
    public List<GroupEtsSignerDto> getAllGroupEtsSignersByGroupEtsId(Long id) {
        return groupEtsSignerRepository.getAllGroupEtsSignersByGroupEtsId(id);
    }

    @Override
    public List<GroupEtsSignerDto> getAllGroupEtsSigners() {
        return groupEtsSignerRepository.getAllGroupEtsSigners();
    }

    @Override
    public void updateGroupEtsSigner(GroupEtsSignerDto groupEtsSignerDto) {
        groupEtsSignerRepository.updateGroupEtsSigner(groupEtsSignerDto);
    }

    @Override
    public void deleteGroupEtsSigner(GroupEtsSignerDto groupEtsSignerDto) {
        groupEtsSignerRepository.deleteGroupEtsSigner(groupEtsSignerDto);
    }
}
