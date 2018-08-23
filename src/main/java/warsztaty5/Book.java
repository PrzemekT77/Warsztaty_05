package warsztaty5;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

	private final long id;
	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher="
				+ publisher + ", type=" + type + "]";
	}

	private final String isbn; 
	private final String title;
	private final String author;
	private final String publisher;
	private final String type;
	
	public long getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getType() {
		return type;
	}
	@JsonCreator
	public Book(@JsonProperty("id")long id, 
			@JsonProperty("isbn") String isbn, 
			@JsonProperty("title")String title, 
			@JsonProperty("author")String author, 
			@JsonProperty("publisher") String publisher, 
			@JsonProperty("type")String type) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.type = type;
	}
}
