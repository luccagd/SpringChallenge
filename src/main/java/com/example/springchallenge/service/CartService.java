package com.example.springchallenge.service;

import com.example.springchallenge.entity.Cart;
import com.example.springchallenge.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {


    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getAll(){
        return cartRepository.getAll();
    }

    public Cart getById(Long id){
        return cartRepository.getById(id);
    }

    public void save(Cart cart){
        cartRepository.save(cart);
    }
}
