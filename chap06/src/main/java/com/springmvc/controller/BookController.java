package com.springmvc.controller;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.springmvc.domain.Book;
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

	@GetMapping("/{category}")
	public String requestBooksByCategory(@PathVariable("category") String bookCategory, Model model) {
		List<Book> booksByCategory = bookService.getBooksByCategory(bookCategory);	
		model.addAttribute("books", booksByCategory);
		return "books";
	}

	@GetMapping("/filter/{ByFilter}")
	public String getBooksByFilter(@MatrixVariable(pathVar="ByFilter") Map<String, List<String>> bookFilter, Model model) {
		Set<Book> booksByFiter = bookService.getBooksByFilter(bookFilter);
		model.addAttribute("books", booksByFiter);
		return "books";
	}

	@GetMapping("/book")
	public String requestBookById(@RequestParam("id") String bookId, Model model) {
		Book bookById = bookService.getBookById(bookId);
		model.addAttribute("book", bookById);
		return "book";
	}


}