package com.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;


import com.springmvc.domain.Member;
import com.springmvc.service.MemberService;

@Controller
public class HomeController {

	
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping("/")
	public String home(Model model) {	
		model.addAttribute("greeting", "Spring 웹  MVC 게시판");			
		return "welcome";		
	}
	
	
	@RequestMapping("/home")
	public String welcome(Model model, Authentication authentication, HttpSession session) {

		
		  User user = (User) authentication.getPrincipal();
		  String userId = user.getUsername();		
		
		if(userId==null)
		{
			
			return "redirect:/login";
		}
		
		Member member = memberService.getMemberById(userId);
		
		model.addAttribute("greeting", member.getName()+"님  환영합니다!");		
		session.setAttribute("userLoginInfo", member);
	
		return "welcome";
	}
	
	
}
