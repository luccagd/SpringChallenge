package com.example.springchallenge.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Purchase {
    private Long id;
    private Long idCart;
    private List<Article> articles = new ArrayList<>();

    public void addArticles(Article article) {
        articles.add(article);
    }
}
