import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//handle http 

import com.library.backend.dto.booksDto;
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
	  public ResponseEntity<booksDto> createBook(@RequestBody bookDto){
		  booksDto savedbook = BooksService.create(bookDto);
		  return new ResponseEntity<>(savedbook,HttpStatus.CREATED)
	  }
}
