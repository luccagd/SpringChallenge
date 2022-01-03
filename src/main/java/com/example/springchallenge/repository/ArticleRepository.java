package com.example.springchallenge.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.springchallenge.entity.Article;
import com.example.springchallenge.helper.DatabaseHelper;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class ArticleRepository {
    private ObjectMapper objectMapper = DatabaseHelper.getObjectMapper();
    private String PATH = DatabaseHelper.getDatabasePath();
    private List<Article> articles = new ArrayList<>(DatabaseHelper.getDatabaseArticle());

    public List<Article> insertAllArticles(List<Article> articles) {
        for (Article product : articles) {
            product.setProductId((long) this.articles.size() + 1);

            this.articles.add(product);
        }

        updateFile();

        return articles;
    }

    public void updateFile() {
        try {
            objectMapper.writeValue(new File(PATH), articles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Article> getAll() {
        return articles;
    }

    public Article getById(Long id) {
        return articles.stream().filter(p -> p.getProductId().equals(id)).findFirst().get();
    }
}
