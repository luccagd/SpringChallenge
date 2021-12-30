package com.example.springchallenge.controller;

import com.example.springchallenge.dto.CartDTO;
import com.example.springchallenge.entity.Cart;
import com.example.springchallenge.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/get/all")
    public ResponseEntity<List<CartDTO>> getAll(){
        return ResponseEntity.ok(CartDTO.listEntityToDTO(cartService.getAll()));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CartDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(CartDTO.toDTO(cartService.getById(id)));
    }

    @PostMapping("/post")
    public ResponseEntity<CartDTO> save(@RequestBody Cart cart){
        cartService.save(cart);
        return ResponseEntity.created(null).body(CartDTO.toDTO(cart));
    }

    @GetMapping("/ping")
    public String pong(){
        return "pong";
    }

}
