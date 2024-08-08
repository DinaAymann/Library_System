package com.library.backend.service;

import java.util.List;
import com.library.backend.entity.Books;
import com.library.backend.dto.booksDto;

public interface BooksService {
	 public booksDto create(booksDto bookDto) ;
	 public booksDto get(Long id) ;
	 public List<Books> getAll() ;



}
