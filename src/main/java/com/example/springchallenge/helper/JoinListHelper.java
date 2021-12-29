package com.example.springchallenge.helper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoinListHelper {
    public static <T> List<T> joinList(Stream<T> a, Stream<T> b) {
        return Stream.concat(a, b).collect(Collectors.toList());
    }
}
