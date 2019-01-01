package com.springmvc.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Freeboard {
	
	private int num;		
	
	@Size(min=2, max=10, message="{Size.Board.name.validation}")
	private String name;
	@NotEmpty(message= "{NotEmpty.Board.passwd.validation}")
	private String passwd ;
	@NotEmpty(message= "{NotEmpty.Board.subject.validation}")
	private String subject; 	
	private String content;	   
	private String regist_day; 		
	private int   hit; 	
	private String   ip;
	
	
	public Freeboard() {
		super();
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content.replace("\r\n", "<br>");;
	}

	public String getRegist_day() {
		return regist_day;
	}

	public void setRegist_day(String regist_day) {
		this.regist_day = regist_day;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	

	
}
