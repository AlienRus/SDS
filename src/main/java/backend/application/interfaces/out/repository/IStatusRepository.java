package backend.application.interfaces.out.repository;

import backend.application.dto.StatusDto;

import java.util.List;

public interface IStatusRepository {
    void createStatus(StatusDto statusDto);

    StatusDto getStatusById(Long id);

    List<StatusDto> getAllStatuses();

    void updateStatus(StatusDto statusDto);

    void deleteStatus(StatusDto statusDto);
}
