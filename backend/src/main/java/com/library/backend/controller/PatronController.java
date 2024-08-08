package com.library.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.library.backend.dto.PatronDto;
import com.library.backend.service.PatronService;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {

    private final PatronService patronService;

    public PatronController(PatronService patronService) {
        this.patronService = patronService;
    }

    // Add Patron REST API
    @PostMapping
    public ResponseEntity<PatronDto> createPatron(@RequestBody PatronDto patronDto) { //missing attributes should be bad request
        PatronDto savedPatron = patronService.create(patronDto);
        return new ResponseEntity<>(savedPatron, HttpStatus.CREATED);
    }

    // Get a Patron by ID API
    @GetMapping("/{id}")
    public ResponseEntity<PatronDto> getPatronById(@PathVariable("id") Long patronId) {
        PatronDto foundPatron = patronService.get(patronId);
        return ResponseEntity.ok(foundPatron);
    }

    // Get all Patrons API
    @GetMapping
    public ResponseEntity<List<PatronDto>> getAllPatrons() {
        List<PatronDto> foundPatrons = patronService.getAll();
        return ResponseEntity.ok(foundPatrons);
    }

    // Delete a Patron API
    @DeleteMapping("/{id}") //delete borrow
    public ResponseEntity<Void> deletePatron(@PathVariable("id") Long patronId) {
        patronService.delete(patronId);
        return ResponseEntity.noContent().build();
    }

    // Update a Patron API
    @PutMapping("/{id}")
    public ResponseEntity<PatronDto> updatePatron(@PathVariable("id") Long patronId, @RequestBody PatronDto patronDto) {
        PatronDto updatedPatron = patronService.update(patronId, patronDto);
        return new ResponseEntity<>(updatedPatron, HttpStatus.OK);
    }
}
