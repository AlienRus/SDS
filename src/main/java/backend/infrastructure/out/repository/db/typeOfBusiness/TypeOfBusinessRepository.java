package backend.infrastructure.out.repository.db.typeOfBusiness;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.TypeOfBusinessDto;
import backend.application.interfaces.out.repository.ITypeOfBusinessRepository;

@Stateless
public class TypeOfBusinessRepository implements ITypeOfBusinessRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createTypeOfBusiness(TypeOfBusinessDto typeOfBusinessDto) {
        TypeOfBusiness typeOfBusiness = TypeOfBusinessMapper.toEntity(typeOfBusinessDto);
        entityManager.persist(typeOfBusiness);
    }

    public TypeOfBusinessDto getTypeOfBusinessById(Long id) {
        TypeOfBusiness typeOfBusiness = entityManager.find(TypeOfBusiness.class, id);
        return TypeOfBusinessMapper.toDto(typeOfBusiness);
    }

    public List<TypeOfBusinessDto> getAllTypeOfBusinesses() {
        List<TypeOfBusiness> typeOfBusinesses = entityManager
                .createQuery("SELECT tob FROM TypeOfBusiness tob", TypeOfBusiness.class).getResultList();
        return typeOfBusinesses.stream().map(TypeOfBusinessMapper::toDto).collect(Collectors.toList());
    }

    public void updateTypeOfBusiness(TypeOfBusinessDto typeOfBusinessDto) {
        TypeOfBusiness typeOfBusiness = TypeOfBusinessMapper.toEntity(typeOfBusinessDto);
        entityManager.merge(typeOfBusiness);
    }

    public void deleteTypeOfBusiness(TypeOfBusinessDto typeOfBusinessDto) {
        TypeOfBusiness typeOfBusiness = TypeOfBusinessMapper.toEntity(typeOfBusinessDto);
        entityManager
                .remove(entityManager.contains(typeOfBusiness) ? typeOfBusiness : entityManager.merge(typeOfBusiness));
    }
}
