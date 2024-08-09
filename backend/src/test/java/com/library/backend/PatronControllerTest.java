package com.library.backend;

import com.library.backend.dto.PatronDto;
import com.library.backend.controller.PatronController;
import com.library.backend.service.PatronService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@WebMvcTest(PatronController.class)
public class PatronControllerTest {

 @Autowired
 private MockMvc mockMvc;

 @MockBean
 private PatronService patronService;

 @Test
 public void testCreatePatron() throws Exception {
  PatronDto patronDto = new PatronDto(1L, "Patron Name", "123-456-7890", "patron@example.com");
  when(patronService.create(any(PatronDto.class))).thenReturn(patronDto);

  String patronJson = "{\"name\":\"Patron Name\",\"phone\":\"123-456-7890\",\"email\":\"patron@example.com\"}";

  mockMvc.perform(post("/api/patrons")
                  .contentType(MediaType.APPLICATION_JSON)
                  .content(patronJson))
          .andExpect(MockMvcResultMatchers.status().isCreated())
          .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
          .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Patron Name"));
 }

 @Test
 public void testGetPatron() throws Exception {
  PatronDto patronDto = new PatronDto(1L, "Patron Name", "123-456-7890", "patron@example.com");
  when(patronService.get(anyLong())).thenReturn(patronDto);

  mockMvc.perform(get("/api/patrons/{id}", 1L))
          .andExpect(MockMvcResultMatchers.status().isOk())
          .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
          .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Patron Name"));
 }

 @Test
 public void testUpdatePatron() throws Exception {
  PatronDto updatedPatronDto = new PatronDto(1L, "Updated Name", "123-456-7890", "updated@example.com");
  when(patronService.update(anyLong(), any(PatronDto.class))).thenReturn(updatedPatronDto);

  String updatedPatronJson = "{\"name\":\"Updated Name\",\"phone\":\"123-456-7890\",\"email\":\"updated@example.com\"}";

  mockMvc.perform(put("/api/patrons/{id}", 1L)
                  .contentType(MediaType.APPLICATION_JSON)
                  .content(updatedPatronJson))
          .andExpect(MockMvcResultMatchers.status().isOk())
          .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Updated Name"));
 }

 @Test
 public void testDeletePatron() throws Exception {
  mockMvc.perform(delete("/api/patrons/{id}", 1L))
          .andExpect(MockMvcResultMatchers.status().isNoContent());
 }
}
