package backend.infrastructure.out.repository.db.position;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.PositionDto;
import backend.application.interfaces.out.repository.IPositionRepository;

@Stateless
public class PositionRepository implements IPositionRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createPosition(PositionDto positionDto) {
        Position position = PositionMapper.toEntity(positionDto);
        entityManager.persist(position);
    }

    public PositionDto getPositionById(Long id) {
        Position position = entityManager.find(Position.class, id);
        return PositionMapper.toDto(position);
    }

    public List<PositionDto> getAllPositions() {
        List<Position> positions = entityManager.createQuery("SELECT position FROM Position position", Position.class)
                .getResultList();
        return positions.stream()
                .map(PositionMapper::toDto)
                .collect(Collectors.toList());
    }

    public void updatePosition(PositionDto positionDto) {
        Position position = PositionMapper.toEntity(positionDto);
        entityManager.merge(position);
    }

    public void deletePosition(PositionDto positionDto) {
        Position position = PositionMapper.toEntity(positionDto);
        entityManager.remove(entityManager.contains(position) ? position : entityManager.merge(position));
    }
}
