package com.springmvc.exception;

public class NoIdFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String bookId;

	public NoIdFoundException(String bookId) {
		this.bookId = bookId;
	}

	public String getBookId() {
		return bookId;
	}
}
