package backend.application.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import backend.application.dto.ListDto;
import backend.application.dto.ListFileDto;
import backend.application.dto.ListRequestDto;
import backend.application.dto.ListRuleDto;
import backend.application.dto.ListRulePaymentDto;
import backend.application.dto.LotDto;
import backend.application.dto.LotFileDto;
import backend.application.dto.LotPositionDto;
import backend.application.dto.PositionDto;
import backend.application.dto.RequestDto;
import backend.application.dto.RequestFileDto;
import backend.application.dto.RequestRuleDto;
import backend.application.dto.SupplierDto;
import backend.application.interfaces.in.IListService;
import backend.application.interfaces.out.repository.ILotFileRepository;
import backend.application.interfaces.out.repository.ILotPositionRepository;
import backend.application.interfaces.out.repository.IPositionRequestRepository;
import backend.application.interfaces.out.repository.IRequestFileRepository;
import backend.application.interfaces.out.repository.IRequestRuleRepository;

// import java.util.logging.Level;
// import java.util.logging.Logger;

public class ListService implements IListService {

    private ILotPositionRepository lotPositionRepository;

    private IPositionRequestRepository positionRequestRepository;

    private IRequestFileRepository requestFileRepository;

    private IRequestRuleRepository requestRuleRepository;

    private ILotFileRepository lotFileRepository;

    @Override
    public void InjectRepositories(ILotPositionRepository lotPositionRepository,
            IPositionRequestRepository positionRequestRepository,
            IRequestFileRepository requestFileRepository,
            IRequestRuleRepository requestRuleRepository,
            ILotFileRepository lotFileRepository) {

        this.lotPositionRepository = lotPositionRepository;
        this.positionRequestRepository = positionRequestRepository;
        this.requestFileRepository = requestFileRepository;
        this.requestRuleRepository = requestRuleRepository;
        this.lotFileRepository = lotFileRepository;

    }

    @Override
    public ListDto getListByLotId(Long lotId) {
        List<LotPositionDto> lotPositionDtos = lotPositionRepository.getLotPositionByLotId(lotId);

        List<ListRequestDto> allListRequestDtos = new ArrayList<ListRequestDto>();
        Set<SupplierDto> supplierDtos = new HashSet<SupplierDto>();
        LotDto lotDto = lotPositionDtos.get(0).getLot();
        for (LotPositionDto lotPositionDto : lotPositionDtos) {
            Long positionId = lotPositionDto.getPosition().getId();
            List<RequestDto> requestDtos = positionRequestRepository.getRequestsByPositionId(positionId);

            List<ListRequestDto> listRequestDtos = new ArrayList<ListRequestDto>();

            for (RequestDto requestDto : requestDtos) {
                listRequestDtos.add(new ListRequestDto(requestDto.getId(), positionId, requestDto.getPriceForOne(),
                        requestDto.getCount(), requestDto.getItemName(), requestDto.getDeliveryTime(),
                        requestDto.getSupplier()));
            }

            allListRequestDtos.addAll(listRequestDtos);

        }

        for (ListRequestDto listRequestDto : allListRequestDtos) {
            supplierDtos.add(listRequestDto.getSupplier());
        }

        List<RequestFileDto> allRequestFileDtos = requestFileRepository.getRequestFilesByLotId(lotId);

        List<ListFileDto> listFileDtos = new ArrayList<ListFileDto>();

        for (RequestFileDto requestFileDto : allRequestFileDtos) {
            listFileDtos.add(new ListFileDto(requestFileDto.getPath(),
                    requestFileDto.getSupplier().getId()));
        }

        List<ListRuleDto> listRuleDtos = new ArrayList<ListRuleDto>();

        for (SupplierDto supplierDto : supplierDtos) {
            List<RequestRuleDto> requestRuleDtos = requestRuleRepository
                    .getRequestRulesByLotIdAndSupplierId(lotId, supplierDto.getId());

            for (RequestRuleDto requestRuleDto : requestRuleDtos) {

                ListRulePaymentDto listRulePaymentDto = new ListRulePaymentDto(
                        requestRuleDto.getPaymentMethod().getName(),
                        requestRuleDto.getPaymentValue());

                ListRuleDto listRuleDto = new ListRuleDto(requestRuleDto.getSupplier().getId(),
                        requestRuleDto.getComment(), listRulePaymentDto,
                        requestRuleDto.getShippingMethod().getName());

                listRuleDtos.add(listRuleDto);
            }

        }

        List<PositionDto> positionDtos = new ArrayList<PositionDto>();

        for (LotPositionDto lotPositionDto : lotPositionDtos) {
            positionDtos.add(lotPositionDto.getPosition());
        }

        List<LotFileDto> lotFileDtos = lotFileRepository.getAllLotFilesByLotId(lotId);

        return new ListDto(allListRequestDtos, listFileDtos, listRuleDtos, lotDto, lotFileDtos, positionDtos);
    }

