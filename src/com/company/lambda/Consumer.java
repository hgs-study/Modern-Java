package com.company.lambda;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}


