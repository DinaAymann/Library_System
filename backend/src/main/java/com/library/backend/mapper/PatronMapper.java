package com.library.backend.mapper;

import java.util.stream.Collectors;

import com.library.backend.dto.PatronDto;
import com.library.backend.entity.Patron;

public class PatronMapper {

    public static PatronDto toDto(Patron patron) {
        return new PatronDto(
            patron.getId(),
            patron.getName(),
            patron.getPhone(),
            patron.getEmail()
            
        );
    }

    public static Patron toEntity(PatronDto patronDto) {
        return new Patron(
            patronDto.getId(),
            patronDto.getName(),
            patronDto.getPhone(),
            patronDto.getEmail()
           
        );
    }
}
