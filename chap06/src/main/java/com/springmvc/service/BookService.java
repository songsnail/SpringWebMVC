package com.springmvc.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.springmvc.domain.Book;

public interface BookService {

	List<Book> getAllBookList();

	Book getBookById(String bookID);

	List<Book> getBooksByCategory(String category);

	Set<Book> getBooksByFilter(Map<String, List<String>> filterParams);
	
}
