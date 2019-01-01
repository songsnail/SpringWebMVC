package com.springmvc.controller;


import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;


@Controller
public class LoginController {
	 
	@RequestMapping(value="/login", method = RequestMethod.GET)	
	public String login() {	
		
 		return "login/login";
	} 
		
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) { 
		model.addAttribute("error", "true");
		return "login/login"; 
	} 
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpSession session ) {
		session.setAttribute("userLoginInfo", null);
		session.invalidate();
		return "login/login";
 	}
}
