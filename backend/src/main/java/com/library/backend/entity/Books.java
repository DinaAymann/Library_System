package com.library.backend.entity;

import java.time.Year;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "pub_year", nullable = false)
    private Year pubYear;

    @Column(name = "isbn", 
   // nullable = false,
     unique = true)
    private String ISBN;
    
 // No-args constructor
    public Books() {}

    // All-args constructor
    public Books(Long id, String title, String author, Year pubYear, String ISBN) {
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
