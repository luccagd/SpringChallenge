package com.example.springchallenge.dto;

import com.example.springchallenge.entity.Purchase;
import com.example.springchallenge.entity.Article;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ArticlePurchaseRequest {
    private Long id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long idCart;
    private List<Article> articles = new ArrayList<>();

    public static Purchase toEntity(ArticlePurchaseRequest request) {
        Purchase purchase = Purchase.builder()
                .id(request.getId())
                .idCart(request.getIdCart())
                .articles(request.getArticles())
                .build();
        return purchase;
    }

    public static ArticlePurchaseRequest toRequest(Purchase purchase) {
        ArticlePurchaseRequest request = ArticlePurchaseRequest.builder()
                                                               .id(purchase.getId())
                                                               .idCart(purchase.getIdCart())
                                                               .articles(purchase.getArticles())
                                                               .build();
        return request;
    }
}
