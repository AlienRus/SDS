package backend.application.implementation;

import backend.application.dto.StaffDto;
import backend.application.interfaces.in.IStaffService;
import backend.application.interfaces.out.repository.IStaffRepository;

import java.util.List;

public class StaffService implements IStaffService {

    private IStaffRepository staffRepository;

    @Override
    public void InjectStaffRepository(IStaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public void createStaff(StaffDto staffDto) {
        staffRepository.createStaff(staffDto);
    }

    @Override
    public StaffDto getStaffById(Long id) {
        return staffRepository.getStaffById(id);
    }

    @Override
    public StaffDto getStaffByEmail(String email) {
        return staffRepository.getStaffByEmail(email);
    }

    @Override
    public List<StaffDto> getAllStaff() {
        return staffRepository.getAllStaff();
    }

    @Override
    public void updateStaff(StaffDto staffDto) {
        staffRepository.updateStaff(staffDto);
    }

    @Override
    public void deleteStaff(StaffDto staffDto) {
        staffRepository.deleteStaff(staffDto);
    }
}
