package com.example.springchallenge.repository;

import java.math.BigDecimal;
import java.util.List;
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

        return JoinListHelper.join(pFiltradosName, pFiltradosCategoria);
    }

    public List<Produto> getProductsByNameAndBrand(String name, String brand) {
        Stream<Produto> pFiltradosName = this.produtos.stream()
                .filter(produto -> produto.getName().equalsIgnoreCase(name));

        Stream<Produto> pFiltradosBrand = this.produtos.stream()
                .filter(produto -> produto.getBrand().equalsIgnoreCase(brand));

        return JoinListHelper.join(pFiltradosName, pFiltradosBrand);
    }

    public List<Produto> getProductsByNameAndPrice(String name, BigDecimal price) {
        Stream<Produto> pFiltradosName = this.produtos.stream()
                .filter(produto -> produto.getName().equalsIgnoreCase(name));

        Stream<Produto> pFiltradosPrice = this.produtos.stream()
                .filter(produto -> produto.getPrice().equals(price));

        return JoinListHelper.join(pFiltradosName, pFiltradosPrice);
    }

    public List<Produto> getProductsByNameAndFreeShipping(String name, Boolean freeShipping) {
        Stream<Produto> pFiltradosName = this.produtos.stream()
                .filter(produto -> produto.getName().equalsIgnoreCase(name));

        Stream<Produto> pFiltradosFreeShipping = this.produtos.stream()
                .filter(produto -> produto.getFreeShipping().equals(freeShipping));

        return JoinListHelper.join(pFiltradosName, pFiltradosFreeShipping);
    }

    public List<Produto> getProductsByNameAndPrestige(String name, String prestige) {
        Stream<Produto> pFiltradosName = this.produtos.stream()
                .filter(produto -> produto.getName().equalsIgnoreCase(name));

        Stream<Produto> pFiltradosPrestige = this.produtos.stream()
                .filter(produto -> produto.getPrestige().equalsIgnoreCase(prestige));

        return JoinListHelper.join(pFiltradosName, pFiltradosPrestige);
    }

    public List<Produto> getProductsByCategoryAndBrand(String category, String brand) {
        Stream<Produto> pFiltradosCategory = this.produtos.stream()
                .filter(produto -> produto.getCategory().equalsIgnoreCase(category));

        Stream<Produto> pFiltradosBrand = this.produtos.stream()
                .filter(produto -> produto.getBrand().equalsIgnoreCase(brand));

        return JoinListHelper.join(pFiltradosCategory, pFiltradosBrand);
    }

    public List<Produto> getProductsByCategoryAndPrice(String category, BigDecimal price) {
        Stream<Produto> pFiltradosCategory = this.produtos.stream()
                .filter(produto -> produto.getCategory().equalsIgnoreCase(category));

        Stream<Produto> pFiltradosPrice = this.produtos.stream()
                .filter(produto -> produto.getPrice().equals(price));

        return JoinListHelper.join(pFiltradosCategory, pFiltradosPrice);
    }

    public List<Produto> getProductsByCategoryAndFreeShipping(String category, Boolean freeShipping) {
        Stream<Produto> pFiltradosCategory = this.produtos.stream()
                .filter(produto -> produto.getCategory().equalsIgnoreCase(category));

        Stream<Produto> pFiltradosFreeShipping = this.produtos.stream()
                .filter(produto -> produto.getFreeShipping().equals(freeShipping));

        return JoinListHelper.join(pFiltradosCategory, pFiltradosFreeShipping);
    }

    public List<Produto> getProductsByCategoryAndPrestige(String category, String prestige) {
        Stream<Produto> pFiltradosCategory = this.produtos.stream()
                .filter(produto -> produto.getCategory().equalsIgnoreCase(category));

        Stream<Produto> pFiltradosPrestige = this.produtos.stream()
                .filter(produto -> produto.getPrestige().equalsIgnoreCase(prestige));

        return JoinListHelper.join(pFiltradosCategory, pFiltradosPrestige);
    }

    public List<Produto> getProductsByBrandAndPrice(String brand, BigDecimal price) {
        Stream<Produto> pFiltradosBrand = this.produtos.stream()
                .filter(produto -> produto.getBrand().equalsIgnoreCase(brand));

        Stream<Produto> pFiltradosPrice = this.produtos.stream()
                .filter(produto -> produto.getPrice().equals(price));

        return JoinListHelper.join(pFiltradosBrand, pFiltradosPrice);
    }

    public List<Produto> getProductsByBrandAndFreeShipping(String brand, Boolean freeShipping) {
        Stream<Produto> pFiltradosBrand = this.produtos.stream()
                .filter(produto -> produto.getBrand().equalsIgnoreCase(brand));

        Stream<Produto> pFiltradosFreeShipping = this.produtos.stream()
                .filter(produto -> produto.getFreeShipping().equals(freeShipping));

        return JoinListHelper.join(pFiltradosBrand, pFiltradosFreeShipping);
    }

    public List<Produto> getProductsByBrandAndPrestige(String brand, String prestige) {
        Stream<Produto> pFiltradosBrand = this.produtos.stream()
                .filter(produto -> produto.getBrand().equalsIgnoreCase(brand));

        Stream<Produto> pFiltradosPrestige = this.produtos.stream()
                .filter(produto -> produto.getPrestige().equalsIgnoreCase(prestige));

        return JoinListHelper.join(pFiltradosBrand, pFiltradosPrestige);
    }

    public List<Produto> getProductsByPriceAndFreeShipping(BigDecimal price, Boolean freeShipping) {
        Stream<Produto> pFiltradosPrice = this.produtos.stream()
                .filter(produto -> produto.getPrice().equals(price));

        Stream<Produto> pFiltradosFreeShipping = this.produtos.stream()
                .filter(produto -> produto.getFreeShipping().equals(freeShipping));

        return JoinListHelper.join(pFiltradosPrice, pFiltradosFreeShipping);
    }

    public List<Produto> getProductsByPriceAndPrestige(BigDecimal price, String prestige) {
        Stream<Produto> pFiltradosPrice = this.produtos.stream()
                .filter(produto -> produto.getPrice().equals(price));

        Stream<Produto> pFiltradosPrestige = this.produtos.stream()
                .filter(produto -> produto.getPrestige().equalsIgnoreCase(prestige));

        return JoinListHelper.join(pFiltradosPrice, pFiltradosPrestige);
    }

    public List<Produto> getProductsByFreeShippingAndPrestige(Boolean freeShipping, String prestige) {
        Stream<Produto> pFiltradosFreeShipping = this.produtos.stream()
                .filter(produto -> produto.getFreeShipping().equals(freeShipping));

        Stream<Produto> pFiltradosPrestige = this.produtos.stream()
                .filter(produto -> produto.getPrestige().equalsIgnoreCase(prestige));

        return JoinListHelper.join(pFiltradosFreeShipping, pFiltradosPrestige);
    }

}
