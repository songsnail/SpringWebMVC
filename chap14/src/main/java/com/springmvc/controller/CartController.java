package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.springmvc.exception.NoIdFoundException;

import com.springmvc.domain.Cart;
import com.springmvc.domain.CartItem;
import com.springmvc.domain.Book;
import com.springmvc.service.CartService;
import com.springmvc.service.BookService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private BookService bookService;

	@RequestMapping
	public String get(HttpServletRequest request) {
		String sessionId = request.getSession(true).getId();
		return "redirect:/cart/" + sessionId;
	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public String read(@PathVariable(value = "cartId") String cartId, Model model) {
		Cart cart = cartService.read(cartId);
		model.addAttribute("cart", cart);

		return "cart";

	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "cartId") String cartId, HttpServletRequest request) {
		cartService.delete(cartId);

	}

	@RequestMapping(value = "/add/{bookId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable String bookId, HttpServletRequest request) {

		String sessionId = request.getSession(true).getId();
		Cart cart = cartService.read(sessionId);
		if (cart == null)
			cart = cartService.create(new Cart(sessionId));

		Book book = bookService.getBookById(bookId);
		if (book == null)
			throw new IllegalArgumentException(new NoIdFoundException(bookId));

		cart.addCartItem(new CartItem(book));

		cartService.update(sessionId, cart);

	}

	@RequestMapping(value = "/remove/{bookId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable String bookId, HttpServletRequest request) {

		String sessionId = request.getSession(true).getId();
		Cart cart = cartService.read(sessionId);
		if (cart == null)
			cart = cartService.create(new Cart(sessionId));

		Book book = bookService.getBookById(bookId);
		if (book == null)
			throw new IllegalArgumentException(new NoIdFoundException(bookId));

		cart.removeCartItem(new CartItem(book));

		cartService.update(sessionId, cart);

	}

}
