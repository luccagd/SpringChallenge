package com.example.springchallenge.repository;

import com.example.springchallenge.entity.Compra;
import com.example.springchallenge.repository.interfaces.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CompraRepository implements BaseRepository<Compra, Long> {

    List<Compra> compras = new ArrayList<>();

    @Override
    public void save(Compra compra) {
        compra.setId((long) compras.size() + 1);
        compras.add(compra);
    }

    @Override
    public List<Compra> getAll() {
        return compras;
    }

    @Override
    public Compra getById(Long id) {
        return compras.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }
}
