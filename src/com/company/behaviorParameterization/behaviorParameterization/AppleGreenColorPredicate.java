package com.company.behaviorParameterization.behaviorParameterization;

import static com.company.behaviorParameterization.behaviorParameterization.Apple.Color.GREEN;

public class AppleGreenColorPredicate implements ApplePredicate{

    @Override
    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }


}
