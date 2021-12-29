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

    public List<Produto> getProductsByCategoryAndPrestige(String category, String prestige) {
        return repository.getProductsByCategoryAndPrestige(category, prestige);
    }

    public List<Produto> getProductsByBrandAndPrice(String brand, BigDecimal price) {
        return repository.getProductsByBrandAndPrice(brand, price);
    }

    public List<Produto> getProductsByBrandAndFreeShipping(String brand, Boolean freeShipping) {
        return repository.getProductsByBrandAndFreeShipping(brand, freeShipping);
    }

    public List<Produto> getProductsByBrandAndPrestige(String brand, String prestige) {
        return repository.getProductsByBrandAndPrestige(brand, prestige);
    }
    
    public List<Produto> getProductsByPriceAndFreeShipping(BigDecimal price, Boolean freeShipping) {
        return repository.getProductsByPriceAndFreeShipping(price, freeShipping);
    }

    public List<Produto> getProductsByPriceAndPrestige(BigDecimal price, String prestige) {
        return repository.getProductsByPriceAndPrestige(price, prestige);
    }

    public List<Produto> getProductsByFreeShippingAndPrestige(Boolean freeShipping, String prestige) {
        return repository.getProductsByFreeShippingAndPrestige(freeShipping, prestige);
    }
}
