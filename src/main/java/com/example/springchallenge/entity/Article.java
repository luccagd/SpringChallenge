package com.example.springchallenge.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Article {
    private Long productId;

    private String name;

    private String category;

    private String brand;

    private BigDecimal price;

    private Integer quantity;

    private Boolean freeShipping;

    private String prestige;

    public int compareByPrice(Article article) {
        return this.getPrice().compareTo(article.getPrice());
    }
}
