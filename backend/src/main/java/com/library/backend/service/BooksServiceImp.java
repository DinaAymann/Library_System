package com.library.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.backend.dto.booksDto;
import com.library.backend.entity.Books;
import com.library.backend.mapper.BooksMapper;
import com.library.backend.repository.booksRepo;
@Service
public class BooksServiceImp implements BooksService{

	private booksRepo booksRepo;
	@Override
	public booksDto create(booksDto bookDto) {
		
		Books book = BooksMapper.maptodto(bookDto);
		Books savedBook = booksRepo.save(book);
		return BooksMapper.maptodto(savedBook);
	}

	 @Autowired
	    public BooksServiceImp(booksRepo booksRepo) {
	        this.booksRepo = booksRepo;
	    }
	
}
