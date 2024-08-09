package com.library.backend;

import com.library.backend.dto.BorrowingRecordDto;
import com.library.backend.controller.BorrowingController;
import com.library.backend.service.BorrowingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

import java.time.LocalDate;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@WebMvcTest(BorrowingController.class)
public class BorrowRecordControllerTest {

 @Autowired
 private MockMvc mockMvc;

 @MockBean
 private BorrowingService borrowingService;

 @BeforeEach
 public void setup() {
  MockitoAnnotations.openMocks(this);
 }

 @Test
 public void testBorrowBook() throws Exception {
  BorrowingRecordDto borrowingRecordDto = new BorrowingRecordDto(1L, 1L, 1L, LocalDate.now(), null);
  when(borrowingService.borrowBook(anyLong(), anyLong())).thenReturn(borrowingRecordDto);

  mockMvc.perform(post("/api/borrow/{bookId}/patron/{patronId}", 1L, 1L)
                  .contentType(MediaType.APPLICATION_JSON))
          .andExpect(MockMvcResultMatchers.status().isCreated())
          .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));
 }

 @Test
 public void testReturnBook() throws Exception {
  BorrowingRecordDto borrowingRecordDto = new BorrowingRecordDto(1L, 1L, 1L, LocalDate.now(), LocalDate.now());
  when(borrowingService.returnBook(anyLong(), anyLong())).thenReturn(borrowingRecordDto);

  mockMvc.perform(put("/api/return/{bookId}/patron/{patronId}", 1L, 1L)
                  .contentType(MediaType.APPLICATION_JSON))
          .andExpect(MockMvcResultMatchers.status().isOk())
          .andExpect(MockMvcResultMatchers.jsonPath("$.returnDate").value(LocalDate.now().toString()));
 }
}
