package com.springmvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.springmvc.domain.Member;

@Component
public class PasswdConfirmValidator implements Validator{

	public boolean supports(Class<?> clazz) {
        return Member.class.isAssignableFrom(clazz);  
	}

	public void validate(Object target, Errors errors) {
		Member member = (Member) target;

		if(member.getPasswd()!= null && !member.getPasswd().equals(member.getPasswd_confirm())) {
			errors.rejectValue("passwd_confirm", "com.springmvc.passwd_confirm.message");
		}
	}

}
