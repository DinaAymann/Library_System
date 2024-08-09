package com.library.backend;

//import Book;
//import BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@WebMvcTest
public class BookControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void testCreateBook() throws Exception {
        when(bookService.saveBook(any(Book.class))).thenReturn(new Book(1L, "Book Title", "Author Name"));

        String bookJson = "{\"title\":\"Book Title\",\"author\":\"Author Name\"}";

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bookJson))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));
    }

    @Test
    public void testGetBook() throws Exception {
        when(bookService.getBookById(1L)).thenReturn(new Book(1L, "Book Title", "Author Name"));

        mockMvc.perform(get("/books/{id}", 1L))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));
    }

    @Test
    public void testUpdateBook() throws Exception {
        when(bookService.updateBook(any(Long.class), any(Book.class))).thenReturn(new Book(1L, "Updated Title", "Updated Author"));

        String updatedBookJson = "{\"title\":\"Updated Title\",\"author\":\"Updated Author\"}";

        mockMvc.perform(put("/books/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedBookJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Updated Title"));
    }

    @Test
    public void testDeleteBook() throws Exception {
        mockMvc.perform(delete("/books/{id}", 1L))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
