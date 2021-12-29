package com.example.springchallenge.dto;

import com.example.springchallenge.entity.Compra;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ArticlePurchaseResponse {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private ArticlePurchaseRequest ticket;
    private BigDecimal total;

    public static BigDecimal sum(ArticlePurchaseRequest request) {
        double soma = request.getArticles().stream().mapToDouble(produto -> produto.getPrice().doubleValue()).sum();
        return new BigDecimal(soma);
    }

    public static ArticlePurchaseResponse toResponse(ArticlePurchaseRequest articlePurchaseRequest) {
        ArticlePurchaseResponse response = ArticlePurchaseResponse.builder()
                .id(articlePurchaseRequest.getId())
                .ticket(articlePurchaseRequest)
                .total(sum(articlePurchaseRequest))
                .build();
        return response;
    }

    public static ArticlePurchaseResponse toResponse(Compra compra) {
        ArticlePurchaseResponse response = ArticlePurchaseResponse.builder()
                .id(compra.getId())
                .ticket(ArticlePurchaseRequest.toRequest(compra))
                .build();
        return response;
    }

    public static Compra toEntity(ArticlePurchaseResponse articlePurchaseResponse) {
        Compra compra = Compra.builder()
                .id(articlePurchaseResponse.ticket.getId())
                .articles(articlePurchaseResponse.ticket.getArticles())
                .build();
        return compra;
    }

    public static List<ArticlePurchaseResponse> listRequestToResponse(List<ArticlePurchaseRequest> requests) {
        return requests.stream().map(x -> toResponse(x)).collect(Collectors.toList());
    }

    public static List<ArticlePurchaseResponse> listEntityToResponse(List<Compra> compras) {
        return compras.stream().map(ArticlePurchaseResponse::toResponse).collect(Collectors.toList());
    }
}
