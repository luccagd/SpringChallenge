package com.example.springchallenge.utils;

import java.util.HashMap;
import java.util.Map;

import com.example.springchallenge.entity.Article;

public class FilterStrategyFactory {
    private Map<String, FilterStrategyInterface<Article>> conditions = new HashMap<>();

    public FilterStrategyFactory() {
        conditions.put("0", new FilterAlphabeticalAsc());
        conditions.put("1", new FilterAlphabeticalDesc());
        conditions.put("2", new FilterPriceDesc());
        conditions.put("3", new FilterPriceAsc());
    }

    public FilterStrategyInterface<Article> getStrategy(String condition) {
        return conditions.get(condition);
    }
}
