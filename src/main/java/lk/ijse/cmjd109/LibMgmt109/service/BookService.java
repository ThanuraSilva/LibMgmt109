package lk.ijse.cmjd109.LibMgmt109.service;

import lk.ijse.cmjd109.LibMgmt109.dto.BookDTO;

import java.util.List;

public interface BookService {
    void saveBook(BookDTO book);
    void updateBook(String bookId, BookDTO book);
    void deleteBook(String bookId);
    BookDTO getSelectedBook(String bookId);
    List<BookDTO> getAllBooks();
}
