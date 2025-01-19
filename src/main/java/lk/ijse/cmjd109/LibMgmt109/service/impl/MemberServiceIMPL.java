package lk.ijse.cmjd109.LibMgmt109.service.impl;

import lk.ijse.cmjd109.LibMgmt109.dto.MemberDTO;
import lk.ijse.cmjd109.LibMgmt109.service.MemberService;
import lk.ijse.cmjd109.LibMgmt109.util.UtilityData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MemberServiceIMPL implements MemberService {
    @Override
    public void saveMember(MemberDTO member) {
        member.setMemberId(UtilityData.generateMemberId());
        System.out.println(member);
    }

    @Override
    public void updateMember(String memberId, MemberDTO member) {

    }

    @Override
    public void deleteMember(String memberId) {

    }

    @Override
    public MemberDTO getSelectedMember(String memberId) {
       return new MemberDTO("12345", "John Doe", "johndoe@example.com", "2023-01-01");
    }

    @Override
    public List<MemberDTO> getAllMembers() {
        List<MemberDTO> members = new ArrayList<>();
        members.add(new MemberDTO("12345", "John Doe", "johndoe@example.com", "2023-01-01"));
        members.add(new MemberDTO("12346", "Jane Smith", "janesmith@example.com", "2023-02-01"));
        members.add(new MemberDTO("12347", "Alice Johnson", "alicejohnson@example.com", "2023-03-01"));
        members.add(new MemberDTO("12348", "Bob Brown", "bobbrown@example.com", "2023-04-01"));
        members.add(new MemberDTO("12349", "Charlie Davis", "charliedavis@example.com", "2023-05-01"));
        return members;
    }
}
