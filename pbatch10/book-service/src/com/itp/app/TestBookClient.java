package com.itp.app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.itp.model.Book;
import com.itp.service.BookService;

public class TestBookClient {

	public static void main(String[] args) {

		List<Book> mathBooks = new ArrayList<>();
		List<Book> physicsBooks = new ArrayList<>();
		List<Book> scienceBooks = new ArrayList<>();
		

		List<List<Book>> allBooks = new ArrayList<>();
		allBooks.add(mathBooks);		
		allBooks.add(physicsBooks);
		allBooks.add(scienceBooks);
		
		
		Set<String> bcsStudents = new HashSet<>();
		Set<String> mcsStudents = new HashSet<>();

		List<Set<String>> allStudentNames =  new ArrayList<>();
		allStudentNames.add(bcsStudents);
		allStudentNames.add(mcsStudents);
		

		BookService bookService = new BookService();
		bookService.addBook(new Book(10, "SCJP", "Kathy Siera"));
		bookService.addBook(new Book(11, "Effective Java", "Scott"));
		bookService.addBook(new Book(12, "Complete Java", "Herbelt Schilt"));
		
		List<Book> books = bookService.getAllBooks();
		for(Book book : books)
			System.out.println(book);

		System.out.println("******** Books By Authro ***********");
		books = bookService.getBooksByAuthorName("Scott");
		for(Book book : books)
			System.out.println(book);
		
		
		//Delete the book by ID
		bookService.deleteById(11);
		//bookService.deleteById(12);
		
		System.out.println("****** After Deletion **************");
		books = bookService.getAllBooks();
		for(Book book : books)
			System.out.println(book);

		//Retrieve book by id
		Book  book = bookService.getBookById(10);
		System.out.println(book);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
