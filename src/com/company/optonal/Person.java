package com.company.optonal;


import java.util.Optional;

public class Person {
    private String name;
    private int age;
    private Optional<Car> car;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Optional<Car> getCar() {
        return car;
    }
}
