package com.example.springchallenge.service;

import com.example.springchallenge.entity.Cart;
import com.example.springchallenge.exception.AppErrorException;
import com.example.springchallenge.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        try {
            return cartRepository.getById(id);
        }  catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Não foi encontrada uma compra para o id indicado!",
                    e.getMessage());
        }
    }

    public void save(Cart cart){
        cartRepository.save(cart);
    }
}
