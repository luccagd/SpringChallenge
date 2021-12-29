package com.example.springchallenge.usecases.insertArticles.dto;

import com.example.springchallenge.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProdutoInsertDTO {


    private Long productId;

    private String name;

    private String category;

    private String brand;

    private BigDecimal price;

    private Integer quantity;

    private Boolean freeShipping;

    private String prestige;

    private static Produto toEntity(ProdutoInsertDTO produtoDTO) {
        return Produto.builder()
                .productId(produtoDTO.getProductId())
                .name(produtoDTO.getName())
                .category(produtoDTO.getCategory())
                .brand(produtoDTO.getBrand())
                .price(produtoDTO.getPrice())
                .quantity(produtoDTO.getQuantity())
                .freeShipping(produtoDTO.getFreeShipping())
                .prestige(produtoDTO.getPrestige())
                .build();
    }

    private static ProdutoInsertDTO toDTO(Produto produto) {
        return ProdutoInsertDTO.builder()
                .productId(produto.getProductId())
                .name(produto.getName())
                .category(produto.getCategory())
                .brand(produto.getBrand())
                .price(produto.getPrice())
                .quantity(produto.getQuantity())
                .freeShipping(produto.getFreeShipping())
                .prestige(produto.getPrestige())
                .build();
    }

    public static List<ProdutoInsertDTO> entityListToDTO(List<Produto> produtos) {
        List<ProdutoInsertDTO> produtosDTO = new ArrayList<>();
        for (Produto produto : produtos) {
            produtosDTO.add(toDTO(produto));
        }

        return produtosDTO;
    }

    public static List<Produto> dtoListToEntity(List<ProdutoInsertDTO> produtosDTO) {
        List<Produto> produtos = new ArrayList<>();
        for (ProdutoInsertDTO produtoDTO : produtosDTO) {
            produtos.add(toEntity(produtoDTO));
        }

        return produtos;
    }
}
