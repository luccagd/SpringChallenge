package com.example.springchallenge.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Cart {
    private Long idCart;
    private List<Purchase> purchaseList;

    public void addPurchase(Purchase purchase) {
        purchaseList.add(purchase);
    }
}
