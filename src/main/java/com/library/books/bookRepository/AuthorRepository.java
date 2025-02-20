package com.library.books.bookRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.books.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

}
