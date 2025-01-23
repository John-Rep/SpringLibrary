package com.library.books.controllers;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.books.bookRepository.AuthorRepository;
import com.library.books.bookRepository.BookRepository;
import com.library.books.entities.Author;
import com.library.books.entities.Book;
import com.library.books.services.BookDTO;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;
	
	@GetMapping("/")
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}
	
	@PostMapping("/create")
	public Book createBook(@RequestBody BookDTO bookdto) {
		Book book = new Book();
		book.setTitle(bookdto.getTitle());
		book.setDescription(bookdto.getDescription());
		Optional<Author> author = authorRepository.findById(bookdto.getAuthor_id());
		book.setAuthor(author.get());
		return bookRepository.save(book);
	}
	
	
}
