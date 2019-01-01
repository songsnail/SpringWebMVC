package com.springmvc.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.springmvc.domain.Book;
import com.springmvc.repository.BookRepository;
import com.springmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBookList() {
		return bookRepository.getAllBookList();
	}

	public Book getBookById(String bookID) {
		return bookRepository.getBookById(bookID);
	}

	public List<Book> getBooksByCategory(String category) {
		return bookRepository.getBooksByCategory(category);
	}

	public Set<Book> getBooksByFilter(Map<String, List<String>> filterParams) {
		return bookRepository.getBooksByFilter(filterParams);
	}

	public void addBook(Book book) {
		bookRepository.addBook(book);
	}

}
