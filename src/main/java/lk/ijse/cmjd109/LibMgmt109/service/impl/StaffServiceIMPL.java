package lk.ijse.cmjd109.LibMgmt109.service.impl;

import lk.ijse.cmjd109.LibMgmt109.dao.StaffDao;
import lk.ijse.cmjd109.LibMgmt109.dto.LibStaffDTO;
import lk.ijse.cmjd109.LibMgmt109.dto.Role;
import lk.ijse.cmjd109.LibMgmt109.exception.StaffMemberNotFoundException;
import lk.ijse.cmjd109.LibMgmt109.service.StaffService;
import lk.ijse.cmjd109.LibMgmt109.util.EntityDTOConversion;
import lk.ijse.cmjd109.LibMgmt109.util.UtilityData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class StaffServiceIMPL implements StaffService {
    private final StaffDao staffDao;
    private final EntityDTOConversion entityDTOConversion;
    @Override
    public void saveStaffMember(LibStaffDTO staffMember) {
        staffMember.setStaffId(UtilityData.generateStaffId());
        staffMember.setLastUpdated(UtilityData.generateTodayDate());
        staffDao.save(entityDTOConversion.toStaffEntity(staffMember));
    }

    @Override
    public void updateStaffMember(String staffId, LibStaffDTO staffMember) {
        var foundStaffMember = staffDao.findById(staffId);
        if(!foundStaffMember.isPresent()){
           throw new StaffMemberNotFoundException("Staff id "+staffId+" not found");
       }
        foundStaffMember.get().setFirstName(staffMember.getFirstName());
        foundStaffMember.get().setLastName(staffMember.getLastName());
        foundStaffMember.get().setEmail(staffMember.getEmail());
        foundStaffMember.get().setJoinDate(staffMember.getJoinDate());
        foundStaffMember.get().setLastUpdated(UtilityData.generateTodayDate());
        foundStaffMember.get().setRole(staffMember.getRole());
    }

    @Override
    public void deleteStaffMember(String staffId) {
        if(!staffDao.findById(staffId).isPresent()){
            throw new StaffMemberNotFoundException("Staff id "+staffId+" not found");
        }
        staffDao.deleteById(staffId);
    }

    @Override
    public LibStaffDTO getSelectedStaffMember(String staffId) {
        var foundStaffMember = staffDao.findById(staffId);
        if(!foundStaffMember.isPresent()){
            throw new StaffMemberNotFoundException("Staff id "+staffId+" not found");
        }
        return entityDTOConversion.toStaffDTO(staffDao.getReferenceById(staffId));
    }

    @Override
    public List<LibStaffDTO> getAllStaffMembers() {
       return entityDTOConversion.toStaffDTOList(staffDao.findAll());
    }
}
