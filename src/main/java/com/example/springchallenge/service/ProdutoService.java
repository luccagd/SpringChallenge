package com.example.springchallenge.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.springchallenge.entity.Produto;
import com.example.springchallenge.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> getProductsByNameAndCategory(String name, String category) {
        return repository.getProductsByNameAndCategory(name, category);
    }

    public List<Produto> getProductsByNameAndBrand(String name, String brand) {
        return repository.getProductsByNameAndBrand(name, brand);
    }

    public List<Produto> getProductsByNameAndPrice(String name, BigDecimal price) {
        return repository.getProductsByNameAndPrice(name, price);
    }

    public List<Produto> getProductsByNameAndFreeShipping(String name, Boolean freeShipping) {
        return repository.getProductsByNameAndFreeShipping(name, freeShipping);
    }

    public List<Produto> getProductsByNameAndPrestige(String name, String prestige) {
        return repository.getProductsByNameAndPrestige(name, prestige);
    }

    public List<Produto> getProductsByCategoryAndBrand(String category, String brand) {
        return repository.getProductsByCategoryAndBrand(category, brand);
    }

    public List<Produto> getProductsByCategoryAndPrice(String category, BigDecimal price) {
        return repository.getProductsByCategoryAndPrice(category, price);
    }

    public List<Produto> getProductsByCategoryAndFreeShipping(String category, Boolean freeShipping) {
        return repository.getProductsByCategoryAndFreeShipping(category, freeShipping);
    }
}
