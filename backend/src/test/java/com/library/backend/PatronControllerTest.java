// package com.library.backend;

// //import .Patron;
// //import PatronService;
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
// public class PatronControllerTest {

//     private MockMvc mockMvc;

//     @Mock
//     private PatronService patronService;

//     @InjectMocks
//     private PatronController patronController;

//     @BeforeEach
//     public void setup() {
//         MockitoAnnotations.openMocks(this);
//         mockMvc = MockMvcBuilders.standaloneSetup(patronController).build();
//     }

//     @Test
//     public void testCreatePatron() throws Exception {
//         when(patronService.savePatron(any(Patron.class))).thenReturn(new Patron(1L, "Patron Name"));

//         String patronJson = "{\"name\":\"Patron Name\"}";

//         mockMvc.perform(post("/patrons")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(patronJson))
//                 .andExpect(MockMvcResultMatchers.status().isCreated())
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));
//     }

//     @Test
//     public void testGetPatron() throws Exception {
//         when(patronService.getPatronById(1L)).thenReturn(new Patron(1L, "Patron Name"));

//         mockMvc.perform(get("/patrons/{id}", 1L))
//                 .andExpect(MockMvcResultMatchers.status().isOk())
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));
//     }

//     @Test
//     public void testUpdatePatron() throws Exception {
//         when(patronService.updatePatron(any(Long.class), any(Patron.class))).thenReturn(new Patron(1L, "Updated Name"));

//         String updatedPatronJson = "{\"name\":\"Updated Name\"}";

//         mockMvc.perform(put("/patrons/{id}", 1L)
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(updatedPatronJson))
//                 .andExpect(MockMvcResultMatchers.status().isOk())
//                 .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Updated Name"));
//     }

//     @Test
//     public void testDeletePatron() throws Exception {
//         mockMvc.perform(delete("/patrons/{id}", 1L))
//                 .andExpect(MockMvcResultMatchers.status().isNoContent());
//     }
// }
