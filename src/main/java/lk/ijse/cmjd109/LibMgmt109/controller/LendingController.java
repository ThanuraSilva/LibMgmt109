package lk.ijse.cmjd109.LibMgmt109.controller;

import lk.ijse.cmjd109.LibMgmt109.dto.LendingDTO;
import lk.ijse.cmjd109.LibMgmt109.exception.BookNotFoundException;
import lk.ijse.cmjd109.LibMgmt109.exception.EnoughBooksNotFoundException;
import lk.ijse.cmjd109.LibMgmt109.exception.MemberNotFoundException;
import lk.ijse.cmjd109.LibMgmt109.service.LendingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/lending")
@RequiredArgsConstructor
public class LendingController {
 private final LendingService lendingService;
 @PostMapping
 public ResponseEntity<Void> addLending(@RequestBody LendingDTO lendingDTO){
     if(lendingDTO == null){
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
     }
     try {
         lendingService.addLending(lendingDTO);
         return ResponseEntity.ok().build();
     }catch (BookNotFoundException | MemberNotFoundException e){
         e.printStackTrace();
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
     }catch (EnoughBooksNotFoundException e){
         e.printStackTrace();
         return new ResponseEntity<>(HttpStatus.CONFLICT);
     }catch (Exception e){
         e.printStackTrace();
         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
     }

 }
 @PatchMapping("/{lendingId}")
 public ResponseEntity<Void> handoverBook(@PathVariable String lendingId){
     lendingService.handOverLending(lendingId);
     return ResponseEntity.noContent().build();
 }
 @DeleteMapping("/{lendingId}")
 public ResponseEntity<Void> deleteLending(@PathVariable String lendingId){
     return ResponseEntity.noContent().build();
 }
 @GetMapping ("/{lendingId}")
 public ResponseEntity<LendingDTO> getSpecificLending(@PathVariable String lendingId){
     lendingService.getSpecificLending(lendingId);
     return ResponseEntity.ok().body(lendingService.getSpecificLending(lendingId));
 }
 @GetMapping
 public ResponseEntity<List<LendingDTO>> getAllLending(){
     lendingService.getAllLendings();
     return ResponseEntity.ok().body(lendingService.getAllLendings());
 }

}
