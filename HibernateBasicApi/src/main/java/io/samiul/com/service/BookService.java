package io.samiul.com.service;

import java.util.List;

import io.samiul.com.model.Book;

public interface BookService {
	int save(Book book);

	Book get(int id);

	List<Book> list();

	void update(int id, Book book);

	void delete(int id);
}
