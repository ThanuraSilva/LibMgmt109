package lk.ijse.cmjd109.LibMgmt109.controller;

import lk.ijse.cmjd109.LibMgmt109.dto.MemberDTO;
import lk.ijse.cmjd109.LibMgmt109.exception.MemberNotFoundException;
import lk.ijse.cmjd109.LibMgmt109.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MembersController {

    private final MemberService memberService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addMember(@RequestBody MemberDTO memberDTO){
       memberService.saveMember(memberDTO);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PatchMapping("/{memberId}")
    public ResponseEntity<Void> updateMember(@PathVariable String memberId, @RequestBody MemberDTO memberDTO){
        try {
            memberService.updateMember(memberId, memberDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (MemberNotFoundException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable String memberId){
        try {
            memberService.deleteMember(memberId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (MemberNotFoundException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    @GetMapping(value = "/{memberId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemberDTO> getSelectedMember(@PathVariable String memberId){
        try {
            return new ResponseEntity<>(memberService.getSelectedMember(memberId), HttpStatus.OK);
        }catch (MemberNotFoundException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MemberDTO>> getAllMembers(){
        return new ResponseEntity<>(memberService.getAllMembers(), HttpStatus.OK);
    }
}

