package com.example.springchallenge.usecases.insertArticles.service;

import com.example.springchallenge.entity.Produto;
import com.example.springchallenge.exception.AppErrorException;
import com.example.springchallenge.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsertArticlesService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getAll() {
        try {
            return produtoRepository.getAll();
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Não foi possível listar todos os Produtos!",
                    e.getMessage());
        }
    }

    public List<Produto> insertAllArticles(List<Produto> produtos) {
        try {
            return produtoRepository.insertAllArticles(produtos);
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro ao inserir articles!",
                    e.getMessage());
        }
    }
}
