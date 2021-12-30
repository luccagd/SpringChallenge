package com.example.springchallenge.dto;

import com.example.springchallenge.entity.Cart;
import com.example.springchallenge.entity.Purchase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CartDTO {
    private Long idCart;
    private List<ArticlePurchaseResponse> purchaseList;
    private BigDecimal total;

    public static BigDecimal sum(List<Purchase> purchaseList) {
        List<ArticlePurchaseResponse> listResponse = ArticlePurchaseResponse.listEntityToResponse(purchaseList);
        return new BigDecimal(listResponse.stream().mapToDouble(purchase -> purchase.getTotal().doubleValue()).sum()).setScale(2, RoundingMode.HALF_EVEN);
    }

    public static CartDTO toDTO(Cart cart){
        List<ArticlePurchaseResponse> listResponse = ArticlePurchaseResponse.listEntityToResponse(cart.getPurchaseList());
        CartDTO dto = CartDTO.builder()
                             .idCart(cart.getIdCart())
                             .purchaseList(listResponse)
                             .total(sum(cart.getPurchaseList()))
                             .build();
        return dto;
    }

    public static List<CartDTO> listEntityToDTO(List<Cart> cartList){
         return cartList.stream().map(CartDTO::toDTO).collect(Collectors.toList());
    }
}

