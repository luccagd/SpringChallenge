package com.example.springchallenge.repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.springchallenge.entity.Produto;
import com.example.springchallenge.helper.DatabaseHelper;
import com.example.springchallenge.helper.JoinListHelper;
import com.example.springchallenge.repository.interfaces.BaseRepository;

import org.springframework.stereotype.Component;

@Component
public class ProdutoRepository implements BaseRepository<Produto, Long> {

    private List<Produto> produtos = DatabaseHelper.getDatabase();

    @Override
    public void save(Produto t) {
        // TODO Auto-generated method stub
    }

    @Override
    public List<Produto> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Produto getById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Produto> getProductsByNameAndCategory(String name, String category) {
        Stream<Produto> pFiltradosName = this.produtos.stream()
                .filter(produto -> produto.getName().equalsIgnoreCase(name));

        Stream<Produto> pFiltradosCategoria = this.produtos.stream()
                .filter(produto -> produto.getCategory().equalsIgnoreCase(category));

        return JoinListHelper.joinList(pFiltradosName, pFiltradosCategoria);
    }

    public List<Produto> getProductsByNameAndBrand(String name, String brand) {
        Stream<Produto> pFiltradosName = this.produtos.stream()
                .filter(produto -> produto.getName().equalsIgnoreCase(name));

        Stream<Produto> pFiltradosBrand = this.produtos.stream()
                .filter(produto -> produto.getBrand().equalsIgnoreCase(brand));

        return JoinListHelper.joinList(pFiltradosName, pFiltradosBrand);
    }

    public List<Produto> getProductsByNameAndPrice(String name, BigDecimal price) {
        Stream<Produto> pFiltradosName = this.produtos.stream()
                .filter(produto -> produto.getName().equalsIgnoreCase(name));

        Stream<Produto> pFiltradosPrice = this.produtos.stream()
                .filter(produto -> produto.getPrice().equals(price));

        return JoinListHelper.joinList(pFiltradosName, pFiltradosPrice);
    }
}
