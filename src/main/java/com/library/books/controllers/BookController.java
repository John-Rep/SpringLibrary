package com.library.books.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.books.bookRepository.AuthorRepository;
import com.library.books.bookRepository.BookRepository;
import com.library.books.bookRepository.CategoryRepository;
import com.library.books.entities.Author;
import com.library.books.entities.Book;
import com.library.books.entities.Category;
import com.library.books.services.BookDTO;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/")
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	@PostMapping("/create")
	public Book createBook(@RequestBody BookDTO bookdto) {
		Book book = new Book();
		book.setTitle(bookdto.getTitle());
		book.setDescription(bookdto.getDescription());
		Optional<Author> author = authorRepository.findById(bookdto.getAuthorId());
		book.setAuthor(author.get());
		Set<Category> categories = categoryRepository.findByIdIn(bookdto.getCategoryIds());
		book.setCategories(categories);
		return bookRepository.save(book);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody BookDTO bookdto, @PathVariable Long id) {
		Book book = bookRepository.findById(id).orElse(null);
		if (book != null) {
			book.setTitle(bookdto.getTitle());
			book.setDescription(bookdto.getDescription());
			Optional<Author> author = authorRepository.findById(bookdto.getAuthorId());
			book.setAuthor(author.get());
			Set<Category> categories = categoryRepository.findByIdIn(bookdto.getCategoryIds());
			book.setCategories(categories);
			return ResponseEntity.ok(bookRepository.save(book));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable Long id) {
		if (bookRepository.findById(id) != null) {
			bookRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}
