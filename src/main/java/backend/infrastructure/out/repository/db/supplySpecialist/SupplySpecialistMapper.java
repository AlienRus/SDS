package backend.infrastructure.out.repository.db.supplySpecialist;

import backend.application.dto.SupplySpecialistDto;
import backend.infrastructure.out.repository.db.role.RoleMapper;

public class SupplySpecialistMapper {

    public static SupplySpecialistDto toDto(SupplySpecialist supplySpecialist) {
        return new SupplySpecialistDto(
                supplySpecialist.getId(),
                RoleMapper.toDto(supplySpecialist.getRole()),
                supplySpecialist.getEmail(),
                supplySpecialist.getPassword(),
                supplySpecialist.getCompany(),
                supplySpecialist.getIsApproved());
    }

    public static SupplySpecialist toEntity(SupplySpecialistDto supplySpecialistDto) {
        SupplySpecialist supplySpecialist = new SupplySpecialist();
        supplySpecialist.setId(supplySpecialistDto.getId());
        supplySpecialist.setRole(RoleMapper.toEntity(supplySpecialistDto.getRole()));
        supplySpecialist.setEmail(supplySpecialistDto.getEmail());
        supplySpecialist.setPassword(supplySpecialistDto.getPassword());
        supplySpecialist.setCompany(supplySpecialistDto.getCompany());
        supplySpecialist.setIsApproved(supplySpecialistDto.getIsApproved());
        return supplySpecialist;
    }
}
