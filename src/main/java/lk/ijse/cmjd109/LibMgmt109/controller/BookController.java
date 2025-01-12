package lk.ijse.cmjd109.LibMgmt109.controller;

import lk.ijse.cmjd109.LibMgmt109.dto.BookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @GetMapping
    public String healthTest(){
        return "Book controller is running";
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addBook(@RequestBody BookDTO bookDTO){
        System.out.println(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable String bookId){
        System.out.println(bookId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PatchMapping
    public ResponseEntity<Void> updateBook(@RequestParam ("bookId") String id, @RequestBody BookDTO bookDTO){
        System.out.println(id);
        System.out.println(bookDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping(value = "{bookId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDTO> getSelectedBook(@PathVariable String bookId){
        System.out.println(bookId + " is selected");
        BookDTO book = new BookDTO();

        book.setBookId("B12345");
        book.setTitle("Effective Java");
        book.setPublisher("Addison-Wesley");
        book.setIsbn("978-0134685991");
        book.setAuthor("Joshua Bloch");
        book.setEdition("3rd");
        book.setPrice(45.99);
        book.setTotalQty(100);
        book.setAvilableQty(80);
        book.setAddedDate("2025-01-12");
        return ResponseEntity.ok(book);
    }
    @GetMapping(value = "getall",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        List<BookDTO> books = new ArrayList<>();

        books.add(new BookDTO("B12345", "Effective Java", "Addison-Wesley",
                "978-0134685991", "Joshua Bloch", "3rd", 45.99, 100, 80, "2025-01-12"));

        books.add(new BookDTO("B12346", "Clean Code", "Prentice Hall",
                "978-0132350884", "Robert C. Martin", "1st", 39.99, 120, 110, "2025-01-11"));

        books.add(new BookDTO("B12347", "Design Patterns", "Addison-Wesley",
                "978-0201633610", "Erich Gamma", "1st", 55.99, 200, 190, "2025-01-10"));

        books.add(new BookDTO("B12348", "Refactoring", "Addison-Wesley",
                "978-0134757599", "Martin Fowler", "2nd", 49.99, 150, 140, "2025-01-09"));

        books.add(new BookDTO("B12349", "The Pragmatic Programmer", "Addison-Wesley",
                "978-0201616224", "Andrew Hunt", "20th Anniversary Edition", 42.99, 90, 85, "2025-01-08"));

        return ResponseEntity.ok(books);
    }

}
