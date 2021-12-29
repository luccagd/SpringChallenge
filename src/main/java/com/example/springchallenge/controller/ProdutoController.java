package com.example.springchallenge.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.springchallenge.entity.Produto;
import com.example.springchallenge.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    // List by Name + Category
    @GetMapping(path = "/articles", params = { "name", "category" })
    public ResponseEntity<Object> getProductsByNameAndCategory(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "category") String category) {
        List<Produto> produtos = this.service.getProductsByNameAndCategory(name, category);

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    // List by Name + Brand
    @GetMapping(path = "/articles", params = { "name", "brand" })
    public ResponseEntity<Object> getProductsByNameAndBrand(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "brand") String brand) {
        List<Produto> produtos = this.service.getProductsByNameAndBrand(name, brand);

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    // List by Name + Price
    @GetMapping(path = "/articles", params = { "name", "price" })
    public ResponseEntity<Object> getProductsByNameAndPrice(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "price") BigDecimal price) {
        List<Produto> produtos = this.service.getProductsByNameAndPrice(name, price);

        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    // List by Name + FreeShipping
    @GetMapping(path = "/articles", params = { "name", "freeShipping" })
    public ResponseEntity<Object> getProductsByNameAndFreeShipping(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "freeShipping") Boolean freeShipping) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("freeShipping", freeShipping);

        return new ResponseEntity<>(params, HttpStatus.OK);
    }

    // List by Name + Prestige
    @GetMapping(path = "/articles", params = { "name", "prestige" })
    public ResponseEntity<Object> getProductsByNameAndPrestige(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "prestige") String prestige) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("prestige", prestige);

        return new ResponseEntity<>(params, HttpStatus.OK);
    }

    // List by Category + Brand
    @GetMapping(path = "/articles", params = { "category", "brand" })
    public ResponseEntity<Object> getProductsByCategoryAndBrand(
            @RequestParam(value = "category") String category,
            @RequestParam(value = "brand") String brand) {
        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        params.put("brand", brand);

        return new ResponseEntity<>(params, HttpStatus.OK);
    }

    // List by Category + Price
    @GetMapping(path = "/articles", params = { "category", "price" })
    public ResponseEntity<Object> getProductsByCategoryAndPrice(
            @RequestParam(value = "category") String category,
            @RequestParam(value = "price") BigDecimal price) {
        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        params.put("price", price);

        return new ResponseEntity<>(params, HttpStatus.OK);
    }

    // List by Category + FreeShipping
    @GetMapping(path = "/articles", params = { "category", "freeShipping" })
    public ResponseEntity<Object> getProductsByCategoryAndFreeShipping(
            @RequestParam(value = "category") String category,
            @RequestParam(value = "freeShipping") Boolean freeShipping) {
        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        params.put("freeShipping", freeShipping);

        return new ResponseEntity<>(params, HttpStatus.OK);
    }

    // List by Category + Prestige
    @GetMapping(path = "/articles", params = { "category=category", "prestige=prestige" })
    public ResponseEntity<Object> getProductsByCategoryAndPrestige(
            @RequestParam(value = "category") String category,
            @RequestParam(value = "prestige") String prestige) {
        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        params.put("prestige", prestige);

        return new ResponseEntity<>(params, HttpStatus.OK);
    }

    // List by Brand + Price
    @GetMapping(path = "/articles", params = { "brand", "price" })
    public ResponseEntity<Object> getProductsByBrandAndPrice(
            @RequestParam(value = "brand") String brand,
            @RequestParam(value = "price") BigDecimal price) {
        Map<String, Object> params = new HashMap<>();
        params.put("brand", brand);
        params.put("price", price);

        return new ResponseEntity<>(params, HttpStatus.OK);
    }

    // List by Brand + FreeShipping
    @GetMapping(path = "/articles", params = { "brand", "freeShipping" })
    public ResponseEntity<Object> getProductsByBrandAndFreeShipping(
            @RequestParam(value = "brand") String brand,
            @RequestParam(value = "freeShipping") Boolean freeShipping) {
        Map<String, Object> params = new HashMap<>();
        params.put("brand", brand);
        params.put("freeShipping", freeShipping);

        return new ResponseEntity<>(params, HttpStatus.OK);
    }

    // List by Brand + Prestige
    @GetMapping(path = "/articles", params = { "brand", "prestige" })
    public ResponseEntity<Object> getProductsByBrandAndPrestige(
            @RequestParam(value = "brand") String brand,
            @RequestParam(value = "prestige") String prestige) {
        Map<String, Object> params = new HashMap<>();
        params.put("brand", brand);
        params.put("prestige", prestige);

        return new ResponseEntity<>(params, HttpStatus.OK);
    }

    // List by Price + FreeShipping
    @GetMapping(path = "/articles", params = { "price", "freeShipping" })
    public ResponseEntity<Object> getProductsByPriceAndFreeShipping(
            @RequestParam(value = "price") BigDecimal price,
            @RequestParam(value = "freeShipping") Boolean freeShipping) {
        Map<String, Object> params = new HashMap<>();
        params.put("price", price);
        params.put("freeShipping", freeShipping);

        return new ResponseEntity<>(params, HttpStatus.OK);
    }

    // List by Price + Prestige
    @GetMapping(path = "/articles", params = { "price", "prestige" })
    public ResponseEntity<Object> getProductsByPriceAndPrestige(
            @RequestParam(value = "price") BigDecimal price,
            @RequestParam(value = "prestige") String prestige) {
        Map<String, Object> params = new HashMap<>();
        params.put("price", price);
        params.put("prestige", prestige);

        return new ResponseEntity<>(params, HttpStatus.OK);
    }

    // List by FreeShipping + Prestige
    @GetMapping(path = "/articles", params = { "freeShipping", "prestige" })
    public ResponseEntity<Object> getProductsByFreeShippingAndPrestige(
            @RequestParam(value = "freeShipping") Boolean freeShipping,
            @RequestParam(value = "prestige") String prestige) {
        Map<String, Object> params = new HashMap<>();
        params.put("freeShipping", freeShipping);
        params.put("prestige", prestige);

        return new ResponseEntity<>(params, HttpStatus.OK);
    }
}
