package com.example.springchallenge.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.springchallenge.entity.Produto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Component
public class ProdutoRepository {
	private final String PATH = "database.json";
	private ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	private List<Produto> produtos = new ArrayList<>();

	public List<Produto> retornaProdutos() throws IOException {
		File file = new File(PATH);
		FileInputStream is = new FileInputStream(file);
		produtos = Arrays.asList(objectMapper.readValue(is, Produto[].class));
		return produtos;

	}

	public List<Produto> getProductsByCategoryAndFreeShippingAndOrder(String categoria, Boolean freeShipping, int order) throws IOException {
		return retornaProdutos();

	}

}
