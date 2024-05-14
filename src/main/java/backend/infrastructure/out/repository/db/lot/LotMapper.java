package backend.infrastructure.out.repository.db.lot;

import backend.application.dto.LotDto;
import backend.infrastructure.out.repository.db.groupET.GroupEtMapper;
import backend.infrastructure.out.repository.db.lotRule.LotRuleMapper;
import backend.infrastructure.out.repository.db.status.StatusMapper;
import backend.infrastructure.out.repository.db.supplySpecialist.SupplySpecialistMapper;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LotMapper {

    public static LotDto toDto(Lot lot) {
        return new LotDto(
                lot.getId(),
                lot.getName(),
                lot.getOpenDate(),
                lot.getCloseDate(),
                StatusMapper.toDto(lot.getStatus()),
                lot.getCanOwnWay(),
                SupplySpecialistMapper.toDto(lot.getLotCreator()),
                LotRuleMapper.toDto(lot.getRules()),
                GroupEtMapper.toDto(lot.getGroupEts()));
    }

    public static Lot toEntity(LotDto lotDto) {
        Logger.getLogger(LotMapper.class.getName()).log(Level.WARNING, lotDto.toString());
        Lot lot = new Lot();
        lot.setId(lotDto.getId());
        lot.setName(lotDto.getName());
        lot.setOpenDate(lotDto.getOpenDate());
        lot.setCloseDate(lotDto.getCloseDate());
        lot.setStatus(StatusMapper.toEntity(lotDto.getStatus()));
        lot.setCanOwnWay(lotDto.getCanOwnWay());
        lot.setLotCreator(SupplySpecialistMapper.toEntity(lotDto.getLotCreator()));
        lot.setRules(LotRuleMapper.toEntity(lotDto.getRules()));
        lot.setGroupEts(GroupEtMapper.toEntity(lotDto.getGroupEts()));
        return lot;
    }
}
