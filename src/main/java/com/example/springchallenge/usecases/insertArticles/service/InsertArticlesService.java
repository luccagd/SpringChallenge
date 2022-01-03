package com.example.springchallenge.usecases.insertArticles.service;

import com.example.springchallenge.entity.Article;
import com.example.springchallenge.exception.AppErrorException;
import com.example.springchallenge.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsertArticlesService {

    @Autowired
    private ArticleRepository produtoRepository;

    public List<Article> getAll() {
        try {
            return produtoRepository.getAll();
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Não foi possível listar todos os produtos!",
                    e.getMessage());
        }
    }

    public List<Article> insertAllArticles(List<Article> articles) {
        try {
            return produtoRepository.insertAllArticles(articles);
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro ao inserir produtos!",
                    e.getMessage());
        }
    }
}
