package com.example.springchallenge.usecases.insertArticles.dto;

import com.example.springchallenge.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class InsertArticlesResponseDTO {
    private Long productId;

    private String name;

    private Integer quantity;

    private static InsertArticlesResponseDTO toResponseDTO(Article article) {
        return InsertArticlesResponseDTO.builder()
                .productId(article.getProductId())
                .name(article.getName())
                .quantity(article.getQuantity())
                .build();
    }

    public static List<InsertArticlesResponseDTO> entityListToDTO(List<Article> articles) {
        List<InsertArticlesResponseDTO> articlesResponseDTO = new ArrayList<>();
        for (Article article : articles) {
            articlesResponseDTO.add(toResponseDTO(article));
        }

        return articlesResponseDTO;
    }
}
