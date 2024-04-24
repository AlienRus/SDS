package backend.infrastructure.out.repository.db.requestFile;

import backend.infrastructure.out.repository.db.supplier.SupplierMapper;
import backend.application.dto.RequestFileDto;
import backend.infrastructure.out.repository.db.lot.LotMapper;

public class RequestFileMapper {

    public static RequestFileDto toDto(RequestFile requestFile) {
        return new RequestFileDto(
                requestFile.getId(),
                LotMapper.toDto(requestFile.getLot()),
                SupplierMapper.toDto(requestFile.getSupplier()),
                requestFile.getPath());
    }

    public static RequestFile toEntity(RequestFileDto requestFileDto) {
        RequestFile requestFile = new RequestFile();
        requestFile.setId(requestFileDto.getId());
        requestFile.setLot(LotMapper.toEntity(requestFileDto.getLot()));
        requestFile.setSupplier(SupplierMapper.toEntity(requestFileDto.getSupplier()));
        requestFile.setPath(requestFileDto.getPath());
        return requestFile;
    }
}
