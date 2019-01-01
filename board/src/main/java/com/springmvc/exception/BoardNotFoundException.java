package com.springmvc.exception;

public class BoardNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -694354952032299587L;
	
	private String boardId;

	public BoardNotFoundException(String boardId) {
		this.boardId = boardId;
	}
	
	public String getBoardId() {
		return boardId;
	}

}
