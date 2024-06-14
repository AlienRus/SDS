package backend.application.interfaces.in;

import backend.application.dto.LotDto;
import backend.application.interfaces.out.repository.IGroupEtRepository;
import backend.application.interfaces.out.repository.ILotRepository;
import backend.application.interfaces.out.repository.IStatusRepository;
import backend.application.interfaces.out.repository.ISupplySpecialistRepository;

import java.util.List;

public interface ILotService {
    public void InjectLotRepository(ILotRepository lotRepository,
            ISupplySpecialistRepository supplySpecialistRepository, IStatusRepository statusRepository,
            IGroupEtRepository groupEtRepository);

    void createLot(LotDto lotDto);

    void createLotWithData(LotDto lotDto, int lotCreatorId, int statusId, int groupEtsId);

    Long getLatestLotId();

    LotDto getLotById(Long id);

    List<LotDto> getAllLots();

    List<LotDto> getAllLotsByGroup(Long groupId);

    void updateLot(LotDto lotDto);

    void deleteLot(LotDto lotDto);
}
