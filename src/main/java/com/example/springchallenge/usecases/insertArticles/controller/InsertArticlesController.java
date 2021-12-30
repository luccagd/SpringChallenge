package com.example.springchallenge.usecases.insertArticles.controller;

import com.example.springchallenge.entity.Produto;
import com.example.springchallenge.usecases.insertArticles.dto.InsertArticlesResponseDTO;
import com.example.springchallenge.usecases.insertArticles.dto.ProdutoInsertDTO;
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
    public ResponseEntity<List<ProdutoInsertDTO>> getAll() {
        List<Produto> produtos = service.getAll();

        return ResponseEntity.ok().body(ProdutoInsertDTO.entityListToDTO(produtos));
    }

    @PostMapping("/insert-articles-request")
    public ResponseEntity<List<InsertArticlesResponseDTO>> insertAllArticles(@RequestBody List<ProdutoInsertDTO> produtosDTO) {
        List<Produto> produtos = service.insertAllArticles(ProdutoInsertDTO.dtoListToEntity(produtosDTO));

        return ResponseEntity.ok().body(InsertArticlesResponseDTO.entityListToDTO(produtos));
    }
}
