package com.example.springchallenge.usecases.insertArticles.controller;

import com.example.springchallenge.entity.Article;
import com.example.springchallenge.usecases.insertArticles.dto.InsertArticlesResponseDTO;
import com.example.springchallenge.usecases.insertArticles.dto.InsertArticleRequestDTO;
import com.example.springchallenge.usecases.insertArticles.service.InsertArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class InsertArticlesController {

    @Autowired
    private InsertArticlesService service;

    @GetMapping("/list-articles-request")
    public ResponseEntity<List<InsertArticleRequestDTO>> getAll() {
        List<Article> articles = service.getAll();

        return ResponseEntity.ok().body(InsertArticleRequestDTO.entityListToDTO(articles));
    }

    @PostMapping("/insert-articles-request")
    public ResponseEntity<List<InsertArticlesResponseDTO>> insertAllArticles(@RequestBody List<InsertArticleRequestDTO> produtosDTO) {
        List<Article> articles = service.insertAllArticles(InsertArticleRequestDTO.dtoListToEntity(produtosDTO));

        return ResponseEntity.ok().body(InsertArticlesResponseDTO.entityListToDTO(articles));
    }
}
