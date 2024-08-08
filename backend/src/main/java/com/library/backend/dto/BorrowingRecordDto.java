package com.library.backend.dto;


import java.time.LocalDate;

public class BorrowingRecordDto {

    private Long id;
    private Long bookId; // Foreign key to Book
    private Long patronId; // Foreign key to Patron
    private LocalDate borrowDate;
    private LocalDate returnDate;

    // No-args constructor
    public BorrowingRecordDto() {}

    // All-args constructor
    public BorrowingRecordDto(Long id, Long bookId, Long patronId, LocalDate borrowDate, LocalDate returnDate) {
        this.id = id;
        this.bookId = bookId;
        this.patronId = patronId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    // Getter and Setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getPatronId() {
        return patronId;
    }

    public void setPatronId(Long patronId) {
        this.patronId = patronId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
