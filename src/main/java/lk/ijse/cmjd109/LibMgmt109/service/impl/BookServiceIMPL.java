package lk.ijse.cmjd109.LibMgmt109.service.impl;

import lk.ijse.cmjd109.LibMgmt109.dao.BookDao;
import lk.ijse.cmjd109.LibMgmt109.dto.BookDTO;
import lk.ijse.cmjd109.LibMgmt109.entities.BookEntity;
import lk.ijse.cmjd109.LibMgmt109.service.BookService;
import lk.ijse.cmjd109.LibMgmt109.util.EntityDTOConversion;
import lk.ijse.cmjd109.LibMgmt109.util.UtilityData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class BookServiceIMPL implements BookService {
    private final BookDao bookDao;
    private final EntityDTOConversion entityDTOConversion;
    @Override
    public void saveBook(BookDTO book) {
        book.setBookId(UtilityData.generateBookId());
        book.setLastUpdatedDate(UtilityData.generateTodayDate());
        book.setLastUpdatedTime(UtilityData.generateCreatedTime());
        BookEntity bookEntity = entityDTOConversion.toBookEntity(book);
        bookDao.save(bookEntity);
    }

    @Override
    public void updateBook(String bookId, BookDTO book) {

    }

    @Override
    public void deleteBook(String bookId) {

    }

    @Override
    public BookDTO getSelectedBook(String bookId) {
       return null;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return null;
    }
}
