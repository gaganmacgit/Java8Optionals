package com.example.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Article {

	private String author;
	private String title;
	private List<String> tags;
	private final int wordcount;
	private final Optional<LocalDate> datePublished;

	public Article(final String author, final String title, final List<String> tags, final int wordCount,
			final Optional<LocalDate> datePublished) {
		super();
		this.author = author;
		this.title = title;
		this.tags = tags;
		this.wordcount = wordCount;
		this.datePublished = datePublished;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(final String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(final List<String> tags) {
		this.tags = tags;
	}

	public int getWordcount() {
		return wordcount;
	}

	public Optional<LocalDate> getDatePublished() {
		return datePublished;
	}

	@Override
	public String toString() {
		return "Article [author=" + author + ", title=" + title + ", tags=" + tags + "]";
	}

}