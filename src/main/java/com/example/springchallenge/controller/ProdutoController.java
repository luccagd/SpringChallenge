package com.example.springchallenge.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insert-articles-request")
public class ProdutoController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

}
