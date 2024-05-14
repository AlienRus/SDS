package backend.application.interfaces.out.repository;

import backend.application.dto.TypeOfBusinessDto;

import java.util.List;

public interface ITypeOfBusinessRepository {
    void createTypeOfBusiness(TypeOfBusinessDto typeOfBusinessDto);

    TypeOfBusinessDto getTypeOfBusinessById(Long id);

    List<TypeOfBusinessDto> getAllTypeOfBusinesses();

    void updateTypeOfBusiness(TypeOfBusinessDto typeOfBusinessDto);

    void deleteTypeOfBusiness(TypeOfBusinessDto typeOfBusinessDto);
}
