package backend.application.interfaces.in;

import backend.application.dto.ShippingMethodDto;
import backend.application.interfaces.out.repository.IShippingMethodRepository;

import java.util.List;

public interface IShippingMethodService {
    public void InjectShippingMethodRepository(IShippingMethodRepository shippingMethodRepository);

    void createShippingMethod(ShippingMethodDto shippingMethodDto);

    ShippingMethodDto getShippingMethodById(Long id);

    List<ShippingMethodDto> getAllShippingMethods();

    void updateShippingMethod(ShippingMethodDto shippingMethodDto);

    void deleteShippingMethod(ShippingMethodDto shippingMethodDto);
}
