package com.example.springchallenge.controller;

import com.example.springchallenge.dto.ArticlePurchaseRequest;
import com.example.springchallenge.dto.ArticlePurchaseResponse;
import com.example.springchallenge.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/purchase-request")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/get/all")
    public List<ArticlePurchaseResponse> getAll() {
        return ArticlePurchaseResponse.listEntityToResponse(purchaseService.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ArticlePurchaseResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ArticlePurchaseResponse.toResponse(purchaseService.getById(id)));
    }

    @PostMapping
    public ResponseEntity<ArticlePurchaseResponse> createPurchase(@RequestBody ArticlePurchaseRequest request,
            UriComponentsBuilder uriComponentsBuilder) {
        ArticlePurchaseResponse response = ArticlePurchaseResponse.toResponse(purchaseService.save(request));

        URI uri = uriComponentsBuilder.path("/purchase-request/get/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }
}
