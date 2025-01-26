package lk.ijse.cmjd109.LibMgmt109.controller;

import lk.ijse.cmjd109.LibMgmt109.dto.LibStaffDTO;
import lk.ijse.cmjd109.LibMgmt109.dto.MemberDTO;
import lk.ijse.cmjd109.LibMgmt109.exception.StaffMemberNotFoundException;
import lk.ijse.cmjd109.LibMgmt109.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/staff")
@RequiredArgsConstructor
public class LibStaffController {
    private final StaffService staffService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addStaffMember(@RequestBody LibStaffDTO staffDTO){
        staffService.saveStaffMember(staffDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PatchMapping("/{staffId}")
    public ResponseEntity<Void> updateStaffMember(@PathVariable String staffId, @RequestBody LibStaffDTO staffDTO){
        try {
            staffService.updateStaffMember(staffId, staffDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (StaffMemberNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/{staffId}")
    public ResponseEntity<Void> deleteMember(@PathVariable String staffId){
        try {
            staffService.deleteStaffMember(staffId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (StaffMemberNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{staffId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LibStaffDTO> getSelectedStaffMember(@PathVariable String staffId){
        try {
            return new ResponseEntity<>(staffService.getSelectedStaffMember(staffId), HttpStatus.OK);
        }catch (StaffMemberNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LibStaffDTO>> getAllStaffMembers(){
        return new ResponseEntity<>(staffService.getAllStaffMembers(), HttpStatus.OK);
    }
}
