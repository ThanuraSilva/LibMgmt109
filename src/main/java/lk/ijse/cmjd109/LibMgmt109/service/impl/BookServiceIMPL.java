package lk.ijse.cmjd109.LibMgmt109.service.impl;

import lk.ijse.cmjd109.LibMgmt109.dto.BookDTO;
import lk.ijse.cmjd109.LibMgmt109.service.BookService;

import java.util.List;

public class BookServiceIMPL implements BookService {
    @Override
    public void saveBook(BookDTO book) {

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
        return List.of();
    }
}
