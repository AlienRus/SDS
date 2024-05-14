package backend.application.implementation;

import backend.application.dto.ShippingMethodDto;
import backend.application.interfaces.in.IShippingMethodService;
import backend.application.interfaces.out.repository.IShippingMethodRepository;

import java.util.List;

public class ShippingMethodService implements IShippingMethodService {

    private IShippingMethodRepository shippingMethodRepository;

    @Override
    public void InjectShippingMethodRepository(IShippingMethodRepository shippingMethodRepository) {
        this.shippingMethodRepository = shippingMethodRepository;
    }

    @Override
    public void createShippingMethod(ShippingMethodDto shippingMethodDto) {
        shippingMethodRepository.createShippingMethod(shippingMethodDto);
    }

    @Override
    public ShippingMethodDto getShippingMethodById(Long id) {
        return shippingMethodRepository.getShippingMethodById(id);
    }

    @Override
    public List<ShippingMethodDto> getAllShippingMethods() {
        return shippingMethodRepository.getAllShippingMethods();
    }

    @Override
    public void updateShippingMethod(ShippingMethodDto shippingMethodDto) {
        shippingMethodRepository.updateShippingMethod(shippingMethodDto);
    }

    @Override
    public void deleteShippingMethod(ShippingMethodDto shippingMethodDto) {
        shippingMethodRepository.deleteShippingMethod(shippingMethodDto);
    }
}
