package com.example.springchallenge.dto;

import com.example.springchallenge.entity.Compra;
import com.example.springchallenge.entity.Produto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    public static BigDecimal sum(ArticlePurchaseRequest request){
        Compra compra = toEntity(request);
        return sum(compra);
    }


    public static BigDecimal sum(Compra compra){
        double soma = 0;
        for (Produto produto: compra.getArticles()) {
            soma += (produto.getPrice().doubleValue() * produto.getQuantity().doubleValue());
        }
        return new BigDecimal(soma).setScale(2, RoundingMode.HALF_EVEN);
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
                                                                  .total(sum(compra))
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

    public static Compra toEntity(ArticlePurchaseRequest articlePurchaseRequest){
        Compra compra = Compra.builder()
                .id(articlePurchaseRequest.getId())
                .articles(articlePurchaseRequest.getArticles())
                .build();
        return compra;
    }

    public static List<ArticlePurchaseResponse> listRequestToResponse(List<ArticlePurchaseRequest> requests){
        return requests.stream().map(x -> toResponse(x)).collect(Collectors.toList());
    }

    public static List<ArticlePurchaseResponse> listEntityToResponse(List<Compra> compras) {
        return compras.stream().map(ArticlePurchaseResponse::toResponse).collect(Collectors.toList());
    }
}
