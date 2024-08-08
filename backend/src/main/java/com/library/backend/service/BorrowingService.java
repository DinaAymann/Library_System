package com.library.backend.service;

import com.library.backend.dto.BorrowingRecordDto;
import com.library.backend.exception.NotFound;
import java.time.LocalDate;

public interface BorrowingService {
    BorrowingRecordDto borrowBook(Long bookId, Long patronId) throws NotFound;
    BorrowingRecordDto returnBook(Long bookId, Long patronId) throws NotFound;
}
