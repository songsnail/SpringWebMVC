package com.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="��û�� ���� �о߸� ã�� �� �����ϴ�.")
public class NoCategoryFoundException extends RuntimeException{

   private static final long serialVersionUID = 1L;
}