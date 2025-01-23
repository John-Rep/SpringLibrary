package com.library.books.services;

public class BookDTO {

	public BookDTO() {}
	
	public BookDTO(String title, String description, Long author_id, Long[] category_ids) {
		this.setTitle(title);
		this.setDescription(description);
		this.setAuthorId(author_id);
		this.setCategoryIds(category_ids);
	}

	private String title;
	private String description;
	private Long author_id;
	private Long[] category_ids;
	
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

	public Long getAuthorId() {
		System.out.println("Author returned as : " + author_id);
		return author_id;
	}

	public void setAuthorId(Long author_id) {
		System.out.println("Author set as : " + author_id);
		this.author_id = author_id;
	}

	public Long[] getCategoryIds() {
		System.out.println("Categories");
		return category_ids;
	}

	public void setCategoryIds(Long[] category_ids) {
		this.category_ids = category_ids;
	}
	
}
