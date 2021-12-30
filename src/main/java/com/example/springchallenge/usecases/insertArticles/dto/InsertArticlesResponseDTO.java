package com.example.springchallenge.usecases.insertArticles.dto;

import com.example.springchallenge.entity.Produto;
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

    private static InsertArticlesResponseDTO toResponseDTO(Produto produto) {
        return InsertArticlesResponseDTO.builder()
                .productId(produto.getProductId())
                .name(produto.getName())
                .quantity(produto.getQuantity())
                .build();
    }

    public static List<InsertArticlesResponseDTO> entityListToDTO(List<Produto> produtos) {
        List<InsertArticlesResponseDTO> articlesResponseDTO = new ArrayList<>();
        for (Produto produto : produtos) {
            articlesResponseDTO.add(toResponseDTO(produto));
        }

        return articlesResponseDTO;
    }
}
