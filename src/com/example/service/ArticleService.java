package com.example.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.example.model.Article;

public class ArticleService {

	List<Article> articleList = Collections.emptyList();

	public ArticleService() {

		//creating article list
		createArticleList();
		
		//get the article for tag java
		Optional<Article> optionalArticle = getRelevantArticleFor("java");
		//if found just print the article
		optionalArticle.ifPresent(System.out::println);
		
		optionalArticle = getRelevantArticleFor("dummy");
		//if no article found for optional, then get some article
		System.out.println(optionalArticle.orElse(getDummyArticle()));
		
		//convert the optional article to optional of title
		Optional<String> titleOptional = optionalArticle.map(a->a.getTitle());
		System.out.println(titleOptional);
		
		//getting the optional with null date
		optionalArticle = getRelevantArticleFor("java");
		optionalArticle.map(a -> a.getDatePublished());
		
		Optional<LocalDate> localDateOptional = optionalArticle.flatMap(a->a.getDatePublished());
		localDateOptional.ifPresent(date -> System.out.println(date));
		
	}

	private Article getDummyArticle() {
		return new Article("Dummy", "DummyTitle", Arrays.asList("dummy"), 0, null);
	}

	private Optional<Article> getRelevantArticleFor(String tag) {
		return articleList.stream().filter(art -> art.getTags().contains(tag)).findFirst();
	}

	private void createArticleList() {
		final Article article1 = new Article("Author1", "Title1", Arrays.asList("java"), 20, Optional.of(LocalDate.parse("2015-02-20")));
		final Article article2 = new Article("Author2", "Title2", Arrays.asList("c++"), 8,Optional.of(LocalDate.parse("2018-02-20")));
		final Article article3 = new Article("Author3", "Title3", Arrays.asList("java"), 5,Optional.of(LocalDate.parse("2017-02-20")));
		final Article article4 = new Article("Author1", "Title4", Arrays.asList("c"), 5,Optional.of(LocalDate.parse("2015-02-20")));
		final Article article5 = new Article("Author5", "Title5", Arrays.asList("oracle"), 12,Optional.empty());

		articleList = new ArrayList<>();
		articleList.add(article1);
		articleList.add(article2);
		articleList.add(article3);
		articleList.add(article4);
		articleList.add(article5);

	}

	public static void main(String[] args) {
		new ArticleService();
	}

}
