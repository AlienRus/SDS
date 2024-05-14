package backend.infrastructure.out.repository.db.typeOfBusiness;

import backend.application.dto.TypeOfBusinessDto;

public class TypeOfBusinessMapper {

    public static TypeOfBusinessDto toDto(TypeOfBusiness typeOfBusiness) {
        if (typeOfBusiness == null) {
            return null;
        }
        return new TypeOfBusinessDto(
                typeOfBusiness.getId(),
                typeOfBusiness.getTypeName());
    }

    public static TypeOfBusiness toEntity(TypeOfBusinessDto typeOfBusinessDto) {
        if (typeOfBusinessDto == null) {
            return null;
        }
        TypeOfBusiness typeOfBusiness = new TypeOfBusiness();
        typeOfBusiness.setId(typeOfBusinessDto.getId());
        typeOfBusiness.setTypeName(typeOfBusinessDto.getTypeName());
        return typeOfBusiness;
    }
}
