package com.example.springchallenge.helper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoinListHelper {
    public static <T> List<T> join(Stream<T> a, Stream<T> b) {
        Set<T> joinList = Stream.concat(a, b).collect(Collectors.toSet());

        return List.copyOf(joinList);
    }
}
