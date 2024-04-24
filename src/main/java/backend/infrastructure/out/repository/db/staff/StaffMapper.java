package backend.infrastructure.out.repository.db.staff;

import backend.application.dto.StaffDto;
import backend.infrastructure.out.repository.db.role.RoleMapper;

public class StaffMapper {

    public static StaffDto toDto(Staff staff) {
        return new StaffDto(
                staff.getId(),
                staff.getEmail(),
                staff.getPassword(),
                RoleMapper.toDto(staff.getRole()));
    }

    public static Staff toEntity(StaffDto staffDto) {
        Staff staff = new Staff();
        staff.setId(staffDto.getId());
        staff.setEmail(staffDto.getEmail());
        staff.setPassword(staffDto.getPassword());
        staff.setRole(RoleMapper.toEntity(staffDto.getRole()));
        return staff;
    }
}
