package com.example.springchallenge.controller;

import com.example.springchallenge.dto.ArticlePurchaseRequest;
import com.example.springchallenge.dto.ArticlePurchaseResponse;
import com.example.springchallenge.entity.Compra;
import com.example.springchallenge.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping("/purchase-request/ping")
    public String pong() {
        return "pong";
    }

    @GetMapping("/purchase-request/get/all")
    public List<ArticlePurchaseResponse> getAll() {
        return ArticlePurchaseResponse.listEntityToResponse(compraService.getAll());
    }

    @GetMapping("/purchase-request/get/{id}")
    public ResponseEntity<ArticlePurchaseResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ArticlePurchaseResponse.toResponse(compraService.getById(id)));
    }

    @PostMapping("/purchase-request")
    public ResponseEntity<ArticlePurchaseResponse> cadastra(@RequestBody ArticlePurchaseRequest request, UriComponentsBuilder uriComponentsBuilder) {
        ArticlePurchaseResponse response = ArticlePurchaseResponse.toResponse(compraService.save(request));
        return ResponseEntity.created(null).body(response);
    }
}
