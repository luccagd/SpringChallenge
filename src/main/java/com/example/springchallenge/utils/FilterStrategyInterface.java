package com.example.springchallenge.utils;

import java.util.List;

public interface FilterStrategyInterface<T> {
    List<T> apply(List<T> t);
}
