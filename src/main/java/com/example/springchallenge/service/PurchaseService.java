package com.example.springchallenge.service;

import com.example.springchallenge.dto.ArticlePurchaseRequest;
import com.example.springchallenge.entity.Purchase;
import com.example.springchallenge.exception.AppErrorException;
import com.example.springchallenge.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository repository;

    public Purchase save(ArticlePurchaseRequest request) {
        try {
            Purchase purchase = ArticlePurchaseRequest.toEntity(request);

            return repository.save(purchase);
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro ao cadastrar compra!",
                    e.getMessage());
        }
    }

    public List<Purchase> getAll() {
        try {
            return repository.getAll();
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Não foi possível listar todas as compras!",
                    e.getMessage());
        }
    }

    public Purchase getById(Long id) {
        try {
            return repository.getById(id);
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Não foi possível listar a compra!",
                    e.getMessage());
        }
    }
}
