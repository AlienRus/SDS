package backend.application.interfaces.out.repository;

import backend.application.dto.RoleDto;

import java.util.List;

public interface IRoleRepository {
    void createRole(RoleDto roleDto);

    RoleDto getRoleById(Long id);

    List<RoleDto> getAllRoles();

    void updateRole(RoleDto roleDto);

    void deleteRole(RoleDto roleDto);
}
