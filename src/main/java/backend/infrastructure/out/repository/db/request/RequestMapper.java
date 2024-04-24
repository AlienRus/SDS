package backend.infrastructure.out.repository.db.request;

import backend.application.dto.RequestDto;
import backend.infrastructure.out.repository.db.supplier.SupplierMapper;

public class RequestMapper {

    public static RequestDto toDto(Request request) {
        return new RequestDto(
                request.getId(),
                request.getPriceForOne(),
                request.getCount(),
                request.getItemName(),
                request.getDeliveryTime(),
                SupplierMapper.toDto(request.getSupplier()));
    }

    public static Request toEntity(RequestDto requestDto) {
        Request request = new Request();
        request.setId(requestDto.getId());
        request.setPriceForOne(requestDto.getPriceForOne());
        request.setCount(requestDto.getCount());
        request.setItemName(requestDto.getItemName());
        request.setDeliveryTime(requestDto.getDeliveryTime());
        request.setSupplier(SupplierMapper.toEntity(requestDto.getSupplier()));
        return request;
    }
}
