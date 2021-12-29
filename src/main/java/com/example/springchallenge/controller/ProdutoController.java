package com.example.springchallenge.controller;

import java.io.IOException;
import java.util.List;

import com.example.springchallenge.usecases.insertArticles.dto.ProdutoInsertDTO;
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
	
	@GetMapping(value = "/articles",params = {"category"})
	public ResponseEntity<List<ProdutoInsertDTO>> getByCategory(@RequestParam String category) {
		return ResponseEntity.ok().body(ProdutoInsertDTO.entityListToDTO(produtoService.listaPorCategoria(category)));
	}


}
