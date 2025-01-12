package lk.ijse.cmjd109.LibMgmt109.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @GetMapping
    public String healthTest(){
        return "Book controller is running";
    }
}
