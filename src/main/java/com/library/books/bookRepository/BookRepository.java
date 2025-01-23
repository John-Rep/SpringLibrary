package com.library.books.bookRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.books.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByAuthorId(Long author_id);

	List<Book> findByCategoriesId(Long category_id);
}
