package com.example.springchallenge.dto;

import com.example.springchallenge.entity.Compra;
import com.example.springchallenge.entity.Produto;
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private List<Produto> articles = new ArrayList<>();

    public static Compra toEntity(ArticlePurchaseRequest request) {
        Compra compra = Compra.builder()
                .id(request.getId())
                .articles(request.getArticles())
                .build();
        return compra;
    }

    public static ArticlePurchaseRequest toRequest(Compra compra) {
        ArticlePurchaseRequest request = ArticlePurchaseRequest.builder()
                .id(compra.getId())
                .articles(compra.getArticles())
                .build();
        return request;
    }

    public static ArticlePurchaseRequest toRequest(ArticlePurchaseResponse response) {
        ArticlePurchaseRequest request = ArticlePurchaseRequest.builder()
                .id(response.getId())
                .articles(response.getTicket().getArticles())
                .build();
        return request;
    }

    public static List<ArticlePurchaseRequest> listToRequest(List<Compra> compras) {
        return compras.stream().map(ArticlePurchaseRequest::toRequest).collect(Collectors.toList());
    }
}
