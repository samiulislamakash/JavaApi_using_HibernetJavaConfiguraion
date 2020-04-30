package io.samiul.com.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.samiul.com.model.Book;

@Repository
public class BookDaoImp implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int save(Book book) {
		Session session = sessionFactory.getCurrentSession();
		session.save(book);
		session.flush();
		return book.getId();
	}

	@Override
	public Book get(int id) {
		return sessionFactory.getCurrentSession().get(Book.class, id);
	}

	@Override
	public List<Book> list() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Book";
		Query<Book> query = session.createQuery(hql);
		List<Book> list = query.getResultList();
		return list;
	}

	@Override
	public void update(int id, Book book) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Book where id = " + id;
		Query query = session.createQuery(hql);
		Book book2 = (Book) query.uniqueResult();
		if (book2 != null) {
			book2.setAnthor(book.getAnthor());
			book2.setBookName(book.getBookName());
			session.saveOrUpdate(book2);
		} else {
			session.save(book);
		}
		session.flush();
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Book where id = "+id;
		Query query = session.createQuery(hql);
		Book book2 = (Book) query.uniqueResult();
		session.delete(book2);
		session.flush();
	}

}
