package com.springmvc.exception;

public class NoMemberByIdFoundException extends RuntimeException{

	private static final long serialVersionUID = -694354952032299587L;

	

	private String memberId;

	public NoMemberByIdFoundException(String id) {
		this.memberId =id;
	}
	
	public String getMemberId() {
		return memberId;
	}

}
