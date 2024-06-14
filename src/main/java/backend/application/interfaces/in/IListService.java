package backend.application.interfaces.in;

import backend.application.dto.ListDto;
import backend.application.dto.SupplierDto;
import backend.application.interfaces.out.repository.ILotFileRepository;
import backend.application.interfaces.out.repository.ILotPositionRepository;
import backend.application.interfaces.out.repository.IPositionRequestRepository;
import backend.application.interfaces.out.repository.IRequestFileRepository;
import backend.application.interfaces.out.repository.IRequestRuleRepository;

public interface IListService {

    public void InjectRepositories(ILotPositionRepository lotPositionRepository,
            IPositionRequestRepository positionRequestRepository, IRequestFileRepository requestFileRepository,
            IRequestRuleRepository requestRuleRepository,
            ILotFileRepository lotFileRepository);

    ListDto getListByLotId(Long lotId);

    public ListDto getListByLotIdForSupplier(Long lotId, SupplierDto supplierDto);
}
