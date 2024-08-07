package com.library.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.backend.entity.Books;

public interface booksRepo extends JpaRepository<Books, Long>{
	
	

}
