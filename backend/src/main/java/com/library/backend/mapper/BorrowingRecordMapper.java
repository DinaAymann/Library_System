package com.library.backend.mapper;

import com.library.backend.dto.BorrowingRecordDto;
import com.library.backend.entity.Books;
import com.library.backend.entity.BorrowingRecord;
import com.library.backend.entity.Patron;

public class BorrowingRecordMapper {

    public static BorrowingRecordDto toDto(BorrowingRecord record) {
        return new BorrowingRecordDto(
            record.getId(),
            record.getBook().getId(),
            record.getPatron().getId(),
            record.getBorrowDate(),
            record.getReturnDate()
        );
    }

    public static BorrowingRecord fromDto(BorrowingRecordDto recordDto) {
        // Assuming Book and Patron entities can be fetched via their IDs
        Books book = new Books(); // Fetch Book entity by recordDto.getBookId() from the repository
        Patron patron = new Patron(); // Fetch Patron entity by recordDto.getPatronId() from the repository

        return new BorrowingRecord(
            recordDto.getId(),
            book,
            patron,
            recordDto.getBorrowDate(),
            recordDto.getReturnDate()
        );
    }
}
