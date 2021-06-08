package com.company.behaviorParameterization.behaviorParameterization;

public class Apple implements Comparable<Apple> {

    private Color color;
    private int weight;

    enum Color{
        RED,
        GREEN,
        ORANGE;
    }

    public Color getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    Apple(Color appleColor, int appleWeight){
        color = appleColor;
        weight = appleWeight;
    }



}
