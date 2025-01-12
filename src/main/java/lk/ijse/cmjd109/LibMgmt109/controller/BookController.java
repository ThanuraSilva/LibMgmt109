package lk.ijse.cmjd109.LibMgmt109.controller;

import lk.ijse.cmjd109.LibMgmt109.dto.BookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;

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

}
