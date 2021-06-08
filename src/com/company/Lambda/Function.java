package com.company.Lambda;

@FunctionalInterface
public interface Function<T,R> {
    R apply(T t);
}


