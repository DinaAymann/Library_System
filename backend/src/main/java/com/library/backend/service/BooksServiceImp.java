package com.library.backend.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.backend.dto.booksDto;
import com.library.backend.entity.Books;
import com.library.backend.exception.*;
import com.library.backend.mapper.BooksMapper;
import com.library.backend.repository.booksRepo;
@Service
public class BooksServiceImp implements BooksService{

	private booksRepo booksRepo;
	@Override
	public booksDto create(booksDto bookDto) {
        try{
		Books book = BooksMapper.maptodto(bookDto);
		Books savedBook = booksRepo.save(book);
		return BooksMapper.maptodto(savedBook);
		}
		catch (Exception e){
			throw new CanNotCreate("The input book is not acceptable: "+e.getMessage());

		}
	}

	@Override
	public booksDto get(Long id){

		Books savedBook = booksRepo.findById(id).orElseThrow(() -> new NotFound("No such Book exists  : " + id));

		return BooksMapper.maptodto(savedBook);

	}

	@Override
	public List<Books> getAll(){

		List<Books> savedBooks = booksRepo.findAll();

		return savedBooks;

	}


	 @Autowired
	    public BooksServiceImp(booksRepo booksRepo) {
	        this.booksRepo = booksRepo;
	    }
	
}
