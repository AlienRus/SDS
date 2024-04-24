package backend.infrastructure.out.repository.db.supplySpecialistGroup;

import backend.application.dto.SupplySpecialistGroupDto;
import backend.infrastructure.out.repository.db.groupET.GroupEtMapper;
import backend.infrastructure.out.repository.db.supplySpecialist.SupplySpecialistMapper;

public class SupplySpecialistGroupMapper {

    public static SupplySpecialistGroupDto toDto(SupplySpecialistGroup supplySpecialistGroup) {
        return new SupplySpecialistGroupDto(
                supplySpecialistGroup.getId(),
                SupplySpecialistMapper.toDto(supplySpecialistGroup.getSupplySpecialist()),
                GroupEtMapper.toDto(supplySpecialistGroup.getGroup()));
    }

    public static SupplySpecialistGroup toEntity(SupplySpecialistGroupDto supplySpecialistGroupDto) {
        SupplySpecialistGroup supplySpecialistGroup = new SupplySpecialistGroup();
        supplySpecialistGroup.setId(supplySpecialistGroupDto.getId());
        supplySpecialistGroup
                .setSupplySpecialist(SupplySpecialistMapper.toEntity(supplySpecialistGroupDto.getSupplySpecialist()));
        supplySpecialistGroup.setGroup(GroupEtMapper.toEntity(supplySpecialistGroupDto.getGroup()));
        return supplySpecialistGroup;
    }
}
