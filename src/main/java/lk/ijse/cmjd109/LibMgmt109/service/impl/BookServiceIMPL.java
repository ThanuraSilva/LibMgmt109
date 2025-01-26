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
import java.util.Optional;

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
//        BookEntity bookEntity = entityDTOConversion.toBookEntity(book);
        bookDao.save(entityDTOConversion.toBookEntity(book));
    }

    @Override
    public void updateBook(String bookId, BookDTO book) {

    }

    @Override
    public void deleteBook(String bookId) {
        Optional<BookEntity> foundBook = bookDao.findById(bookId);
        if(!foundBook.isPresent()){
            throw  new RuntimeException("Book not found");
        }
        bookDao.deleteById(bookId);
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
