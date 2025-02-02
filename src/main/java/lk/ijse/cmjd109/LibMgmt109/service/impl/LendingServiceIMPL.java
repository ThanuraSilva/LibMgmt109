package lk.ijse.cmjd109.LibMgmt109.service.impl;

import lk.ijse.cmjd109.LibMgmt109.dao.BookDao;
import lk.ijse.cmjd109.LibMgmt109.dao.MemberDao;
import lk.ijse.cmjd109.LibMgmt109.dto.LendingDTO;
import lk.ijse.cmjd109.LibMgmt109.exception.BookNotFoundException;
import lk.ijse.cmjd109.LibMgmt109.exception.MemberNotFoundException;
import lk.ijse.cmjd109.LibMgmt109.service.LendingService;
import lk.ijse.cmjd109.LibMgmt109.util.LendingMapping;
import lk.ijse.cmjd109.LibMgmt109.util.UtilityData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class LendingServiceIMPL implements LendingService {
    private final LendingMapping lendingMapping;
    private final BookDao bookDao;
    private final MemberDao memberDao;


    @Override
    public void addLending(LendingDTO lendingDTO) {

        String book = lendingDTO.getBook();
        String member = lendingDTO.getMember();
        //Availability of the book
        bookDao.findById(book).orElseThrow(()->
                new BookNotFoundException("Book not found"));
        // Membership validation
        memberDao.findById(member).orElseThrow(()->
                new MemberNotFoundException("Member not found"));

    }

    @Override
    public void handOverLending(String lendingID) {

    }

    @Override
    public void deleteLending(String lendingID) {

    }

    @Override
    public LendingDTO getSpecificLending(String lendingID) {
        return null;
    }

    @Override
    public List<LendingDTO> getAllLendings() {
        return List.of();
    }
}
