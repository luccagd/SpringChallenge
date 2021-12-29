package com.example.springchallenge.repository;

import com.example.springchallenge.entity.Produto;
import com.example.springchallenge.repository.interfaces.BaseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProdutoRepository implements BaseRepository<Produto, Long> {
    private ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    private final String PATH = "database.json";
    private List<Produto> produtos = new ArrayList<>(loadAllFromFile());

    @Override
    public void save(Produto produto) {

    }

    @Override
    public List<Produto> getAll() {
        return new ArrayList<>(produtos);
    }

    @Override
    public Produto getById(Long id) {
        return null;
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
