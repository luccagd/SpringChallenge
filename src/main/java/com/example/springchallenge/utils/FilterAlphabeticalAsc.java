package com.example.springchallenge.utils;

import java.util.Comparator;
import java.util.List;

import com.example.springchallenge.entity.Article;

public class FilterAlphabeticalAsc implements FilterStrategyInterface<Article> {

    @Override
    public List<Article> apply(List<Article> articles) {
        articles.sort(Comparator.comparing(Article::getName));

        return articles;
    }
}