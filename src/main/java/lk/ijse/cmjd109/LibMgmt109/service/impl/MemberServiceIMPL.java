package lk.ijse.cmjd109.LibMgmt109.service.impl;

import lk.ijse.cmjd109.LibMgmt109.dao.MemberDao;
import lk.ijse.cmjd109.LibMgmt109.dto.MemberDTO;
import lk.ijse.cmjd109.LibMgmt109.entities.BookEntity;
import lk.ijse.cmjd109.LibMgmt109.entities.MemberEntity;
import lk.ijse.cmjd109.LibMgmt109.exception.BookNotFoundException;
import lk.ijse.cmjd109.LibMgmt109.exception.MemberNotFoundException;
import lk.ijse.cmjd109.LibMgmt109.service.MemberService;
import lk.ijse.cmjd109.LibMgmt109.util.EntityDTOConversion;
import lk.ijse.cmjd109.LibMgmt109.util.UtilityData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceIMPL implements MemberService {

    private final MemberDao memberDao;
    private final EntityDTOConversion entityDTOConversion;

    @Override
    public void saveMember(MemberDTO member) {
        member.setMemberId(UtilityData.generateMemberId());
        member.setMemberShipDate(UtilityData.generateTodayDate());
        memberDao.save(entityDTOConversion.toMemberEntity(member));
    }

    @Override
    public void updateMember(String memberId, MemberDTO member) {
        Optional<MemberEntity> foundMember = memberDao.findById(memberId);
        if(!foundMember.isPresent()){
            throw new MemberNotFoundException("Member not found");
        }
        foundMember.get().setFName(member.getFName());
        foundMember.get().setLName(member.getLName());
        foundMember.get().setEmail(member.getEmail());
        foundMember.get().setMemberShipDate(member.getMemberShipDate() == null ? UtilityData.generateTodayDate() : member.getMemberShipDate());
    }

    @Override
    public void deleteMember(String memberId) {
        Optional<MemberEntity> foundMember = memberDao.findById(memberId);
        if(!foundMember.isPresent()){
            throw new MemberNotFoundException("Member not found");
        }
        memberDao.deleteById(memberId);
    }

    @Override
    public MemberDTO getSelectedMember(String memberId) {
        Optional<MemberEntity> foundMember = memberDao.findById(memberId);
        if(!foundMember.isPresent()){
            throw new MemberNotFoundException("Member not found");
        }
        return entityDTOConversion.toMemberDTO(memberDao.getReferenceById(memberId));
    }

    @Override
    public List<MemberDTO> getAllMembers() {
       return entityDTOConversion.toMemberDTOList(memberDao.findAll());
    }
}
