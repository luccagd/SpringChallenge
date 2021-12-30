package com.example.springchallenge.service;

import com.example.springchallenge.dto.ArticlePurchaseRequest;
import com.example.springchallenge.entity.Compra;
import com.example.springchallenge.exception.AppErrorException;
import com.example.springchallenge.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository repository;

    public Compra save(ArticlePurchaseRequest request) {
        try {
            Compra compra = ArticlePurchaseRequest.toEntity(request);

            return repository.save(compra);
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro ao cadastrar compra!",
                    e.getMessage());
        }
    }

    public List<Compra> getAll() {
        try {
            return repository.getAll();
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Não foi possível listar todas as compras!",
                    e.getMessage());
        }
    }

    public Compra getById(Long id) {
        try {
            return repository.getById(id);
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Não foi possível listar a compra!",
                    e.getMessage());
        }
    }
}
