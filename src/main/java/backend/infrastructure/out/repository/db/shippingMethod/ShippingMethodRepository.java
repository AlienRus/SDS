package backend.infrastructure.out.repository.db.shippingMethod;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.ShippingMethodDto;

@Stateless
public class ShippingMethodRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createShippingMethod(ShippingMethodDto shippingMethodDto) {
        ShippingMethod shippingMethod = ShippingMethodMapper.toEntity(shippingMethodDto);
        entityManager.persist(shippingMethod);
    }

    public ShippingMethodDto getShippingMethodById(Long id) {
        ShippingMethod shippingMethod = entityManager.find(ShippingMethod.class, id);
        return ShippingMethodMapper.toDto(shippingMethod);
    }

    public List<ShippingMethodDto> getAllShippingMethods() {
        List<ShippingMethod> shippingMethods = entityManager
                .createQuery("SELECT shippingMethod FROM ShippingMethod shippingMethod", ShippingMethod.class)
                .getResultList();
        return shippingMethods.stream().map(ShippingMethodMapper::toDto).collect(Collectors.toList());
    }

    public void updateShippingMethod(ShippingMethodDto shippingMethodDto) {
        ShippingMethod shippingMethod = ShippingMethodMapper.toEntity(shippingMethodDto);
        entityManager.merge(shippingMethod);
    }

    public void deleteShippingMethod(ShippingMethodDto shippingMethodDto) {
        ShippingMethod shippingMethod = ShippingMethodMapper.toEntity(shippingMethodDto);
        entityManager
                .remove(entityManager.contains(shippingMethod) ? shippingMethod : entityManager.merge(shippingMethod));
    }
}
