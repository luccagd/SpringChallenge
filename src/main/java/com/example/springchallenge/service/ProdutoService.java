package com.example.springchallenge.service;

import java.util.Collections;
import java.util.List;
import java.math.BigDecimal;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.springchallenge.entity.Produto;
import com.example.springchallenge.exception.AppErrorException;
import com.example.springchallenge.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> getProductsByNameAndCategory(String name, String category) {
        try {
            return repository.getByNameAndCategory(name, category);
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Não foi possível listar os produtos por name e category!",
                    e.getMessage());
        }
    }

    public List<Produto> getProductsByNameAndBrand(String name, String brand) {
        try {
            return repository.getByNameAndBrand(name, brand);
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Não foi possível listar os produtos por name e brand!",
                    e.getMessage());
        }
    }

    public List<Produto> getProductsByNameAndPrice(String name, BigDecimal price) {
        try {
            return repository.getByNameAndPrice(name, price);
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Não foi possível listar os produtos por name e price!",
                    e.getMessage());
        }
    }

    public List<Produto> getProductsByNameAndFreeShipping(String name, Boolean freeShipping) {
        try {
            return repository.getByNameAndFreeShipping(name, freeShipping);
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Não foi possível listar os produtos por name e freeShipping!",
                    e.getMessage());
        }
    }

    public List<Produto> getProductsByNameAndPrestige(String name, String prestige) {
        try {
            return repository.getByNameAndPrestige(name, prestige);
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Não foi possível listar os produtos por name e prestige!",
                    e.getMessage());
        }
    }

    public List<Produto> getProductsByCategoryAndBrand(String category, String brand) {
        try {
            return repository.getByCategoryAndBrand(category, brand);
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Não foi possível listar os produtos por category e brand!",
                    e.getMessage());
        }
    }

    public List<Produto> getProductsByCategoryAndPrice(String category, BigDecimal price) {
        try {
            return repository.getByCategoryAndPrice(category, price);
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Não foi possível listar os produtos por category e price!",
                    e.getMessage());
        }
    }

    public List<Produto> getProductsByCategoryAndFreeShipping(String category, Boolean freeShipping, Integer order) {
        try {
            Comparator<Produto> compareByName = Comparator.comparing(Produto::getName);

            List<Produto> produtos = repository.getByCategoryAndFreeShipping(category, freeShipping);

            if (order == 0) {
                produtos.sort(compareByName);
            }

            if (order == 1) {
                produtos.sort(compareByName.reversed());
            }

            if (order == 2) {
                Collections.sort(produtos, (Produto a, Produto b) -> b.compareByPrice(a));
            }

            if (order == 3) {
                Collections.sort(produtos, (Produto a, Produto b) -> a.compareByPrice(b));
            }

            return produtos;
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Não foi possível listar os produtos por category e freeShipping!",
                    e.getMessage());
        }
    }

    public List<Produto> getProductsByCategoryAndPrestige(String category, String prestige) {
        try {
            return repository.getByCategoryAndPrestige(category, prestige);
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Não foi possível listar os produtos por category e prestige!",
                    e.getMessage());
        }
    }

    public List<Produto> getProductsByBrandAndPrice(String brand, BigDecimal price) {
        try {
            return repository.getByBrandAndPrice(brand, price);
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Não foi possível listar os produtos por brand e price!",
                    e.getMessage());
        }
    }

    public List<Produto> getProductsByBrandAndFreeShipping(String brand, Boolean freeShipping) {
        try {
            return repository.getByBrandAndFreeShipping(brand, freeShipping);
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Não foi possível listar os produtos por brand e freeShipping!",
                    e.getMessage());
        }
    }

    public List<Produto> getProductsByBrandAndPrestige(String brand, String prestige) {
        try {
            return repository.getByBrandAndPrestige(brand, prestige);
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Não foi possível listar os produtos por brand e prestige!",
                    e.getMessage());
        }
    }

    public List<Produto> getProductsByPriceAndFreeShipping(BigDecimal price, Boolean freeShipping) {
        try {
            return repository.getByPriceAndFreeShipping(price, freeShipping);
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Não foi possível listar os produtos por price e freeShipping!",
                    e.getMessage());
        }
    }

    public List<Produto> getProductsByPriceAndPrestige(BigDecimal price, String prestige) {
        try {
            return repository.getByPriceAndPrestige(price, prestige);
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Não foi possível listar os produtos por price e prestige!",
                    e.getMessage());
        }
    }

    public List<Produto> getProductsByFreeShippingAndPrestige(Boolean freeShipping, String prestige) {
        try {
            return repository.getByFreeShippingAndPrestige(freeShipping, prestige);
        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Não foi possível listar os produtos por reeShipping e prestige!",
                    e.getMessage());
        }
    }

    public List<Produto> listaPorCategoria(String category) {
        try {
            return repository.getByCategory(category);

        } catch (Exception e) {
            throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Não foi possível listar os produtos por category!",
                    e.getMessage());
        }
    }
}
