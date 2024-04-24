package backend.infrastructure.out.repository.db.role;

import backend.application.dto.RoleDto;

public class RoleMapper {

    public static RoleDto toDto(Role role) {
        return new RoleDto(
                role.getId(),
                role.getRoleName());
    }

    public static Role toEntity(RoleDto roleDto) {
        Role role = new Role();
        role.setId(roleDto.getId());
        role.setRoleName(roleDto.getRoleName());
        return role;
    }
}
