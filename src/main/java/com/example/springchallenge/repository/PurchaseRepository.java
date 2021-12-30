package com.example.springchallenge.repository;

import com.example.springchallenge.entity.Cart;
import com.example.springchallenge.entity.Purchase;
import com.example.springchallenge.entity.Article;
import com.example.springchallenge.exception.AppErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PurchaseRepository {

    List<Purchase> purchases = new ArrayList<>();

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CartRepository cartRepository;

    public Purchase save(Purchase purchase) {
            if(!cartRepository.getById(purchase.getIdCart()).equals(new Cart())){
                purchase.setId((long) purchases.size() + 1);
                purchase.setArticles(updateProduct(purchase));
                purchases.add(purchase);
                Cart cart = cartRepository.getById(purchase.getIdCart());
                cart.addPurchase(purchase);
            return purchase;
        }else {
            return null;
        }
    }

    public List<Purchase> getAll() {
        return purchases;
    }

    public Purchase getById(Long id) {
        return purchases.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(new Purchase());
    }

    public List<Article> updateProduct(Purchase purchase){
        List<Article> newArticles = new ArrayList<>();
        purchase.getArticles().forEach(produto -> {
            Article articleInStock = produtoRepository.getById(produto.getProductId());

            if (articleInStock.getQuantity() < produto.getQuantity()) {
                String mensagem = (articleInStock.getQuantity() == 0)
                        ? "Não possuimos o produto " + articleInStock.getName() + " em nossos estoques!"
                        : "Possuimos apenas " + articleInStock.getQuantity() + " unidade(s) do produto " + articleInStock.getName() + " em nossos estoques!";

                throw new AppErrorException(HttpStatus.NOT_ACCEPTABLE, mensagem);
            }
            articleInStock.setQuantity(articleInStock.getQuantity() - produto.getQuantity());

            Article newArticle = Article.builder()
                    .productId(articleInStock.getProductId())
                    .name(articleInStock.getName())
                    .category(articleInStock.getCategory())
                    .brand(articleInStock.getBrand())
                    .price(articleInStock.getPrice())
                    .quantity(produto.getQuantity())
                    .freeShipping(articleInStock.getFreeShipping())
                    .prestige(articleInStock.getPrestige())
                    .build();

            newArticles.add(newArticle);
        });

        produtoRepository.updateFile();
        return newArticles;
    }
}
