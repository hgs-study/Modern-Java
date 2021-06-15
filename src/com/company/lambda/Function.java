package com.company.lambda;

@FunctionalInterface
public interface Function<T,R> {
    R apply(T t);
}


