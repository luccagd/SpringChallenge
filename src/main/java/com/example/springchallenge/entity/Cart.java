package com.example.springchallenge.entity;

import com.example.springchallenge.dto.ArticlePurchaseResponse;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class Cart {
    private Long idCart;
    private List<Compra> purchaseList;

    public void addPurchase(Compra compra) {
        purchaseList.add(compra);
    }
}
