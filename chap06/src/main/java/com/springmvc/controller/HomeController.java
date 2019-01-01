package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String welcome(Model model) {

		model.addAttribute("greeting", "�� ���θ��� ���� ���� ȯ���մϴ�!");
		model.addAttribute("strapline", "Welcome to Web Market!");

		return "home";
	}

}
