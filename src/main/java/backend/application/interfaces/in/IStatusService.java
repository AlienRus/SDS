package backend.application.interfaces.in;

import backend.application.dto.StatusDto;
import backend.application.interfaces.out.repository.IStatusRepository;

import java.util.List;

public interface IStatusService {
    public void InjectStatusRepository(IStatusRepository statusRepository);

    void createStatus(StatusDto statusDto);

    StatusDto getStatusById(Long id);

    List<StatusDto> getAllStatuses();

    void updateStatus(StatusDto statusDto);

    void deleteStatus(StatusDto statusDto);
}
