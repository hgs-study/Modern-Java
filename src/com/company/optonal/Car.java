package com.company.optonal;

import java.util.Optional;

public class Car {
    private String name;
    private Optional<Insurance> insurance;


    public String getName() {
        return name;
    }

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}
