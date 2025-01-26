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
      return null;
    }

    @Override
    public List<MemberDTO> getAllMembers() {

        return null;
    }
}
