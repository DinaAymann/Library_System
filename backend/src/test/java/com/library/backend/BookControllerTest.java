package com.library.backend;

import com.library.backend.dto.booksDto;
import com.library.backend.entity.Books;
import com.library.backend.service.BooksService;
import com.library.backend.controller.BooksController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.Year;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@WebMvcTest(BooksController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BooksService booksService;

    @Test
    public void testCreateBook() throws Exception {
        Year pubYear = Year.of(2020);
        booksDto bookDto = new booksDto(1L, "Book Title", "Author Name", pubYear, "0000-0000-0000-0000");
        when(booksService.create(any(booksDto.class))).thenReturn(bookDto);

        String bookJson = "{\"title\":\"Book Title\",\"author\":\"Author Name\",\"pubYear\":\"2020\",\"ISBN\":\"0000-0000-0000-0000\"}";

        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Book Title"));
    }

    @Test
    public void testGetBook() throws Exception {
        Year pubYear = Year.of(2020);
        booksDto bookDto = new booksDto(1L, "Book Title", "Author Name", pubYear, "0000-0000-0000-0000");
        when(booksService.get(anyLong())).thenReturn(bookDto);

        mockMvc.perform(get("/api/books/{id}", 1L))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Book Title"));
    }

    @Test
    public void testUpdateBook() throws Exception {
        Year pubYear = Year.of(2020);
        booksDto updatedBookDto = new booksDto(1L, "Updated Title", "Updated Author", pubYear, "0000-0000-0000-0000");
        when(booksService.update(anyLong(), any(booksDto.class))).thenReturn(updatedBookDto);

        String updatedBookJson = "{\"title\":\"Updated Title\",\"author\":\"Updated Author\",\"pubYear\":\"2020\",\"ISBN\":\"0000-0000-0000-0000\"}";

        mockMvc.perform(put("/api/books/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedBookJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Updated Title"));
    }

    @Test
    public void testDeleteBook() throws Exception {
        mockMvc.perform(delete("/api/books/{id}", 1L))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