    @Override
    public ListDto getListByLotIdForSupplier(Long lotId, SupplierDto supplierDto) {
        List<LotPositionDto> lotPositionDtos = lotPositionRepository.getLotPositionByLotId(lotId);

        List<ListRequestDto> allListRequestDtos = new ArrayList<ListRequestDto>();

        LotDto lotDto = lotPositionDtos.get(0).getLot();
        for (LotPositionDto lotPositionDto : lotPositionDtos) {
            Long positionId = lotPositionDto.getPosition().getId();
            List<RequestDto> requestDtos = positionRequestRepository.getRequestsByPositionId(positionId);

            List<ListRequestDto> listRequestDtos = new ArrayList<ListRequestDto>();

            for (RequestDto requestDto : requestDtos) {
                if (requestDto.getSupplier().getId() == supplierDto.getId()) {
                    listRequestDtos.add(new ListRequestDto(requestDto.getId(), positionId, requestDto.getPriceForOne(),
                            requestDto.getCount(), requestDto.getItemName(), requestDto.getDeliveryTime(),
                            requestDto.getSupplier()));
                }
            }

            allListRequestDtos.addAll(listRequestDtos);

        }

        List<RequestFileDto> allRequestFileDtos = requestFileRepository.getRequestFilesByLotId(lotId);

        List<ListFileDto> listFileDtos = new ArrayList<ListFileDto>();

        for (RequestFileDto requestFileDto : allRequestFileDtos) {
            listFileDtos.add(new ListFileDto(requestFileDto.getPath(),
                    requestFileDto.getSupplier().getId()));
        }

        List<ListRuleDto> listRuleDtos = new ArrayList<ListRuleDto>();

        List<RequestRuleDto> requestRuleDtos = requestRuleRepository
                .getRequestRulesByLotIdAndSupplierId(lotId, supplierDto.getId());

        for (RequestRuleDto requestRuleDto : requestRuleDtos) {

            ListRulePaymentDto listRulePaymentDto = new ListRulePaymentDto(
                    requestRuleDto.getPaymentMethod().getName(),
                    requestRuleDto.getPaymentValue());

            ListRuleDto listRuleDto = new ListRuleDto(requestRuleDto.getSupplier().getId(),
                    requestRuleDto.getComment(), listRulePaymentDto,
                    requestRuleDto.getShippingMethod().getName());

            listRuleDtos.add(listRuleDto);
        }

        List<PositionDto> positionDtos = new ArrayList<PositionDto>();

        for (LotPositionDto lotPositionDto : lotPositionDtos) {
            positionDtos.add(lotPositionDto.getPosition());
        }

        List<LotFileDto> lotFileDtos = lotFileRepository.getAllLotFilesByLotId(lotId);

        return new ListDto(allListRequestDtos, listFileDtos, listRuleDtos, lotDto, lotFileDtos, positionDtos);
    }
}
