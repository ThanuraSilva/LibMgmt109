package lk.ijse.cmjd109.LibMgmt109.util;

import lk.ijse.cmjd109.LibMgmt109.dto.LendingDTO;
import lk.ijse.cmjd109.LibMgmt109.entities.BookEntity;
import lk.ijse.cmjd109.LibMgmt109.entities.LendingEntity;
import lk.ijse.cmjd109.LibMgmt109.entities.MemberEntity;
import org.springframework.stereotype.Component;


public class LendingMapping {
    public static LendingDTO toLendingDTO(LendingEntity lendingEntity) {
        var lendingDTO = new LendingDTO();
        lendingDTO.setLendingId(lendingEntity.getLendingId());
        lendingDTO.setBook(lendingEntity.getBook().getBookId());
        lendingDTO.setMember(lendingEntity.getMember().getMemberId());
        lendingDTO.setReturnDate(lendingEntity.getReturnDate());
        lendingDTO.setLendingDate(lendingEntity.getLendingDate());
        lendingDTO.setFineAmount(lendingEntity.getFineAmount());
        lendingDTO.setOverDue(lendingEntity.getOverDue());
        lendingDTO.setIsActive(lendingEntity.getIsActive());
        return lendingDTO;
    }
    public static LendingEntity toLendingEntity(LendingDTO lendingDTO, BookEntity bookEntity, MemberEntity memberEntity) {
        var lendingEntity = new LendingEntity();
        lendingEntity.setLendingId(lendingDTO.getLendingId());
        lendingEntity.setBook(bookEntity);
        lendingEntity.setMember(memberEntity);
        lendingEntity.setReturnDate(lendingDTO.getReturnDate());
        lendingEntity.setLendingDate(lendingDTO.getLendingDate());
        lendingEntity.setFineAmount(lendingDTO.getFineAmount());
        lendingEntity.setOverDue(lendingDTO.getOverDue());
        lendingEntity.setIsActive(lendingDTO.getIsActive());
        return lendingEntity;
    }

}
