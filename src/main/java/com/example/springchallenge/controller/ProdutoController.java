package com.example.springchallenge.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springchallenge.dto.ProdutoDTO;
import com.example.springchallenge.service.ProdutoService;

@RestController
@RequestMapping()
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/ping")
	public String ping() {
		return "pong";
	}

	@GetMapping("/articles")
	public ResponseEntity<List<ProdutoDTO>> getProductsByHighestPrice(@RequestParam String category, Boolean freeShipping, Integer order) throws IOException {
		return ResponseEntity.ok(ProdutoDTO.converte(
				this.produtoService.getProductsByCategoryAndFreeShippingAndOrder(category, freeShipping, order)));
	}

}
