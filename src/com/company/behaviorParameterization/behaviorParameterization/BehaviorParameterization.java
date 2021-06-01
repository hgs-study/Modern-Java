package com.company.behaviorParameterization.behaviorParameterization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.company.behaviorParameterization.behaviorParameterization.Apple.Color.ORANGE;
import static com.company.behaviorParameterization.behaviorParameterization.Apple.Color.RED;

public class BehaviorParameterization {

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple(Apple.Color.GREEN, 100),
                                           new Apple(RED, 110),
                                           new Apple(Apple.Color.GREEN, 150),
                                           new Apple(RED, 170),
                                           new Apple(Apple.Color.GREEN, 190),
                                           new Apple(Apple.Color.ORANGE, 200)
                                            );

        List<Apple> filterApples = Lambda(apples);

        for(Apple apple : filterApples){
            System.out.println("apple.getWeight() = " + apple.getWeight());
            System.out.println("apple.getColor() = " + apple.getColor());
        }
    }

    //동작 파라미터
    public static List<Apple> BehaviorParameterization( List<Apple> apples){
        return filterApples(apples, new AppleGreenColorPredicate());
    }

    //익명 클래스
    public static List<Apple> AnonymousClass( List<Apple> apples){
        return filterApples(apples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return RED.equals(apple.getColor());
            }
        });
    }

    // 람다 활용
    public static List<Apple> Lambda( List<Apple> apples){
        return filterApples(apples, (Apple apple)-> ORANGE.equals(apple.getColor()));
    }


    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> apples = new ArrayList<>();

        for(Apple apple : inventory){
            if(p.test(apple))
                apples.add(apple);
        }

        return apples;
    }

}
