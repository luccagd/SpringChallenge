package com.example.springchallenge.repository;

import com.example.springchallenge.entity.Produto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProdutoRepository {
    private ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    private final String PATH = "src/main/java/com/example/springchallenge/database/database.json";
    private List<Produto> produtos = new ArrayList<>(loadAllFromFile());


    public List<Produto> getAll() {
        return new ArrayList<>(produtos);
    }

    public Produto getById(Long productId) {

        //COLOCAR EXCEPTION AQUI PARA O CASO DE NÃO HAVER ID
        Produto produto = produtos.stream().filter(x ->
                x.getProductId().equals(productId))
                .findFirst().orElse(new Produto());
        produto.setPrice(new BigDecimal(String.valueOf(produto.getPrice())).setScale(2, RoundingMode.HALF_EVEN));
        return produto;
    }

    public List<Produto> insertAllArticles(List<Produto> produtos) {
        for (Produto produto : produtos) {
            produto.setProductId((long) this.produtos.size() + 1);
            this.produtos.add(produto);
        }

        updateFile();
        return produtos;
    }

    private void updateFile() {
        try {
            objectMapper.writeValue(new File(PATH), this.produtos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Produto> loadAllFromFile() {
        List<Produto> produtos = new ArrayList<>();

        try {
            File file = new File(PATH);
            FileInputStream fileInputStream = new FileInputStream(file);
            produtos = Arrays.asList(objectMapper.readValue(fileInputStream, Produto[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return produtos;
    }

}
