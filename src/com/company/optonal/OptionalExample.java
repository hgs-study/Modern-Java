package com.company.optonal;


import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {

        System.out.println("================Optional.empty()");

        Optional<Person> hyun = Optional.empty();
        System.out.println("hyun.getClass().getName() = " + hyun.getClass().getName());

        System.out.println("================Optional.of()");

//        Optional<Person> ofTest = Optional.of(null);
//        System.out.println("ofTest.getClass().getName() = " + ofTest.getClass().getName());

        System.out.println("================ Optional.ofNullable()");

        Optional<Person> ofNullableTest = Optional.ofNullable(null);
        System.out.println("ofNullableTest.getClass().getName() = " + ofNullableTest.getClass().getName());


        String getCarInsuranceName = hyun.flatMap(Person::getCar)
                                         .flatMap(Car::getInsurance)
                                         .map(Insurance::getName)
                                         .orElse("Unknown");


    }
}
