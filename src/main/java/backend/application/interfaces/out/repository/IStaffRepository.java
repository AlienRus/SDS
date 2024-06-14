package backend.application.interfaces.out.repository;

import backend.application.dto.StaffDto;

import java.util.List;

public interface IStaffRepository {

    void createStaff(StaffDto staffDto);

    StaffDto getStaffById(Long id);

    StaffDto getStaffByEmail(String email);

    StaffDto getStaffByEmailAndPassword(String email, String password);

    List<StaffDto> getAllStaff();

    void updateStaff(StaffDto staffDto);

    void deleteStaff(StaffDto staffDto);
}
