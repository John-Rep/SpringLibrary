package com.library.books.services;

public class BookDTO {

	public BookDTO() {}
	
	public BookDTO(String title, String description, Long author_id) {
		this.setTitle(title);
		this.setDescription(description);
		this.setAuthor_id(author_id);
	}

	private String title;
	private String description;
	private Long author_id;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(Long author_id) {
		this.author_id = author_id;
	}
	
}
