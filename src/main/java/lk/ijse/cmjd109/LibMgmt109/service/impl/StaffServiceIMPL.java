package lk.ijse.cmjd109.LibMgmt109.service.impl;

import lk.ijse.cmjd109.LibMgmt109.dto.LibStaffDTO;
import lk.ijse.cmjd109.LibMgmt109.dto.Role;
import lk.ijse.cmjd109.LibMgmt109.service.StaffService;
import lk.ijse.cmjd109.LibMgmt109.util.UtilityData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StaffServiceIMPL implements StaffService {
    @Override
    public void saveStaffMember(LibStaffDTO staffMember) {
        staffMember.setStaffId(UtilityData.generateStaffId());
        System.out.println(staffMember);
    }

    @Override
    public void updateStaffMember(String staffId, LibStaffDTO staffMember) {

    }

    @Override
    public void deleteStaffMember(String staffId) {

    }

    @Override
    public LibStaffDTO getSelectedStaffMember(String staffId) {
       return null;
    }

    @Override
    public List<LibStaffDTO> getAllStaffMembers() {
        return null;
    }
}
