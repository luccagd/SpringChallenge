package com.example.springchallenge.helper;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FilterHelper {
    private String name;
    private String category;
    private String brand;
    private BigDecimal price;
    private Boolean freeShipping;
    private String prestige;
    private String order;

    public boolean hasFilterOptions() {
        return this.name != null ||
                this.category != null ||
                this.brand != null ||
                this.price != null ||
                this.freeShipping != null ||
                this.prestige != null ||
                this.order != null;
    }
}
