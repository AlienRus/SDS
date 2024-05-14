package backend.application.interfaces.out.repository;

import backend.application.dto.ShippingMethodDto;

import java.util.List;

public interface IShippingMethodRepository {
    void createShippingMethod(ShippingMethodDto shippingMethodDto);

    ShippingMethodDto getShippingMethodById(Long id);

    List<ShippingMethodDto> getAllShippingMethods();

    void updateShippingMethod(ShippingMethodDto shippingMethodDto);

    void deleteShippingMethod(ShippingMethodDto shippingMethodDto);
}
