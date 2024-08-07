package com.library.backend.dto;

import java.time.Year;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//to tansfer data between client and server
//mapped to the entity
public class booksDto {

	    private Long id;
	    private String title;
	    private String author;
	    private Year pubYear;
	    private String ISBN;
	    
	 // No-args constructor
	    public booksDto() {}

	    // All-args constructor
	    public booksDto(Long id, String title, String author, Year pubYear, String ISBN) {
	        this.id = id;
	        this.title = title;
	        this.author = author;
	        this.pubYear = pubYear;
	        this.ISBN = ISBN;
	    }

	    // Getter and Setter methods
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getAuthor() {
	        return author;
	    }

	    public void setAuthor(String author) {
	        this.author = author;
	    }

	    public Year getPubYear() {
	        return pubYear;
	    }

	    public void setPubYear(Year pubYear) {
	        this.pubYear = pubYear;
	    }

	    public String getISBN() {
	        return ISBN;
	    }

	    public void setISBN(String ISBN) {
	        this.ISBN = ISBN;
	    }

}
