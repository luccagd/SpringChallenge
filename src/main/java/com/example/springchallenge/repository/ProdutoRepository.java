package com.example.springchallenge.repository;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.springchallenge.entity.Article;
import com.example.springchallenge.helper.DatabaseHelper;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class ProdutoRepository {
    private ObjectMapper objectMapper = DatabaseHelper.getObjectMapper();
    private String PATH = DatabaseHelper.getDatabasePath();
    private List<Article> products = new ArrayList<>(DatabaseHelper.getDatabaseArticle());

    public List<Article> insertAllArticles(List<Article> products) {
        for (Article product : products) {
            product.setProductId((long) this.products.size() + 1);

            this.products.add(product);
        }

        updateFile();

        return products;
    }

    public void updateFile() {
        try {
            objectMapper.writeValue(new File(PATH), this.products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Article> getAll() {
        return this.products;
    }

    public Article getById(Long productId) {
        Article product = this.products.stream()
                .filter(p -> p.getProductId().equals(productId))
                .findFirst()
                .orElse(new Article());

        product.setPrice(new BigDecimal(String.valueOf(product.getPrice())).setScale(2, RoundingMode.HALF_EVEN));

        return product;
    }

    public List<Article> getByCategory(String category) {
        return this.products.stream()
                .filter(product -> product.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public List<Article> getByNameAndCategory(String name, String category) {
        return this.products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<Article> getByNameAndBrand(String name, String brand) {
        return this.products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .filter(product -> product.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    public List<Article> getByNameAndPrice(String name, BigDecimal price) {
        return this.products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .filter(product -> product.getPrice().equals(price))
                .collect(Collectors.toList());
    }

    public List<Article> getByNameAndFreeShipping(String name, Boolean freeShipping) {
        return this.products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .filter(product -> product.getFreeShipping().equals(freeShipping))
                .collect(Collectors.toList());
    }

    public List<Article> getByNameAndPrestige(String name, String prestige) {
        return this.products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .filter(product -> product.getPrestige().equalsIgnoreCase(prestige))
                .collect(Collectors.toList());
    }

    public List<Article> getByCategoryAndBrand(String category, String brand) {
        return this.products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .filter(product -> product.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    public List<Article> getByCategoryAndPrice(String category, BigDecimal price) {
        return this.products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .filter(product -> product.getPrice().equals(price))
                .collect(Collectors.toList());
    }

    public List<Article> getByCategoryAndFreeShipping(String category, Boolean freeShipping) {
        return this.products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .filter(product -> product.getFreeShipping().equals(freeShipping))
                .collect(Collectors.toList());
    }

    public List<Article> getByCategoryAndPrestige(String category, String prestige) {
        return this.products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .filter(product -> product.getPrestige().equalsIgnoreCase(prestige))
                .collect(Collectors.toList());
    }

    public List<Article> getByBrandAndPrice(String brand, BigDecimal price) {
        return this.products.stream()
                .filter(product -> product.getBrand().equalsIgnoreCase(brand))
                .filter(product -> product.getPrice().equals(price))
                .collect(Collectors.toList());
    }

    public List<Article> getByBrandAndFreeShipping(String brand, Boolean freeShipping) {
        return this.products.stream()
                .filter(product -> product.getBrand().equalsIgnoreCase(brand))
                .filter(product -> product.getFreeShipping().equals(freeShipping))
                .collect(Collectors.toList());
    }

    public List<Article> getByBrandAndPrestige(String brand, String prestige) {
        return this.products.stream()
                .filter(product -> product.getBrand().equalsIgnoreCase(brand))
                .filter(product -> product.getPrestige().equalsIgnoreCase(prestige))
                .collect(Collectors.toList());
    }

    public List<Article> getByPriceAndFreeShipping(BigDecimal price, Boolean freeShipping) {
        return this.products.stream()
                .filter(product -> product.getPrice().equals(price))
                .filter(product -> product.getFreeShipping().equals(freeShipping))
                .collect(Collectors.toList());
    }

    public List<Article> getByPriceAndPrestige(BigDecimal price, String prestige) {
        return this.products.stream()
                .filter(product -> product.getPrice().equals(price))
                .filter(product -> product.getPrestige().equalsIgnoreCase(prestige))
                .collect(Collectors.toList());
    }

    public List<Article> getByFreeShippingAndPrestige(Boolean freeShipping, String prestige) {
        return this.products.stream()
                .filter(product -> product.getFreeShipping().equals(freeShipping))
                .filter(produto -> produto.getPrestige().equalsIgnoreCase(prestige))
                .collect(Collectors.toList());
    }
}
