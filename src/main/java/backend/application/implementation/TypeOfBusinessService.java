package backend.application.implementation;

import backend.application.dto.TypeOfBusinessDto;
import backend.application.interfaces.in.ITypeOfBusinessService;
import backend.application.interfaces.out.repository.ITypeOfBusinessRepository;

import java.util.List;

public class TypeOfBusinessService implements ITypeOfBusinessService {

    private ITypeOfBusinessRepository typeOfBusinessRepository;

    @Override
    public void InjectTypeOfBusinessRepository(ITypeOfBusinessRepository typeOfBusinessRepository) {
        this.typeOfBusinessRepository = typeOfBusinessRepository;
    }

    @Override
    public void createTypeOfBusiness(TypeOfBusinessDto typeOfBusinessDto) {
        typeOfBusinessRepository.createTypeOfBusiness(typeOfBusinessDto);
    }

    @Override
    public TypeOfBusinessDto getTypeOfBusinessById(Long id) {
        return typeOfBusinessRepository.getTypeOfBusinessById(id);
    }

    @Override
    public List<TypeOfBusinessDto> getAllTypeOfBusinesses() {
        return typeOfBusinessRepository.getAllTypeOfBusinesses();
    }

    @Override
    public void updateTypeOfBusiness(TypeOfBusinessDto typeOfBusinessDto) {
        typeOfBusinessRepository.updateTypeOfBusiness(typeOfBusinessDto);
    }

    @Override
    public void deleteTypeOfBusiness(TypeOfBusinessDto typeOfBusinessDto) {
        typeOfBusinessRepository.deleteTypeOfBusiness(typeOfBusinessDto);
    }
}
