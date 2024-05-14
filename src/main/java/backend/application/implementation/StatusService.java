package backend.application.implementation;

import backend.application.dto.StatusDto;
import backend.application.interfaces.in.IStatusService;
import backend.application.interfaces.out.repository.IStatusRepository;

import java.util.List;

public class StatusService implements IStatusService {

    private IStatusRepository statusRepository;

    @Override
    public void InjectStatusRepository(IStatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public void createStatus(StatusDto statusDto) {
        statusRepository.createStatus(statusDto);
    }

    @Override
    public StatusDto getStatusById(Long id) {
        return statusRepository.getStatusById(id);
    }

    @Override
    public List<StatusDto> getAllStatuses() {
        return statusRepository.getAllStatuses();
    }

    @Override
    public void updateStatus(StatusDto statusDto) {
        statusRepository.updateStatus(statusDto);
    }

    @Override
    public void deleteStatus(StatusDto statusDto) {
        statusRepository.deleteStatus(statusDto);
    }
}
