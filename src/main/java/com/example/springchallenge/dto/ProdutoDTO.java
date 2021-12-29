package com.example.springchallenge.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.example.springchallenge.entity.Produto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProdutoDTO {

	private String name;

	private String category;

	private String brand;

	private BigDecimal price;

	private Integer quantity;

	private Boolean freeShipping;

	private String prestige;

	public static Produto converte(ProdutoDTO dto) {
		Produto produto = Produto.builder().name(dto.getName()).category(dto.getCategory()).brand(dto.getBrand())
				.price(dto.getPrice()).quantity(dto.getQuantity()).freeShipping(dto.getFreeShipping())
				.prestige(dto.getPrestige()).build();
		return produto;
	}

	public static ProdutoDTO converte(Produto produto) {
		return ProdutoDTO.builder().name(produto.getName()).category(produto.getCategory()).brand(produto.getBrand())
				.price(produto.getPrice()).quantity(produto.getQuantity()).freeShipping(produto.getFreeShipping())
				.prestige(produto.getPrestige()).build();
	}

	public static List<ProdutoDTO> converte(List<Produto> produtos) {
		return produtos.stream().map(u -> converte(u)).collect(Collectors.toList());
	}
}
