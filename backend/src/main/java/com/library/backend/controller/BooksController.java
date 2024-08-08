package com.library.backend.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//handle http 

import com.library.backend.dto.booksDto;
import com.library.backend.entity.Books;
import com.library.backend.service.*;

@RestController
@RequestMapping("/api/books")
public class BooksController {

	private BooksService booksService;
	
	  public BooksController(BooksService booksService) {
	        this.booksService = booksService;
	    }
	  
	  //add Book REST API
	  @PostMapping
	  public ResponseEntity<booksDto> createBook(@RequestBody booksDto bookDto){ 
		  booksDto savedbook = booksService.create(bookDto);
		  return new ResponseEntity<>(savedbook,HttpStatus.CREATED);
	  }

	  //get a book API
	  @GetMapping("{id}")
	  public ResponseEntity<booksDto> getBookById(@PathVariable("id") Long bookId){
		booksDto foundBook = booksService.get(bookId);
		return ResponseEntity.ok(foundBook);

	  }

	  @GetMapping
	  public ResponseEntity<List<Books>> getAllBooks(){
		List<Books> foundBook = booksService.getAll();
		return ResponseEntity.ok(foundBook);

	  }

	  @DeleteMapping("{id}")
	  public ResponseEntity<Void> deleteBook(@PathVariable("id") Long bookId){
		booksService.delete(bookId);
		return ResponseEntity.noContent().build();

	  }

	  @PutMapping("{id}")
	  public ResponseEntity<booksDto> updatebook(@PathVariable("id") Long bookId, @RequestBody booksDto bookDto){ //make sure isbn is unique
		  booksDto savedbook = booksService.update(bookId, bookDto);
		  return new ResponseEntity<>(savedbook,HttpStatus.OK);
	  }

}
