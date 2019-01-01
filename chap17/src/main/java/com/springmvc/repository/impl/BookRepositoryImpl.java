package com.springmvc.repository.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import com.springmvc.domain.Book;
import com.springmvc.repository.BookRepository;
import com.springmvc.exception.NoIdFoundException;

import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class BookRepositoryImpl implements BookRepository {
	@Autowired
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public List<Book> getAllBookList() {

		String SQL = "SELECT * FROM book";
		List<Book> listOfBooks = template.query(SQL, new BookRowMapper());

		return listOfBooks;
	}

	public Book getBookById(String bookId) {
		Book bookById = null;
		String SQL = "SELECT count(*) FROM book where b_bookId=?";
		int rowCount = template.queryForObject(SQL, Integer.class, bookId);
		if (rowCount != 0) {
			SQL = "SELECT * FROM book where b_bookId=?";
			bookById = template.queryForObject(SQL, new Object[] { bookId }, new BookRowMapper());
		}
		if (bookById == null)
			throw new NoIdFoundException(bookId);
		return bookById;
	}

	public List<Book> getBooksByCategory(String category) {
		List<Book> booksByCategory = new ArrayList<Book>();

		String SQL = "SELECT * FROM book where b_category LIKE '%" + category + "%'";
		booksByCategory = template.query(SQL, new BookRowMapper());

		return booksByCategory;
	}

	public Set<Book> getBooksByFilter(Map<String, List<String>> filterParams) {
		Set<Book> booksByPublisher = new HashSet<Book>();
		Set<Book> booksByCategory = new HashSet<Book>();

		System.out.println(filterParams);

		Set<String> criterias = filterParams.keySet();

		if (criterias.contains("publisher")) {
			for (String pubisherName : filterParams.get("publisher")) {

				String SQL = "SELECT * FROM book where b_publisher LIKE '%" + pubisherName + "%'";
				// book = this.template.query(SQL,new BookRowMapper());
				booksByPublisher.addAll(template.query(SQL, new BookRowMapper()));

			}
		}

		if (criterias.contains("category")) {
			for (String category : filterParams.get("category")) {

				String SQL = "SELECT * FROM book where b_category LIKE '%" + category + "%'";
				booksByCategory.addAll(template.query(SQL, new BookRowMapper()));

			}
		}

		booksByCategory.retainAll(booksByPublisher);

		return booksByCategory;
	}

	public void addBook(Book book) {

		String SQL = "INSERT INTO book (b_bookId, b_name, b_unitPrice, b_author, b_description, b_publisher, b_category, b_unitsInStock, b_releaseDate,b_condition, b_fileName) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		template.update(SQL, book.getBookId(), book.getName(), book.getUnitPrice(), book.getAuthor(),
				book.getDescription(), book.getPublisher(), book.getCategory(), book.getUnitsInStock(),
				book.getReleaseDate(), book.getCondition(), book.getFileName());
		return;

	}

	public void updateBook(Book book) {

		if (book.getFileName() != null) {
			String SQL = "UPDATE Book SET b_name = ?, b_unitPrice = ?, b_author = ?, b_description = ?, b_publisher = ?, b_category = ?, b_unitsInStock = ?,b_releaseDate = ?, b_condition = ?, b_fileName = ?  where b_bookId = ? ";
			template.update(SQL, book.getName(), book.getUnitPrice(), book.getAuthor(), book.getDescription(),
					book.getPublisher(), book.getCategory(), book.getUnitsInStock(), book.getReleaseDate(),
					book.getCondition(), book.getFileName(), book.getBookId());
		} else if (book.getFileName() == null) {
			String SQL = "UPDATE Book SET b_name = ?, b_unitPrice = ?, b_author = ?, b_description = ?, b_publisher = ?, b_category = ?, b_unitsInStock = ?, b_releaseDate = ?, b_condition = ?  where b_bookId = ? ";
			template.update(SQL, book.getName(), book.getUnitPrice(), book.getAuthor(), book.getDescription(),
					book.getPublisher(), book.getCategory(), book.getUnitsInStock(), book.getReleaseDate(),
					book.getCondition(), book.getBookId());
		}

	}

	public void deleteBook(String bookID) {

		String SQL = "DELETE from Book  where b_bookId = ? ";

		template.update(SQL, bookID);

	}

}
