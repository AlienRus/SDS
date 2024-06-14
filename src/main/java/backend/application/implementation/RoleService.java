package backend.application.implementation;

import backend.application.dto.RoleDto;
import backend.application.interfaces.in.IRoleService;
import backend.application.interfaces.out.repository.IRoleRepository;

import java.util.List;

public class RoleService implements IRoleService {

    private IRoleRepository roleRepository;

    @Override
    public void InjectRoleRepository(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void createRole(RoleDto roleDto) {
        roleRepository.createRole(roleDto);
    }

    @Override
    public RoleDto getRoleById(Long id) {
        return roleRepository.getRoleById(id);
    }

    @Override
    public List<RoleDto> getAllRoles() {
        return roleRepository.getAllRoles();
    }

    @Override
    public void updateRole(RoleDto roleDto) {
        roleRepository.updateRole(roleDto);
    }

    @Override
    public void deleteRole(RoleDto roleDto) {
        roleRepository.deleteRole(roleDto);
    }

    @Override
    public RoleDto getRoleByName(String name) {
        return roleRepository.getRoleByName(name);
    }
}
