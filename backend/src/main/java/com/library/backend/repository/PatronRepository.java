package com.library.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.library.backend.entity.Patron;

public interface PatronRepository extends JpaRepository<Patron, Long> {
}
