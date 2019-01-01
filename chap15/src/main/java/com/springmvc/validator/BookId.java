package com.springmvc.validator;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import javax.validation.Constraint;
import javax.validation.Payload;


@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = BookIdValidator.class)
public @interface BookId {
  // String message() default "";
	String message() default "{BookId.newBook.bookId}";
   Class<?>[] groups() default {};
  // Class<?>[] payload() default {};
   public abstract Class<? extends Payload>[]payload() default {};
}