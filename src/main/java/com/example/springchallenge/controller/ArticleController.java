package com.example.springchallenge.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springchallenge.helper.FilterHelper;

import com.example.springchallenge.service.ArticleService;

@RestController
@RequestMapping
public class ArticleController {

    @Autowired
    private ArticleService service;

    @GetMapping(path = "/articles")
    public ResponseEntity<Object> getFilteredArticles(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "brand", required = false) String brand,
            @RequestParam(value = "price", required = false) BigDecimal price,
            @RequestParam(value = "freeShipping", required = false) Boolean freeShipping,
            @RequestParam(value = "prestige", required = false) String prestige,
            @RequestParam(value = "order", required = false) String order) {
        FilterHelper filterHelper = new FilterHelper(name, category, brand, price, freeShipping, prestige, order);

        return new ResponseEntity<>(service.getFilteredArticles(filterHelper), HttpStatus.OK);
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<Object> getArticleById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getArticleById(id), HttpStatus.OK);
    }
}
