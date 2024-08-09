package com.library.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.library.backend.dto.PatronDto;
import com.library.backend.entity.BorrowingRecord;
import com.library.backend.entity.Patron;
import com.library.backend.exception.CanNotCreate;
import com.library.backend.exception.NotFound;
import com.library.backend.mapper.PatronMapper;
import com.library.backend.repository.BorrowingRecordRepository;
import com.library.backend.repository.PatronRepository;

@Service
public class PatronServiceImpl implements PatronService {

    private PatronRepository patronRepository;
    private final BorrowingRecordRepository borrowingRecordRepository;

    @Autowired
    public PatronServiceImpl(PatronRepository patronRepository, BorrowingRecordRepository borrowingRecordRepository) {
        this.patronRepository = patronRepository;
        this.borrowingRecordRepository = borrowingRecordRepository;

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public PatronDto create(PatronDto patronDto) {
        try {
            Patron patron = PatronMapper.toEntity(patronDto);
            Patron savedPatron = patronRepository.save(patron);
            return PatronMapper.toDto(savedPatron);
        } catch (Exception e) {
            throw new CanNotCreate("The input patron is not acceptable ");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public PatronDto get(Long id) {
        Patron savedPatron = patronRepository.findById(id)
            .orElseThrow(() -> new NotFound("No such Patron exists: " + id));
        return PatronMapper.toDto(savedPatron);
    }

    @Transactional(readOnly = true)
    @Override
    public List<PatronDto> getAll() {
        List<Patron> patrons = patronRepository.findAll();
        return patrons.stream().map(PatronMapper::toDto).toList();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String delete(Long id) {
        try {
             Optional<BorrowingRecord> existingRecord = borrowingRecordRepository.findByPatronId(id);
            if (existingRecord.isPresent()) {
                borrowingRecordRepository.deleteByPatronId(id);
            }
            patronRepository.findById(id)
                .orElseThrow(() -> new NotFound("No such Patron exists: " + id));
            patronRepository.deleteById(id);
            return "Done";
        } catch (Exception e) {
            throw new NotFound("The patron could not be deleted");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public PatronDto update(Long id, PatronDto patronDto) {
        try {
            Patron foundPatron = patronRepository.findById(id)
                .orElseThrow(() -> new NotFound("No such Patron exists: " + id));
            
            if (patronDto.getName() != null) foundPatron.setName(patronDto.getName());
            if (patronDto.getPhone() != null) foundPatron.setPhone(patronDto.getPhone());
            if (patronDto.getEmail() != null) foundPatron.setEmail(patronDto.getEmail());
            
            foundPatron = patronRepository.save(foundPatron);
            return PatronMapper.toDto(foundPatron);
        } catch (NotFound e) {
            throw new NotFound("No such Patron exists: " + id);
        } catch (Exception e) {
            throw new CanNotCreate("The update can not be processed");
        }
    }
}
