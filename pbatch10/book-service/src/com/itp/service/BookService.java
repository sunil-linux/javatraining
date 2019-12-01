package com.itp.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.itp.model.Book;

public class BookService {

	private  Map<String,List<Book>> booksMap = new HashMap<>();

	public void addBook(String category, Book book) {
		List<Book> books  = booksMap.get(category);
		if(books == null) {
			books = new LinkedList<>();
		}
		
		books.add(book);

		booksMap.put(category, books);
	}
	
	public List<Book> getBooksByCategory(String category) {
		return booksMap.get(category);
	}

	public void udpateBookAuthorByName(String category, String bookName, String newAuthorName) throws InvalidCategoryException{
		
		if(booksMap.get(category) == null)
			throw new InvalidCategoryException("Given book category not exist");
		
		//what if given category not exist  in map ?
		List<Book> books = booksMap.get(category);
		for(Book book : books) {
			if(book.getName().equalsIgnoreCase(bookName)) {
				book.setAuthor(newAuthorName);
			}
		}
		
//		booksMap.remove(category);
		
		
	}

//	public Book getBookById(int id) {
//		Iterator<Book> itr = booksMap.iterator();
//		while (itr.hasNext()) {
//			Book book = itr.next();
//			if (book.getId() == id) {
//				return book;
//			}
//		}
//		return null;
//	}
//
//	public List<Book> getAllBooks() {
//		return booksMap;
//	}
//
//	public List<Book> getBooksByAuthorName(String authorName) {
//		List<Book> authorBooks = new ArrayList<>();
//		for (Book book : booksMap) {
//			if (book.getAuthor().equalsIgnoreCase(authorName))
//				authorBooks.add(book);
//		}
//		return authorBooks;
//	}
//
//	public void deleteById(int id) {
//		// search book by given id and delete it from list.
//		Iterator<Book> itr = booksMap.iterator();
//		while (itr.hasNext()) {
//			Book book = itr.next();
//			if (book.getId() == id)
//				itr.remove();
//		}
//	}
}
