package backend.application.implementation;

import backend.application.dto.GroupEtDto;
import backend.application.dto.LotDto;
import backend.application.dto.StatusDto;
import backend.application.dto.SupplySpecialistDto;
import backend.application.interfaces.in.ILotService;
import backend.application.interfaces.out.repository.IGroupEtRepository;
import backend.application.interfaces.out.repository.ILotRepository;
import backend.application.interfaces.out.repository.IStatusRepository;
import backend.application.interfaces.out.repository.ISupplySpecialistRepository;

import java.util.List;

public class LotService implements ILotService {

    private ILotRepository lotRepository;

    private ISupplySpecialistRepository supplySpecialistRepository;

    private IStatusRepository statusRepository;

    private IGroupEtRepository groupEtRepository;

    @Override
    public void InjectLotRepository(ILotRepository lotRepository,
            ISupplySpecialistRepository supplySpecialistRepository, IStatusRepository statusRepository,
            IGroupEtRepository groupEtRepository) {
        this.lotRepository = lotRepository;
        this.supplySpecialistRepository = supplySpecialistRepository;
        this.statusRepository = statusRepository;
        this.groupEtRepository = groupEtRepository;
    }

    @Override
    public void createLot(LotDto lotDto) {
        lotRepository.createLot(lotDto);
    }

    @Override
    public void createLotWithData(LotDto lotDto, int lotCreatorId, int statusId, int groupEtsId) {
        SupplySpecialistDto supplySpecialistDto = supplySpecialistRepository
                .getSupplySpecialistById(Long.valueOf(lotCreatorId));
        StatusDto statusDto = statusRepository.getStatusById(Long.valueOf(statusId));
        GroupEtDto groupEtDto = groupEtRepository.getGroupEtById(Long.valueOf(groupEtsId));

        lotDto.setLotCreator(supplySpecialistDto);
        lotDto.setStatus(statusDto);
        lotDto.setGroupEts(groupEtDto);

        lotRepository.createLot(lotDto);
    }

    @Override
    public LotDto getLotById(Long id) {
        return lotRepository.getLotById(id);
    }

    @Override
    public List<LotDto> getAllLots() {
        return lotRepository.getAllLots();
    }

    @Override
    public List<LotDto> getAllLotsByGroup(Long groupId) {
        return lotRepository.getAllLotsByGroup(groupId);
    }

    @Override
    public void updateLot(LotDto lotDto) {
        lotRepository.updateLot(lotDto);
    }

    @Override
    public void deleteLot(LotDto lotDto) {
        lotRepository.deleteLot(lotDto);
    }

    @Override
    public Long getLatestLotId() {
        return lotRepository.getLatestLotId();
    }

}
