package backend.infrastructure.out.repository.db.positionRequest;

import backend.infrastructure.out.repository.db.request.RequestMapper;
import backend.application.dto.PositionRequestDto;
import backend.infrastructure.out.repository.db.position.PositionMapper;

public class PositionRequestMapper {

    public static PositionRequestDto toDto(PositionRequest positionRequest) {
        return new PositionRequestDto(
                positionRequest.getId(),
                PositionMapper.toDto(positionRequest.getPosition()),
                RequestMapper.toDto(positionRequest.getRequest()));
    }

    public static PositionRequest toEntity(PositionRequestDto positionRequestDto) {
        PositionRequest positionRequest = new PositionRequest();
        positionRequest.setId(positionRequestDto.getId());
        positionRequest.setPosition(PositionMapper.toEntity(positionRequestDto.getPosition()));
        positionRequest.setRequest(RequestMapper.toEntity(positionRequestDto.getRequest()));
        return positionRequest;
    }
}