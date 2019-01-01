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
		book1.setAuthor("황재호");
		book1.setDescription(
				"코드와 실행 화면이 바로 보여서 눈으로만 읽어도 어떻게 작동하는지 쉽게 파악할 수 있는 것은 기본이고, 중간중간 퀴즈를 추가하여 재미있게 게임하듯 복습할 수 있습니다. 또한 이제 막 입문하여 도움을 구할 곳이 없는 여러분을 고려하여, 궁금해할 내용을 알아서 질문하고, 팁으로 친절하게 답해줍니다. ");
		book1.setPublisher("한빛미디어");
		book1.setCategory("IT전문서");
		book1.setUnitsInStock(1000);
		book1.setReleaseDate("2018/03/02");

		Book book2 = new Book("ISBN1235", "JSP 웹 프로그래밍 ", 27000);
		book2.setAuthor("송미영");
		book2.setDescription(
				"JSP의 이론적 개념 → 기본 실습 → 응용 실습 순의 단계별 학습이 가능합니다. 응용 실습이 합쳐져 최종적으로 쇼핑몰 하나를 완성하는 구성이라 배운 내용이 어디에 어떻게 적용되는지 알 수 있습니다.");
		book2.setPublisher("한빛아카데미");
		book2.setCategory("IT전문서");
		book2.setUnitsInStock(1000);
		book2.setReleaseDate("2018/10/08");

		Book book3 = new Book("ISBN1236", "워드프레스", 22000);
		book3.setAuthor("박현우");
		book3.setDescription(
				"이 책은 IT 초보자라도 웹에 대한 사전 지식을 익히고, 워드프레스를 설치하고, 관리자 화면에서 설정을 바꾸고, 무료 테마와 플러그인을 활용하면서 워드프레스를 배우는 전체 과정을 고스란히 담았다.");
		book3.setPublisher("한빛미디어");
		book3.setCategory("IT활용서");
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
			throw new IllegalArgumentException("도서ID에 해당하는 도서를 찾을 수 없습니다: " + bookId);
		}

		return bookById;
	}
}
