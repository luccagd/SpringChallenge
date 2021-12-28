package com.example.springchallenge.repository.interfaces;

import java.util.List;

public interface BaseRepository<T, U> {

    void save(T t);

    List<T> getAll();

    T getById(U id);

}
