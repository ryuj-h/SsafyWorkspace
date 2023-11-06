package com.ssafy.book.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.book.dto.Book;
import com.ssafy.book.model.dao.BookDao;

@Service
public class BookServiceImpl implements BookDao {
	private BookDao bookDao;
	
	public BookServiceImpl(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	@Override
	public List<Book> selectAll() throws SQLException {
		return bookDao.selectAll();
	}

	@Override
	public Book selectByNo(int no) throws SQLException {
		return bookDao.selectByNo(no);
	}

	@Override
	public int registBook(Book book) throws SQLException {
		return bookDao.registBook(book);
	}

	@Override
	public int deleteByNo(int no) throws SQLException {
		return bookDao.deleteByNo(no);
	}

}
