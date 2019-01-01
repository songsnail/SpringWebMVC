package com.springmvc.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.springmvc.domain.Book;

public interface BookRepository {

	List<Book> getAllBookList();

	Book getBookById(String bookID);

	List<Book> getBooksByCategory(String category);

	Set<Book> getBooksByFilter(Map<String, List<String>> filterParams);
	
	void addBook(Book book);	

}
