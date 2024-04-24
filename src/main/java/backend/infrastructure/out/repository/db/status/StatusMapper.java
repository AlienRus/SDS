package backend.infrastructure.out.repository.db.status;

import backend.application.dto.StatusDto;

public class StatusMapper {

    public static StatusDto toDto(Status status) {
        return new StatusDto(
                status.getId(),
                status.getStatusName());
    }

    public static Status toEntity(StatusDto statusDto) {
        Status status = new Status();
        status.setId(statusDto.getId());
        status.setStatusName(statusDto.getStatusName());
        return status;
    }
}
