package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import com.springmvc.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;	

	@GetMapping
	public String requestBookList(Model model) {
		model.addAttribute("books", bookService.getAllBookList());
		return "books";
	}	

	@GetMapping("/all")
	public ModelAndView requestAllBookList() {
		ModelAndView modelAndView = new ModelAndView();		
		modelAndView.addObject("books", bookService.getAllBookList());
		modelAndView.setViewName("books");
		return modelAndView;
	}
	
}