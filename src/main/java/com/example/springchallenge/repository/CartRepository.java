package com.example.springchallenge.repository;

import com.example.springchallenge.entity.Cart;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CartRepository {

    List<Cart> cartList = new ArrayList();

    public List<Cart> getAll(){
        return cartList;
    }

    public Cart getById(Long id){
        return cartList.stream().filter(cart -> cart.getIdCart().equals(id)).findAny().orElse(new Cart());
    }

    public void save(Cart cart){
        cart.setIdCart((long) cartList.size() + 1);
        cartList.add(cart);
    }
}
