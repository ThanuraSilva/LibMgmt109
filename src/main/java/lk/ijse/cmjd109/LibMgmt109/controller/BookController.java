package lk.ijse.cmjd109.LibMgmt109.controller;

import lk.ijse.cmjd109.LibMgmt109.dto.BookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public BookDTO getSelectedBook(@PathVariable String bookId){
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
        return book;
    }

}
