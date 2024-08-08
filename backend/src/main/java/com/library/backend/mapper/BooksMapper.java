package com.library.backend.mapper;

import java.util.stream.Collectors;

import com.library.backend.dto.booksDto;
import com.library.backend.entity.Books;

public class BooksMapper {

	public static booksDto maptodto (Books book) {
		return new booksDto(
				book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPubYear(),
                book.getISBN()	);
	} 
	public static Books maptodto (booksDto book) {
		return new Books(
				book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPubYear(),
                book.getISBN() );
	}	
}
