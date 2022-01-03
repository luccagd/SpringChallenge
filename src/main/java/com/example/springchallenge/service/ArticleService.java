package com.example.springchallenge.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springchallenge.entity.Article;
import com.example.springchallenge.helper.FilterHelper;
import com.example.springchallenge.repository.ArticleRepository;
import com.example.springchallenge.utils.FilterStrategyFactory;
import com.example.springchallenge.utils.FilterStrategyInterface;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository repository;

    private FilterStrategyFactory strategyFactory = new FilterStrategyFactory();

    public List<Article> getAllArticles() {
        return repository.getAll();
    }

    public List<Article> getFilteredArticles(FilterHelper filterHelper) {
        if (!filterHelper.hasFilterOptions()) {
            return repository.getAll();
        }

        Set<Article> articles = new HashSet<>(repository.getAll());

        articles = getArticlesByName(filterHelper.getName(), articles);
        articles = getArticlesByCategory(filterHelper.getCategory(), articles);
        articles = getArticlesByBrand(filterHelper.getBrand(), articles);
        articles = getArticlesByPrice(filterHelper.getPrice(), articles);
        articles = getArticlesByFreeShipping(filterHelper.getFreeShipping(), articles);
        articles = getArticlesByPrestige(filterHelper.getPrestige(), articles);

        List<Article> finalArticles = filterArticlesByOrderType(filterHelper, articles);

        return finalArticles;
    }

    private List<Article> filterArticlesByOrderType(FilterHelper filterHelper, Set<Article> articles) {
        FilterStrategyInterface<Article> strategy = strategyFactory.getStrategy(filterHelper.getOrder());
        List<Article> finalArticles = new ArrayList<>(articles);

        if (filterHelper.getOrder() != null) {
            finalArticles = strategy.apply(finalArticles);
        }

        return finalArticles;
    }

    public Article getArticleById(Long id) {
        return repository.getById(id);
    }

    private Set<Article> getArticlesByName(String name, Set<Article> articles) {
        if (name != null) {
            articles = articles.stream().filter(a -> a.getName().equalsIgnoreCase(name)).collect(Collectors.toSet());
        }

        return articles;
    }

    private Set<Article> getArticlesByCategory(String category, Set<Article> articles) {
        if (category != null) {
            articles = articles.stream().filter(a -> a.getCategory().equalsIgnoreCase(category))
                    .collect(Collectors.toSet());
        }

        return articles;
    }

    private Set<Article> getArticlesByBrand(String brand, Set<Article> articles) {
        if (brand != null) {
            articles = articles.stream().filter(a -> a.getBrand().equalsIgnoreCase(brand)).collect(Collectors.toSet());
        }

        return articles;
    }

    private Set<Article> getArticlesByPrice(BigDecimal price, Set<Article> articles) {
        if (price != null) {
            articles = articles.stream().filter(a -> a.getPrice().equals(price)).collect(Collectors.toSet());
        }

        return articles;
    }

    private Set<Article> getArticlesByFreeShipping(Boolean freeShipping, Set<Article> articles) {
        if (freeShipping != null) {
            articles = articles.stream().filter(a -> a.getFreeShipping().equals(freeShipping))
                    .collect(Collectors.toSet());
        }

        return articles;
    }

    private Set<Article> getArticlesByPrestige(String prestige, Set<Article> articles) {
        if (prestige != null) {
            articles = articles.stream().filter(a -> a.getPrestige().equals(prestige)).collect(Collectors.toSet());
        }

        return articles;
    }
}
