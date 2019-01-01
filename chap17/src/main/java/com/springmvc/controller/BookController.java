package com.springmvc.controller;

import org.springframework.stereotype.Controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;

import com.springmvc.domain.Book;
import com.springmvc.exception.NoCategoryFoundException;
import com.springmvc.exception.NoIdFoundException;
import com.springmvc.service.BookService;
import com.springmvc.validator.BookValidator;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	
	@Autowired
	 private BookValidator bookValidator;  // BookValidator 인스턴스 선언
	 
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

	/*
	  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "요청한 도서 분야를 찾을 수 없습니다.")
	  
	  @GetMapping("/{category}") public String
	  requestBooksByCategory(@PathVariable("category") String bookCategory, Model
	  model) { model.addAttribute("books",
	  bookService.getBooksByCategory(bookCategory)); return "books"; }
	 */

	@GetMapping("/{category}")
	public String requestBooksByCategory(@PathVariable("category") String bookCategory, Model model) {
		List<Book> booksByCategory = bookService.getBooksByCategory(bookCategory);
		if (booksByCategory == null || booksByCategory.isEmpty()) {
			throw new NoCategoryFoundException();
		}

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

	@GetMapping("/add")
	public String getAddNewBookForm(@ModelAttribute("newBook") Book book) {
		return "addBook";
	}

	@PostMapping("/add")
	public String submitAddNewBookForm(@Valid @ModelAttribute("newBook") Book book, BindingResult result,
			HttpServletRequest request) {
		
		if(result.hasErrors()) {
	         return "addBook";
	      }
		
		String[] suppressedFields = result.getSuppressedFields();

		if (suppressedFields.length > 0) {
			throw new RuntimeException(
					"허용되지 않는 입력 항목을 바인딩하려고 합니다.: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}

		MultipartFile bookImage = book.getBookImage();
		String rootDirectory = "c:/upload/";
		if (bookImage!=null && !bookImage.isEmpty()) {
		       try {
		    	    File tempDir = new File(rootDirectory);
		           if(!tempDir.exists()) tempDir.mkdirs();
		          		           
		    	   String fname = bookImage.getOriginalFilename(); 
		    	   bookImage.transferTo(new File(rootDirectory + fname));		    	  
		    	   book.setFileName(fname);          
		    	 
		       } catch (Exception e) {
				throw new RuntimeException("Book Image saving failed", e);
		   }
		   }


		bookService.addBook(book);
		return "redirect:/books";
	}

	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("bookId", "name", "unitPrice", "author", "description", "publisher", "category",
				"unitsInStock", "releaseDate", "condition", "bookImage");
		binder.setValidator(bookValidator);		
	}

	@ExceptionHandler(value = NoIdFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, NoIdFoundException exception) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("invalidBookId", exception.getBookId());
		mav.addObject("exception", exception);

		mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString());
		mav.setViewName("errorBook");
		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String getUpdateBookForm(@ModelAttribute("updateBook") Book upbook ,@RequestParam("id") String bookId, Model model) {
		Book book = bookService.getBookById(bookId);
		model.addAttribute("book", book);
		return "updateForm";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String processUpdatewBookForm(@ModelAttribute("updateBook") Book upbook, Model map, BindingResult result, HttpServletRequest request) {
		System.out.print("ok4--------------------------------------------------------");
		MultipartFile bookImage = upbook.getBookImage();
		
		String rootDirectory = "c:/upload/";
				
			if (bookImage!=null && !bookImage.isEmpty()) {
		       try {
		    	   String fname = bookImage.getOriginalFilename(); 
		    	   bookImage.transferTo(new File("c:/upload/" + fname));
		    	   upbook.setFileName(fname);
		    		    	 
		       } catch (Exception e) {
				throw new RuntimeException("Book Image saving failed", e);
		   }
		   }

		
	   	bookService.updateBook(upbook);
		return "redirect:/books";
	}
	
	@RequestMapping("/delete")
	public String getDeleteBookForm(Model model, @RequestParam("id") String bookId) {
		bookService.deleteBook(bookId);
		return "redirect:/books";
	}
	/*
	@RequestMapping(value = "/updateForm")
	public String getUpdateBookForm(@RequestParam("id") String bookId, Model model) {
		Book book = bookService.getBookById(bookId);
		model.addAttribute("book", book);
		return "updateForm";
	}
	*/
	
}