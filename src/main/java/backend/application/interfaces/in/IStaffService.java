package backend.application.interfaces.in;

import backend.application.dto.StaffDto;
import backend.application.interfaces.out.repository.IStaffRepository;

import java.util.List;

public interface IStaffService {
    public void InjectStaffRepository(IStaffRepository staffRepository);

    void createStaff(StaffDto staffDto);

    StaffDto getStaffById(Long id);

    StaffDto getStaffByEmail(String email);

    StaffDto getStaffByEmailAndPassword(String email, String password);

    List<StaffDto> getAllStaff();

    void updateStaff(StaffDto staffDto);

    void deleteStaff(StaffDto staffDto);
}
