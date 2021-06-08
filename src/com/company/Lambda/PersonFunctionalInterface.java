package com.company.Lambda;

import java.util.function.Predicate;

@FunctionalInterface
public interface PersonFunctionalInterface {

    boolean test(Person p1, Person p2);
}
