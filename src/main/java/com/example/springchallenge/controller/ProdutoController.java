package com.example.springchallenge.controller;

import java.math.BigDecimal;
import java.util.List;

import com.example.springchallenge.usecases.insertArticles.dto.ProdutoInsertDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springchallenge.entity.Produto;
import com.example.springchallenge.service.ProdutoService;

@RestController
@RequestMapping
public class ProdutoController {


    @Autowired
    private ProdutoService service;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping(path = "/articles", params = { "name", "category" })
    public ResponseEntity<Object> getProductsByNameAndCategory(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "category") String category) {
        List<Produto> produtos = this.service.getProductsByNameAndCategory(name, category);

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }
    @GetMapping(value = "/articles",params = {"category"})
    public ResponseEntity<List<ProdutoInsertDTO>> getByCategory(@RequestParam String category) {
        return ResponseEntity.ok().body(ProdutoInsertDTO.entityListToDTO(service.getByCategory(category)));
    }

    @GetMapping(path = "/articles", params = { "name", "brand" })
    public ResponseEntity<Object> getProductsByNameAndBrand(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "brand") String brand) {
        List<Produto> produtos = this.service.getProductsByNameAndBrand(name, brand);

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping(path = "/articles", params = { "name", "price" })
    public ResponseEntity<Object> getProductsByNameAndPrice(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "price") BigDecimal price) {
        List<Produto> produtos = this.service.getProductsByNameAndPrice(name, price);

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping(path = "/articles", params = { "name", "freeShipping" })
    public ResponseEntity<Object> getProductsByNameAndFreeShipping(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "freeShipping") Boolean freeShipping) {

        List<Produto> produtos = this.service.getProductsByNameAndFreeShipping(name, freeShipping);

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping(path = "/articles", params = { "name", "prestige" })
    public ResponseEntity<Object> getProductsByNameAndPrestige(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "prestige") String prestige) {
        List<Produto> produtos = this.service.getProductsByNameAndPrestige(name, prestige);

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping(path = "/articles", params = { "category", "brand" })
    public ResponseEntity<Object> getProductsByCategoryAndBrand(
            @RequestParam(value = "category") String category,
            @RequestParam(value = "brand") String brand) {
        List<Produto> produtos = this.service.getProductsByCategoryAndBrand(category, brand);

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping(path = "/articles", params = { "category", "price" })
    public ResponseEntity<Object> getProductsByCategoryAndPrice(
            @RequestParam(value = "category") String category,
            @RequestParam(value = "price") BigDecimal price) {
        List<Produto> produtos = this.service.getProductsByCategoryAndPrice(category, price);

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping(path = "/articles", params = { "category", "freeShipping" })
    public ResponseEntity<Object> getProductsByCategoryAndFreeShipping(
            @RequestParam(value = "category") String category,
            @RequestParam(value = "freeShipping") Boolean freeShipping,
            @RequestParam(value = "order", required = false) Integer order) {
        List<Produto> produtos = this.service.getProductsByCategoryAndFreeShipping(category, freeShipping, order);

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping(path = "/articles", params = { "category", "prestige" })
    public ResponseEntity<Object> getProductsByCategoryAndPrestige(
            @RequestParam(value = "category") String category,
            @RequestParam(value = "prestige") String prestige) {
        List<Produto> produtos = this.service.getProductsByCategoryAndPrestige(category, prestige);

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping(path = "/articles", params = { "brand", "price" })
    public ResponseEntity<Object> getProductsByBrandAndPrice(
            @RequestParam(value = "brand") String brand,
            @RequestParam(value = "price") BigDecimal price) {
        List<Produto> produtos = this.service.getProductsByBrandAndPrice(brand, price);

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping(path = "/articles", params = { "brand", "freeShipping" })
    public ResponseEntity<Object> getProductsByBrandAndFreeShipping(
            @RequestParam(value = "brand") String brand,
            @RequestParam(value = "freeShipping") Boolean freeShipping) {
        List<Produto> produtos = this.service.getProductsByBrandAndFreeShipping(brand, freeShipping);

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping(path = "/articles", params = { "brand", "prestige" })
    public ResponseEntity<Object> getProductsByBrandAndPrestige(
            @RequestParam(value = "brand") String brand,
            @RequestParam(value = "prestige") String prestige) {
        List<Produto> produtos = this.service.getProductsByBrandAndPrestige(brand, prestige);

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping(path = "/articles", params = { "price", "freeShipping" })
    public ResponseEntity<Object> getProductsByPriceAndFreeShipping(
            @RequestParam(value = "price") BigDecimal price,
            @RequestParam(value = "freeShipping") Boolean freeShipping) {
        List<Produto> produtos = this.service.getProductsByPriceAndFreeShipping(price, freeShipping);

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping(path = "/articles", params = { "price", "prestige" })
    public ResponseEntity<Object> getProductsByPriceAndPrestige(
            @RequestParam(value = "price") BigDecimal price,
            @RequestParam(value = "prestige") String prestige) {
        List<Produto> produtos = this.service.getProductsByPriceAndPrestige(price, prestige);

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping(path = "/articles", params = { "freeShipping", "prestige" })
    public ResponseEntity<Object> getProductsByFreeShippingAndPrestige(
            @RequestParam(value = "freeShipping") Boolean freeShipping,
            @RequestParam(value = "prestige") String prestige) {
        List<Produto> produtos = this.service.getProductsByFreeShippingAndPrestige(freeShipping, prestige);

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }
}
