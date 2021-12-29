package com.example.springchallenge.service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springchallenge.entity.Produto;
import com.example.springchallenge.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> getProductsByCategoryAndFreeShippingAndOrder(String categoria, Boolean freeShipping, int order)
			throws IOException {

		List<Produto> list = produtoRepository
				.getProductsByCategoryAndFreeShippingAndOrder(categoria, freeShipping, order).stream()
				.filter(produto -> produto.getCategory().equals(categoria))
				.filter(produto -> produto.getFreeShipping().equals(freeShipping)).collect(Collectors.toList());

		if (order == 2) {

			Collections.sort(list, (Produto a, Produto b) -> b.compareByPrice(a));
		} else {
			Collections.sort(list, (Produto a, Produto b) -> a.compareByPrice(b));
		}
		return list;
	}

	public List<Produto> listaPorCategoria(String categoria)
	{
		return produtoRepository.getByCategory(categoria);
	}

}
