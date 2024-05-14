package backend.application.interfaces.in;

import backend.application.dto.ListDto;
import backend.application.interfaces.out.repository.ILotPositionRepository;
import backend.application.interfaces.out.repository.IPositionRequestRepository;
import backend.application.interfaces.out.repository.IRequestFileRepository;
import backend.application.interfaces.out.repository.IRequestRuleRepository;
import backend.application.interfaces.out.repository.IRequestRulesPaymentRepository;
import backend.application.interfaces.out.repository.IRequestRulesShippingMethodRepository;

public interface IListService {

    public void InjectRepositories(ILotPositionRepository lotPositionRepository,
            IPositionRequestRepository positionRequestRepository, IRequestFileRepository requestFileRepository,
            IRequestRuleRepository requestRuleRepository,
            IRequestRulesPaymentRepository requestRulesPaymentRepository,
            IRequestRulesShippingMethodRepository requestRulesShippingMethodRepository);

    ListDto getListByLotId(Long lotId);
}
