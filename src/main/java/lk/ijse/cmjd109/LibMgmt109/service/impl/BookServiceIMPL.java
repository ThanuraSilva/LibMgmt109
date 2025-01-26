package lk.ijse.cmjd109.LibMgmt109.service.impl;

import lk.ijse.cmjd109.LibMgmt109.dto.BookDTO;
import lk.ijse.cmjd109.LibMgmt109.service.BookService;
import lk.ijse.cmjd109.LibMgmt109.util.UtilityData;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookServiceIMPL implements BookService {
    @Override
    public void saveBook(BookDTO book) {
        book.setBookId(UtilityData.generateBookId());
        System.out.println("From service layer"+book);
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
