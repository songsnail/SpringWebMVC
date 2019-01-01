package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String welcome(Model model) {

		model.addAttribute("greeting", "웹 쇼핑몰에 오신 것을 환영합니다!");
		model.addAttribute("strapline", "Welcome to Web Market!");

		return "home";
	}

}
