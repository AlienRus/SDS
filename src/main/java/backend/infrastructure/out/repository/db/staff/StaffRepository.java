package backend.infrastructure.out.repository.db.staff;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import backend.application.dto.StaffDto;
import backend.application.interfaces.out.repository.IStaffRepository;

@Stateless
public class StaffRepository implements IStaffRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createStaff(StaffDto staffDto) {
        Staff staff = StaffMapper.toEntity(staffDto);
        entityManager.persist(staff);
    }

    public StaffDto getStaffById(Long id) {
        Staff staff = entityManager.find(Staff.class, id);
        return StaffMapper.toDto(staff);
    }

    public StaffDto getStaffByEmail(String email) {
        Staff staff = entityManager.createQuery("SELECT s FROM Staff s WHERE s.email = :email", Staff.class)
                .setParameter("email", email)
                .getSingleResult();
        return StaffMapper.toDto(staff);
    }

    public List<StaffDto> getAllStaff() {
        List<Staff> staffList = entityManager.createQuery("SELECT s FROM Staff s", Staff.class).getResultList();
        return staffList.stream().map(StaffMapper::toDto).collect(Collectors.toList());
    }

    public void updateStaff(StaffDto staffDto) {
        Staff staff = StaffMapper.toEntity(staffDto);
        entityManager.merge(staff);
    }

    public void deleteStaff(StaffDto staffDto) {
        Staff staff = StaffMapper.toEntity(staffDto);
        entityManager.remove(entityManager.contains(staff) ? staff : entityManager.merge(staff));
    }

    @Override
    public StaffDto getStaffByEmailAndPassword(String email, String password) {
        List<Staff> staff = entityManager
                .createQuery("SELECT s FROM Staff s WHERE s.email=:email AND s.password=:password", Staff.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getResultList();

        if (staff.isEmpty()) {
            return null;
        }
        
        return StaffMapper.toDto(staff.get(0));
    }
}
