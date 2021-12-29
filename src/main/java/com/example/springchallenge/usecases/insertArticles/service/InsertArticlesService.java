package com.example.springchallenge.usecases.insertArticles.service;

import com.example.springchallenge.entity.Produto;
import com.example.springchallenge.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsertArticlesService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getAll() {
        return produtoRepository.getAll();
    }

    public List<Produto> insertAllArticles(List<Produto> produtos) {
        return produtoRepository.insertAllArticles(produtos);
    }
}
