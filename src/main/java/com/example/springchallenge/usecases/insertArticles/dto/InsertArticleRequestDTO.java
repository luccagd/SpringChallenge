package com.example.springchallenge.usecases.insertArticles.dto;

import com.example.springchallenge.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class InsertArticleRequestDTO {
    private Long productId;

    private String name;

    private String category;

    private String brand;

    private BigDecimal price;

    private Integer quantity;

    private Boolean freeShipping;

    private String prestige;

    private static Article toEntity(InsertArticleRequestDTO requestDTO) {
        return Article.builder()
                .productId(requestDTO.getProductId())
                .name(requestDTO.getName())
                .category(requestDTO.getCategory())
                .brand(requestDTO.getBrand())
                .price(requestDTO.getPrice())
                .quantity(requestDTO.getQuantity())
                .freeShipping(requestDTO.getFreeShipping())
                .prestige(requestDTO.getPrestige())
                .build();
    }

    private static InsertArticleRequestDTO toDTO(Article article) {
        return InsertArticleRequestDTO.builder()
                .productId(article.getProductId())
                .name(article.getName())
                .category(article.getCategory())
                .brand(article.getBrand())
                .price(article.getPrice())
                .quantity(article.getQuantity())
                .freeShipping(article.getFreeShipping())
                .prestige(article.getPrestige())
                .build();
    }

    public static List<InsertArticleRequestDTO> entityListToDTO(List<Article> articles) {
        List<InsertArticleRequestDTO> requestDTO = new ArrayList<>();
        for (Article article : articles) {
            requestDTO.add(toDTO(article));
        }

        return requestDTO;
    }

    public static List<Article> dtoListToEntity(List<InsertArticleRequestDTO> requestDTOs) {
        List<Article> articles = new ArrayList<>();
        for (InsertArticleRequestDTO requestDTO : requestDTOs) {
            articles.add(toEntity(requestDTO));
        }

        return articles;
    }
}
