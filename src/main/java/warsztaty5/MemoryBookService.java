package warsztaty5;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MemoryBookService {

	private List<Book> list;
    public MemoryBookService() {
        list = new ArrayList<Book>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                    "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                    "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                    "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }
    
    public List<Book> getList() {
    	return list;
    	}
    
    public void setList(List<Book> list) {
    	this.list = list;
    	}
    public Book book (long id) {
    	Book b = list.get((int) id-1);
    	return b;
    }
   
    public void addBook(Book book) {
    	list.add(book);
    }
    
    public void editBook (Book book1, long id) {
    	list.removeIf(book->book.getId()==id);
    	list.add(book1);
    }
    public void deleteBook (long id) {
    	list.removeIf(book->book.getId()==id);
    }
}
