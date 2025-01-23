package com.library.books.bookRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.books.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
