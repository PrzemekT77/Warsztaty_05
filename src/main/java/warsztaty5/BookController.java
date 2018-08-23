package warsztaty5;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
    public class BookController {
	
	MemoryBookService memoryBookService;
	
        public BookController(MemoryBookService memoryBookService) {

		this.memoryBookService = memoryBookService;
	}
		@RequestMapping("/hello")
        public String hello(){
            return "{hello: World}";
        }
        @RequestMapping("/helloBook")
    	public Book helloBook(){
    		return new Book(1L,"9788324631766","Thinking in Java",
    	                    "Bruce Eckel","Helion","programming");
    	}
        @RequestMapping("/getAll")
        public List<Book> getAllBooks(){
        	return memoryBookService.getList();
        }
        
        @RequestMapping("/getBook/{id}")
        public String getBook(@PathVariable (name="id")long id) {
        	return ""+ memoryBookService.book(id);
        }
        @PostMapping
        public void addOneBook(@RequestBody Book book) {
        	memoryBookService.addBook(book);
        }
        @PutMapping (value="/books")
        public void editOneBook(@RequestBody Book book, @PathVariable long id) {
        	if(book.getId()!=id) {
        		throw new IllegalArgumentException("book id doesn't match path id");
        	}
        	memoryBookService.editBook(book, id);
        }
        @PutMapping (value="/books/{id}")
        public void deleteOneBook (@RequestBody long id) {
	        memoryBookService.deleteBook(id);
        }
        
    }
