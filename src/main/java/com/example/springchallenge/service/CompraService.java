package com.example.springchallenge.service;

import com.example.springchallenge.dto.ArticlePurchaseRequest;
import com.example.springchallenge.entity.Compra;
import com.example.springchallenge.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public Compra save(ArticlePurchaseRequest request) {
        Compra compra = ArticlePurchaseRequest.toEntity(request);
        return compraRepository.save(compra);
    }

    public List<Compra> getAll() {
        return compraRepository.getAll();
    }

    public Compra getById(Long id) {
        return compraRepository.getById(id);
    }
}
