package com.itp.app;

import java.util.List;

import com.itp.model.Book;
import com.itp.service.BookService;
import com.itp.service.InvalidCategoryException;

public class TestBookClient {

	public static void main(String[] args) {

		BookService bookService = new BookService();
		bookService.addBook("comp", new Book(10, "SCJP", "Kathy Siera"));
		bookService.addBook("comp", new Book(11, "Effective Java", "Scott"));
		bookService.addBook("ele", new Book(12, "Electronics Semiconductor", "Royan"));

		List<Book> books = bookService.getBooksByCategory("comp");
		for (Book book : books)
			System.out.println(book);
		
		try {
			bookService.udpateBookAuthorByName("computer","Effective Java","Scott & Tiger");
		} catch (InvalidCategoryException e) {
			System.out.println(e.getMessage());
		}
		
		books = bookService.getBooksByCategory("comp");
		for (Book book : books)
			System.out.println(book);
		

	}

}
