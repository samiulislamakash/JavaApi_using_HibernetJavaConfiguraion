package io.samiul.com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.samiul.com.model.Book;
import io.samiul.com.repository.BookDao;

@Service
public class BookServiceImp implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Override
	@Transactional
	public int save(Book book) {
		return bookDao.save(book);
	}

	@Override
	@Transactional
	public Book get(int id) {
		return bookDao.get(id);
	}

	@Override
	@Transactional
	public List<Book> list() {
		return bookDao.list();
	}

	@Override
	@Transactional
	public void update(int id, Book book) {
		bookDao.update(id, book);
	}

	@Override
	@Transactional
	public void delete(int id) {
		bookDao.delete(id);		
	}

}
