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
public class Compra {
    private Long id;
    private List<Produto> articles = new ArrayList<>();

    public void addArticles(Produto produto){
        articles.add(produto);
    }
}
