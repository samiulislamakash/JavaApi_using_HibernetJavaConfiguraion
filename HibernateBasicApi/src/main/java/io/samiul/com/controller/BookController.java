package io.samiul.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.samiul.com.model.Book;
import io.samiul.com.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/save")
	public int save( @RequestBody Book book) {
		return bookService.save(book);
	}
	
	@GetMapping("/book/{id}")
	public Book findOne(@PathVariable int id) {
		return bookService.get(id);
	}
	
	@GetMapping("/allBook")
	public List<Book> showAll(){
		return bookService.list();
	}
	
	@PutMapping("/update/{id}")
	public void update(@PathVariable int id ,@RequestBody Book book) {
		bookService.update(id, book);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		bookService.delete(id);
	}
}
