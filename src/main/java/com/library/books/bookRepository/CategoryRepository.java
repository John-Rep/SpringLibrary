package com.library.books.bookRepository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.books.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	Set<Category> findByIdIn(Long[] categories);
}
