package com.library.backend.service;

import com.library.backend.dto.BorrowingRecordDto;
import com.library.backend.entity.BorrowingRecord;
import com.library.backend.entity.Books;
import com.library.backend.entity.Patron;
import com.library.backend.exception.CanNotCreate;
import com.library.backend.exception.NotFound;
import com.library.backend.mapper.BorrowingRecordMapper;
import com.library.backend.repository.booksRepo;
import com.library.backend.repository.PatronRepository;
import com.library.backend.repository.BorrowingRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BorrowingServiceImpl implements BorrowingService {

    private final booksRepo booksRepo;
    private final PatronRepository patronRepository;
    private final BorrowingRecordRepository borrowingRecordRepository;

    @Autowired
    public BorrowingServiceImpl(booksRepo booksRepo, PatronRepository patronRepository, BorrowingRecordRepository borrowingRecordRepository) {
        this.booksRepo = booksRepo;
        this.patronRepository = patronRepository;
        this.borrowingRecordRepository = borrowingRecordRepository;
    }

    @Transactional
    @Override
    public BorrowingRecordDto borrowBook(Long bookId, Long patronId) throws NotFound {
        try{
            Optional<BorrowingRecord> existingRecord = borrowingRecordRepository.findByBookIdAndReturnDateIsNull(bookId);
            if (existingRecord.isPresent()) {
                throw new CanNotCreate("This book is already borrowed and not yet returned.");
            }

        Books book = booksRepo.findById(bookId).orElseThrow(() -> new NotFound("No such book exists: " + bookId));
        Patron patron = patronRepository.findById(patronId).orElseThrow(() -> new NotFound("No such patron exists: " + patronId));

        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setBook(book);
        borrowingRecord.setPatron(patron);
        borrowingRecord.setBorrowDate(LocalDate.now());

        BorrowingRecord savedRecord = borrowingRecordRepository.save(borrowingRecord);
        return BorrowingRecordMapper.toDto(savedRecord);
        }
        catch (NotFound e) {
			throw e ;}
			catch (Exception z){
				throw new CanNotCreate("The borrowing process can not be done");
			}
    }

    @Transactional
    @Override
    public BorrowingRecordDto returnBook(Long bookId, Long patronId) throws NotFound {


        BorrowingRecord borrowingRecord = borrowingRecordRepository.findByBookIdAndPatronIdAndReturnDateIsNull(bookId, patronId)
                .orElseThrow(() -> new NotFound("No active borrowing record found for book " + bookId + " and patron " + patronId));

        borrowingRecord.setReturnDate(LocalDate.now());
        BorrowingRecord updatedRecord = borrowingRecordRepository.save(borrowingRecord);

        return BorrowingRecordMapper.toDto(updatedRecord);
    }
}
