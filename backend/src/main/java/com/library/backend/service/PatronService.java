package com.library.backend.service;

import java.util.List;
import com.library.backend.dto.PatronDto;

public interface PatronService {
    PatronDto create(PatronDto patronDto);
    PatronDto get(Long id);
    List<PatronDto> getAll();
    String delete(Long id);
    PatronDto update(Long id, PatronDto patronDto);
}
