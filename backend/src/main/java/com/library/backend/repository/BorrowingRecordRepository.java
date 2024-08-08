package com.library.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.library.backend.entity.BorrowingRecord;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long> {
    Optional<BorrowingRecord> findByBookIdAndPatronIdAndReturnDateIsNull(Long bookId, Long patronId);
    List<BorrowingRecord> findByBookId(Long bookId);
    Optional<BorrowingRecord> findByBookIdAndReturnDateIsNull(Long bookId);

}
