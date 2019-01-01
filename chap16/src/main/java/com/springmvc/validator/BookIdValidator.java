package com.springmvc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.springmvc.exception.NoIdFoundException;
import com.springmvc.service.BookService;
import com.springmvc.domain.Book;

public class BookIdValidator implements ConstraintValidator<BookId, String>{
	
   @Autowired
   private BookService bookService;
   
   public void initialize(BookId constraintAnnotation) { 
   
   }
   public boolean isValid(String value, ConstraintValidatorContext context) { 
      Book book;
      try {
         book = bookService.getBookById(value);
      } catch (NoIdFoundException e) {
         return true;
      }
      if(book!= null) {
         return false;
      }
      return true;
   }
}