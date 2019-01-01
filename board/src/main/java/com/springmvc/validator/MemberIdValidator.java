package com.springmvc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.domain.Member;
import com.springmvc.exception.NoMemberByIdFoundException;
import com.springmvc.service.MemberService;

public class MemberIdValidator implements ConstraintValidator<MemberId, String>{
	
	@Autowired
	private MemberService memberService;

	public void initialize(MemberId constraintAnnotation) {
		//  intentionally left blank; this is the place to initialize the constraint annotation for any sensible default values.
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		Member member;
		try {
			member = memberService.getMemberById(value);
			
		} catch (NoMemberByIdFoundException e) {
			return true;
		}
		
		if(member!= null) {
			return false;
		}
		
		return true;
	}
	
}
