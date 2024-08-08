package com.library.backend.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.backend.dto.booksDto;
import com.library.backend.entity.Books;
import com.library.backend.exception.*;
import com.library.backend.mapper.BooksMapper;
import com.library.backend.repository.booksRepo;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BooksServiceImp implements BooksService{

	private booksRepo booksRepo;
    @Transactional(rollbackFor = Exception.class)
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

	@Transactional(readOnly = true)
	@Override
	public booksDto get(Long id){

		Books savedBook = booksRepo.findById(id).orElseThrow(() -> new NotFound("No such Book exists  : " + id));

		return BooksMapper.maptodto(savedBook);

	}


    @Transactional(readOnly = true)
	@Override
	public List<Books> getAll(){

		List<Books> savedBooks = booksRepo.findAll();

		return savedBooks;

	}

	@Transactional(rollbackFor = Exception.class)
	public String delete(Long id){//input validation for empty
		try{

			booksRepo.findById(id).orElseThrow(() -> new NotFound("No such Book exists  : " + id));
			booksRepo.deleteById(id);
			return "Done";
			}
			catch (Exception e){
				throw e;
	
			}
	}


	@Transactional(rollbackFor = Exception.class)
	public booksDto update(Long id, booksDto bookDto){//input validation for empty
		try{

			Books foundbook= booksRepo.findById(id).orElseThrow(() -> new NotFound("No such Book exists  : " + id));
			if (bookDto.getTitle() != null) 
			foundbook.setTitle(bookDto.getTitle());
			if (bookDto.getAuthor() != null) 
			foundbook.setAuthor(bookDto.getAuthor());
			if (bookDto.getISBN() != null) 
			foundbook.setISBN(bookDto.getISBN());
			if (bookDto.getPubYear() != null) 
			foundbook.setPubYear(bookDto.getPubYear());
            foundbook= booksRepo.save(foundbook);
			return BooksMapper.maptodto(foundbook);
			}
		 catch (NotFound e) {
			throw new NotFound("No such Book exists: " + id);}
			catch (Exception z){
				throw new CanNotCreate("error: "+z.getMessage());
			}
	}


	 @Autowired
	    public BooksServiceImp(booksRepo booksRepo) {
	        this.booksRepo = booksRepo;
	    }
	
}
