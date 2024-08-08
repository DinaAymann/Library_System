package com.library.backend.controller;

import com.library.backend.dto.BorrowingRecordDto;
import com.library.backend.exception.NotFound;
import com.library.backend.service.BorrowingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class BorrowingController {

    private final BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @PostMapping("/borrow/{bookId}/patron/{patronId}") //should not unbook
    public ResponseEntity<BorrowingRecordDto> borrowBook(@PathVariable("bookId") Long bookId, @PathVariable("patronId") Long patronId) {
        try {
            BorrowingRecordDto borrowingRecord = borrowingService.borrowBook(bookId, patronId);
            return new ResponseEntity<>(borrowingRecord, HttpStatus.CREATED);
        } catch (NotFound e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/return/{bookId}/patron/{patronId}") // auto time
    public ResponseEntity<BorrowingRecordDto> returnBook(@PathVariable("bookId") Long bookId, @PathVariable("patronId") Long patronId) {
        try {
            BorrowingRecordDto borrowingRecord = borrowingService.returnBook(bookId, patronId);
            return new ResponseEntity<>(borrowingRecord, HttpStatus.OK);
        } catch (NotFound e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
