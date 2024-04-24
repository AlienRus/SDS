package backend.infrastructure.out.repository.db.shippingMethod;

import backend.application.dto.ShippingMethodDto;

public class ShippingMethodMapper {

    public static ShippingMethodDto toDto(ShippingMethod shippingMethod) {
        return new ShippingMethodDto(
                shippingMethod.getId(),
                shippingMethod.getName());
    }

    public static ShippingMethod toEntity(ShippingMethodDto shippingMethodDto) {
        ShippingMethod shippingMethod = new ShippingMethod();
        shippingMethod.setId(shippingMethodDto.getId());
        shippingMethod.setName(shippingMethodDto.getName());
        return shippingMethod;
    }
}