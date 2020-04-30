package io.samiul.com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bookName;
	private String anthor;
	
	public Book() {
		
	}
	
	public Book( String bookName, String anthor) {
		this.bookName = bookName;
		this.anthor = anthor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAnthor() {
		return anthor;
	}

	public void setAnthor(String anthor) {
		this.anthor = anthor;
	}
	
	
	
}
