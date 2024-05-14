package backend.application.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import backend.application.dto.ListDto;
import backend.application.dto.ListFileDto;
import backend.application.dto.ListRuleDto;
import backend.application.dto.ListRulePaymentDto;
import backend.application.dto.LotPositionDto;
import backend.application.dto.RequestDto;
import backend.application.dto.RequestFileDto;
import backend.application.dto.RequestRuleDto;
import backend.application.dto.RequestRulesPaymentDto;
import backend.application.dto.RequestRulesShippingMethodDto;
import backend.application.dto.SupplierDto;
import backend.application.interfaces.in.IListService;
import backend.application.interfaces.out.repository.ILotPositionRepository;
import backend.application.interfaces.out.repository.IPositionRequestRepository;
import backend.application.interfaces.out.repository.IRequestFileRepository;
import backend.application.interfaces.out.repository.IRequestRuleRepository;
import backend.application.interfaces.out.repository.IRequestRulesPaymentRepository;
import backend.application.interfaces.out.repository.IRequestRulesShippingMethodRepository;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ListService implements IListService {

    private ILotPositionRepository lotPositionRepository;

    private IPositionRequestRepository positionRequestRepository;

    private IRequestFileRepository requestFileRepository;

    private IRequestRuleRepository requestRuleRepository;

    private IRequestRulesPaymentRepository requestRulesPaymentRepository;

    private IRequestRulesShippingMethodRepository requestRulesShippingMethodRepository;

    public void InjectRepositories(ILotPositionRepository lotPositionRepository,
            IPositionRequestRepository positionRequestRepository, IRequestFileRepository requestFileRepository,
            IRequestRuleRepository requestRuleRepository,
            IRequestRulesPaymentRepository requestRulesPaymentRepository,
            IRequestRulesShippingMethodRepository requestRulesShippingMethodRepository) {

        this.lotPositionRepository = lotPositionRepository;
        this.positionRequestRepository = positionRequestRepository;
        this.requestFileRepository = requestFileRepository;
        this.requestRuleRepository = requestRuleRepository;
        this.requestRulesPaymentRepository = requestRulesPaymentRepository;
        this.requestRulesShippingMethodRepository = requestRulesShippingMethodRepository;

    }

    public ListDto getListByLotId(Long lotId) {
        List<LotPositionDto> lotPositionDtos = lotPositionRepository.getLotPositionByLotId(lotId);

        List<RequestDto> allRequestDtos = new ArrayList<RequestDto>();
        Set<SupplierDto> supplierDtos = new HashSet<SupplierDto>();

        for (LotPositionDto lotPositionDto : lotPositionDtos) {
            Long positionId = lotPositionDto.getPosition().getId();
            List<RequestDto> requestDtos = positionRequestRepository.getRequestsByPositionId(positionId);

            allRequestDtos.addAll(requestDtos);

        }

        for (RequestDto requestDto : allRequestDtos) {
            supplierDtos.add(requestDto.getSupplier());
        }

        List<RequestFileDto> allRequestFileDtos = requestFileRepository.getRequestFilesByLotId(lotId);

        List<ListFileDto> listFileDtos = new ArrayList<ListFileDto>();

        for (RequestFileDto requestFileDto : allRequestFileDtos) {
            listFileDtos.add(new ListFileDto(requestFileDto.getPath(), requestFileDto.getSupplier().getId()));
        }

        List<ListRuleDto> listRuleDtos = new ArrayList<ListRuleDto>();

        for (SupplierDto supplierDto : supplierDtos) {
            List<RequestRuleDto> requestRuleDtos = requestRuleRepository.getRequestRulesByLotIdAndSupplierId(lotId,
                    supplierDto.getId());

            for (RequestRuleDto requestRuleDto : requestRuleDtos) {
                Logger.getLogger(ListService.class.getName()).log(Level.INFO,
                        requestRuleDto.getLot().getRules().getComment());
                RequestRulesPaymentDto requestRulesPaymentDto = requestRulesPaymentRepository
                        .getRequestRulesPaymentsByRequestRule(requestRuleDto).get(0);
                RequestRulesShippingMethodDto requestRulesShippingMethodDto = requestRulesShippingMethodRepository
                        .getRequestRulesShippingMethodsByRequestRule(requestRuleDto).get(0);

                ListRulePaymentDto listRulePaymentDto = new ListRulePaymentDto(
                        requestRulesPaymentDto.getPaymentMethod().getName(), requestRulesPaymentDto.getPaymentValue());
                Logger.getLogger(ListService.class.getName()).log(Level.WARNING,
                        listRulePaymentDto.toString());

                ListRuleDto listRuleDto = new ListRuleDto(requestRuleDto.getLot().getRules().getComment(), listRulePaymentDto,
                        requestRulesShippingMethodDto.getShippingMethod().getName());
                Logger.getLogger(ListService.class.getName()).log(Level.WARNING,
                        listRuleDto.toString());
                listRuleDtos.add(listRuleDto);
            }

        }

        return new ListDto(allRequestDtos, listFileDtos, listRuleDtos);
    }
}
