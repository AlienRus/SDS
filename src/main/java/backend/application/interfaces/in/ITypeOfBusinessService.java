package backend.application.interfaces.in;

import backend.application.dto.TypeOfBusinessDto;
import backend.application.interfaces.out.repository.ITypeOfBusinessRepository;

import java.util.List;

public interface ITypeOfBusinessService {
    public void InjectTypeOfBusinessRepository(ITypeOfBusinessRepository typeOfBusinessRepository);

    void createTypeOfBusiness(TypeOfBusinessDto typeOfBusinessDto);

    TypeOfBusinessDto getTypeOfBusinessById(Long id);

    List<TypeOfBusinessDto> getAllTypeOfBusinesses();

    void updateTypeOfBusiness(TypeOfBusinessDto typeOfBusinessDto);

    void deleteTypeOfBusiness(TypeOfBusinessDto typeOfBusinessDto);
}
