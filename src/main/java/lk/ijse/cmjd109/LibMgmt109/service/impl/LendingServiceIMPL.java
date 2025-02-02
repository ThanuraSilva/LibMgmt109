package lk.ijse.cmjd109.LibMgmt109.service.impl;

import lk.ijse.cmjd109.LibMgmt109.dao.BookDao;
import lk.ijse.cmjd109.LibMgmt109.dao.LendingDao;
import lk.ijse.cmjd109.LibMgmt109.dao.MemberDao;
import lk.ijse.cmjd109.LibMgmt109.dto.LendingDTO;
import lk.ijse.cmjd109.LibMgmt109.entities.BookEntity;
import lk.ijse.cmjd109.LibMgmt109.entities.LendingEntity;
import lk.ijse.cmjd109.LibMgmt109.entities.MemberEntity;
import lk.ijse.cmjd109.LibMgmt109.exception.*;
import lk.ijse.cmjd109.LibMgmt109.service.LendingService;
import lk.ijse.cmjd109.LibMgmt109.util.LendingMapping;
import lk.ijse.cmjd109.LibMgmt109.util.UtilityData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class LendingServiceIMPL implements LendingService {
  //  private final LendingMapping lendingMapping;
    private final BookDao bookDao;
    private final MemberDao memberDao;
    private final LendingDao lendingDao;
    @Value("${perDayFine}")
    private Double perDayFine;


    @Override
    public void addLending(LendingDTO lendingDTO) {
        String book = lendingDTO.getBook();
        String member = lendingDTO.getMember();
        //Availability of the book
        var bookEntity = bookDao.findById(book).orElseThrow(() ->
                new BookNotFoundException("Book not found"));
        // Membership validation
        var memberEntity = memberDao.findById(member).orElseThrow(() ->
                new MemberNotFoundException("Member not found"));

        //chack the avilQty
        if(bookDao.avlQty(book) > 0){
            //Books are available
            lendingDTO.setLendingId(UtilityData.generateLendingId());
            lendingDTO.setIsActive(true);
            lendingDTO.setLendingDate(UtilityData.generateTodayDate());
            lendingDTO.setReturnDate(UtilityData.generateReturnDate());
            lendingDTO.setOverDue(0L);
            lendingDTO.setFineAmount(0.00);
            lendingDao.save(LendingMapping.toLendingEntity(lendingDTO,bookEntity,memberEntity));
            bookDao.deductBookQtyBasedOnLending(book);
        }else {
            throw new EnoughBooksNotFoundException("Not enough books to proceed");
        }

    }

    @Override
    public void handOverLending(String lendingID) {
        var foundLending =
                lendingDao.findById(lendingID).orElseThrow(() -> new LendingNotFoundException("Lending record not found"));
        if(!foundLending.getIsActive()){
            throw new LendingAlreadyHandoverException("Lending already handover");
        }

        var returnDate = foundLending.getReturnDate();
        var overdue = calcOverdue(returnDate); //overdue day count
        var fineAmount = calcFineAmount(overdue);
        foundLending.setIsActive(false);
        foundLending.setOverDue(overdue);
        foundLending.setFineAmount(fineAmount);
        bookDao.addBookAfterHandover(foundLending.getBook().getBookId());
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
    private Long calcOverdue(LocalDate returnDate) {
        var today = UtilityData.generateTodayDate();
        if(returnDate.isBefore(today)){
             return ChronoUnit.DAYS.between(returnDate,today);
        }
        return 0L;
    }
    private Double calcFineAmount(Long overdue) {
        return overdue * perDayFine;
    }
}
