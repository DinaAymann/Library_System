package com.library.backend;

// //import BorrowRecord;
// //import BorrowRecordService;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// import static org.mockito.Mockito.any;
// import static org.mockito.Mockito.when;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

// @WebMvcTest
public class BorrowRecordControllerTest {

//     private MockMvc mockMvc;

//     @Mock
//     private BorrowRecordService borrowRecordService;

//     @InjectMocks
//     private BorrowRecordController borrowRecordController;

//     @BeforeEach
//     public void setup() {
//         MockitoAnnotations.openMocks(this);
//         mockMvc = MockMvcBuilders.standaloneSetup(borrowRecordController).build();
//     }

//     @Test
//     public void testCreateBorrowRecord() throws Exception {
//         when(borrowRecordService.saveBorrowRecord(any(BorrowRecord.class))).thenReturn(new BorrowRecord(1L, null, null, null, null));

//         String borrowRecordJson = "{\"bookId\":1,\"patronId\":1,\"borrowDate\":\"2023-01-01\",\"returnDate\":\"2023-02-01\"}";

//         mockMvc.perform(post("/borrow")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(borrowRecordJson))
//                 .andExpect(MockMvcResultMatchers.status().isCreated())
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));
//     }

//     @Test
//     public void testGetBorrowRecord() throws Exception {
//         when(borrowRecordService.getBorrowRecordById(1L)).thenReturn(new BorrowRecord(1L, null, null, null, null));

//         mockMvc.perform(get("/borrow/{id}", 1L))
//                 .andExpect(MockMvcResultMatchers.status().isOk())
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));
//     }

//     @Test
//     public void testUpdateBorrowRecord() throws Exception {
//         when(borrowRecordService.updateBorrowRecord(any(Long.class), any(BorrowRecord.class)))
//                 .thenReturn(new BorrowRecord(1L, null, null, "2023-03-01", "2023-04-01"));

//         String updatedBorrowRecordJson = "{\"bookId\":1,\"patronId\":1,\"borrowDate\":\"2023-03-01\",\"returnDate\":\"2023-04-01\"}";

//         mockMvc.perform(put("/borrow/{id}", 1L)
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(updatedBorrowRecordJson))
//                 .andExpect(MockMvcResultMatchers.status().isOk())
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.borrowDate").value("2023-03-01"));
//     }

//     @Test
//     public void testDeleteBorrowRecord() throws Exception {
//         mockMvc.perform(delete("/borrow/{id}", 1L))
//                 .andExpect(MockMvcResultMatchers.status().isNoContent());
//     }
 }
