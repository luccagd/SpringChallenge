package com.example.springchallenge.dto;

import com.example.springchallenge.entity.Purchase;
import com.example.springchallenge.entity.Article;
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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long idCart;

    public static BigDecimal sum(Purchase purchase){
        double sum = 0;
        for (Article article : purchase.getArticles()) {
            sum += (article.getPrice().doubleValue() * article.getQuantity().doubleValue());
        }
        return new BigDecimal(sum).setScale(2, RoundingMode.HALF_EVEN);
    }

    public static ArticlePurchaseResponse toResponse(Purchase purchase) {
        ArticlePurchaseResponse response = ArticlePurchaseResponse.builder()
                                                                  .id(purchase.getId())
                                                                  .idCart(purchase.getIdCart())
                                                                  .ticket(ArticlePurchaseRequest.toRequest(purchase))
                                                                  .total(sum(purchase))
                                                                  .build();
        return response;
    }

    public static Purchase toEntity(ArticlePurchaseResponse articlePurchaseResponse) {
        Purchase purchase = Purchase.builder()
                              .id(articlePurchaseResponse.ticket.getId())
                              .idCart(articlePurchaseResponse.ticket.getIdCart())
                              .articles(articlePurchaseResponse.ticket.getArticles())
                              .build();
        return purchase;
    }

    public static Purchase toEntity(ArticlePurchaseRequest articlePurchaseRequest){
        Purchase purchase = Purchase.builder()
                              .id(articlePurchaseRequest.getId())
                              .idCart(articlePurchaseRequest.getIdCart())
                              .articles(articlePurchaseRequest.getArticles())
                              .build();
        return purchase;
    }

    public static List<ArticlePurchaseResponse> listEntityToResponse(List<Purchase> purchases) {
        return purchases.stream().map(ArticlePurchaseResponse::toResponse).collect(Collectors.toList());
    }

    public static List<Purchase> listResponseToEntity(List<ArticlePurchaseResponse> response) {
        return response.stream().map(ArticlePurchaseResponse::toEntity).collect(Collectors.toList());
    }
}
