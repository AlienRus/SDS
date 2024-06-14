package backend.infrastructure.out.repository.db.role;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.RoleDto;
import backend.application.interfaces.out.repository.IRoleRepository;

@Stateless
public class RoleRepository implements IRoleRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createRole(RoleDto roleDto) {
        Role role = RoleMapper.toEntity(roleDto);
        entityManager.persist(role);
    }

    public RoleDto getRoleById(Long id) {
        Role role = entityManager.find(Role.class, id);
        return RoleMapper.toDto(role);
    }

    public List<RoleDto> getAllRoles() {
        List<Role> roles = entityManager.createQuery("SELECT role FROM Role role", Role.class).getResultList();
        return roles.stream().map(RoleMapper::toDto).collect(Collectors.toList());
    }

    public void updateRole(RoleDto roleDto) {
        Role role = RoleMapper.toEntity(roleDto);
        entityManager.merge(role);
    }

    public void deleteRole(RoleDto roleDto) {
        Role role = RoleMapper.toEntity(roleDto);
        entityManager.remove(entityManager.contains(role) ? role : entityManager.merge(role));
    }

    @Override
    public RoleDto getRoleByName(String name) {
        Role role = entityManager.createQuery("SELECT role FROM Role role WHERE role.roleName=:name", Role.class)
                .setParameter("name", name)
                .getSingleResult();

        return RoleMapper.toDto(role);
    }
}
