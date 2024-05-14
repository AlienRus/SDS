package backend.application.interfaces.in;

import backend.application.dto.RoleDto;
import backend.application.interfaces.out.repository.IRoleRepository;

import java.util.List;

public interface IRoleService {
    public void InjectRoleRepository(IRoleRepository roleRepository);

    void createRole(RoleDto roleDto);

    RoleDto getRoleById(Long id);

    List<RoleDto> getAllRoles();

    void updateRole(RoleDto roleDto);

    void deleteRole(RoleDto roleDto);
}
