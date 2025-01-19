package lk.ijse.cmjd109.LibMgmt109.service;

import lk.ijse.cmjd109.LibMgmt109.dto.LibStaffDTO;
import lk.ijse.cmjd109.LibMgmt109.dto.MemberDTO;

import java.util.List;

public interface StaffService {
    void saveStaffMember(LibStaffDTO staffMember);
    void updateStaffMember(String staffId,LibStaffDTO staffMember);
    void deleteStaffMember(String staffId);
    LibStaffDTO getSelectedStaffMember(String staffId);
    List<LibStaffDTO> getAllStaffMembers();
}
