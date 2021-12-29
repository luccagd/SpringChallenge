package com.example.springchallenge.repository;

import com.example.springchallenge.entity.Compra;
import com.example.springchallenge.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CompraRepository {
    List<Compra> compras = new ArrayList<>();

    @Autowired
    private ProdutoRepository produtoRepository;

    public Compra save(Compra compra) {
        compra.setId((long) compras.size() + 1);
        compra.setArticles(updateProduct(compra));
        compras.add(compra);
        return compra;
    }

    public List<Compra> getAll() {
        return compras;
    }

    public Compra getById(Long id) {
        return compras.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Produto> updateProduct(Compra compra){
        List<Produto> novosProdutos = new ArrayList<>();
        compra.getArticles().forEach( produto -> {
            Produto novoProduto = produtoRepository.getById(produto.getProductId());
            novoProduto.setQuantity(produto.getQuantity());
            novosProdutos.add(novoProduto);
        });

        return novosProdutos;
    }
}
