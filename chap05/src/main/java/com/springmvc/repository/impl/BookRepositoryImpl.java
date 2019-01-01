package com.springmvc.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.domain.Book;
import com.springmvc.repository.BookRepository;

@Repository
public class BookRepositoryImpl implements BookRepository {

	private List<Book> listOfBooks = new ArrayList<Book>();

	public BookRepositoryImpl() {
		Book book1 = new Book("ISBN1234", "HTML5+CSS3 ", 19800);
		book1.setAuthor("Ȳ��ȣ");
		book1.setDescription(
				"�ڵ�� ���� ȭ���� �ٷ� ������ �����θ� �о ��� �۵��ϴ��� ���� �ľ��� �� �ִ� ���� �⺻�̰�, �߰��߰� ��� �߰��Ͽ� ����ְ� �����ϵ� ������ �� �ֽ��ϴ�. ���� ���� �� �Թ��Ͽ� ������ ���� ���� ���� �������� ����Ͽ�, �ñ����� ������ �˾Ƽ� �����ϰ�, ������ ģ���ϰ� �����ݴϴ�. ");
		book1.setPublisher("�Ѻ��̵��");
		book1.setCategory("IT������");
		book1.setUnitsInStock(1000);
		book1.setReleaseDate("2018/03/02");

		Book book2 = new Book("ISBN1235", "JSP �� ���α׷��� ", 27000);
		book2.setAuthor("�۹̿�");
		book2.setDescription(
				"JSP�� �̷��� ���� �� �⺻ �ǽ� �� ���� �ǽ� ���� �ܰ躰 �н��� �����մϴ�. ���� �ǽ��� ������ ���������� ���θ� �ϳ��� �ϼ��ϴ� �����̶� ��� ������ ��� ��� ����Ǵ��� �� �� �ֽ��ϴ�.");
		book2.setPublisher("�Ѻ���ī����");
		book2.setCategory("IT������");
		book2.setUnitsInStock(1000);
		book2.setReleaseDate("2018/10/08");

		Book book3 = new Book("ISBN1236", "����������", 22000);
		book3.setAuthor("������");
		book3.setDescription(
				"�� å�� IT �ʺ��ڶ� ���� ���� ���� ������ ������, ������������ ��ġ�ϰ�, ������ ȭ�鿡�� ������ �ٲٰ�, ���� �׸��� �÷������� Ȱ���ϸ鼭 ������������ ���� ��ü ������ ������ ��Ҵ�.");
		book3.setPublisher("�Ѻ��̵��");
		book3.setCategory("ITȰ�뼭");
		book3.setUnitsInStock(1000);
		book3.setReleaseDate("2018/07/25");

		listOfBooks.add(book1);
		listOfBooks.add(book2);
		listOfBooks.add(book3);

	}

	public List<Book> getAllBookList() {
		return listOfBooks;
	}

	public Book getBookById(String bookId) {
		Book bookById = null;

		for (Book book : listOfBooks) {
			if (book != null && book.getBookId() != null && book.getBookId().equals(bookId)) {
				bookById = book;
				break;
			}
		}

		if (bookById == null) {
			throw new IllegalArgumentException("����ID�� �ش��ϴ� ������ ã�� �� �����ϴ�: " + bookId);
		}

		return bookById;
	}
}
