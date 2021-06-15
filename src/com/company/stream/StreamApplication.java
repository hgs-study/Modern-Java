package com.company.stream;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApplication {

    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork",false,800, Dish.Type.MEAT),
                new Dish("beef",false,700, Dish.Type.MEAT),
                new Dish("chicken",false,300, Dish.Type.OTHER),
                new Dish("rice",false,400, Dish.Type.FISH),
                new Dish("pizza",false,500, Dish.Type.FISH),
                new Dish("pizza",false,600, Dish.Type.FISH)
        );

        //filter 프레디케이트
        List<Dish> vegetarianMenu = menu.stream()
                                        .filter(Dish::isVegetarian)
                                        .collect(Collectors.toList());

        //고유 요소 필터링 (distinct)
        List<Dish> distinctMenu = menu.stream()
                                        .filter(d -> d.getName().equals("pizza"))
                                        .distinct()
                                        .collect(Collectors.toList());

        // 조건에 맞지 않는 데이터가 나올 경우 중단 (takeWhile) java 9지원
//        List<Dish> takewhileMenu = menu.stream()
//                                        .takeWhile( d-> d.getCalories() < 320)
//                                        .collect(Collectors.toList());

        // 거짓이 되는 요소가 발견되면 중단하고 남은 요소 반환 (dropWhile)
//        List<Dish> dropWhileMenu = menu.stream()
//                                        .dropWhile( d-> d.getCalories() < 320)
//                                        .collect(Collectors.toList());


        //스트림 축소 (limit)
        List<Dish> vegetarianLimitMenu = menu.stream()
                                        .filter(Dish::isVegetarian)
                                        .limit(3)
                                        .collect(Collectors.toList());

        //요소 건너띄기 (skip)
        List<Dish> skipMenu = menu.stream()
                                        .filter(d-> d.getCalories() < 320)
                                        .limit(2)
                                        .collect(Collectors.toList());

        // 요리명을 다시 길이로 매핑
        List<Integer> dishNameLengths = menu.stream()
                                            .map(Dish::getName)
                                            .map(String::length)
                                            .collect(Collectors.toList());

        List<String> words  = Arrays.asList("Hello","World");

        //
        List<String> uniqueCharacters = words.stream()
                                             .map(word -> word.split(""))
                                             .flatMap(Arrays::stream)
                                             .distinct()
                                             .collect(Collectors.toList());

        //allMatch
        boolean isHealthy = menu.stream()
                                .allMatch(d -> d.getCalories() <1000);

        List<Integer> numbers = Arrays.asList(1,2,3,4);

        //reduce 스트림 요소의 합 , 초깃값 : 0
        int sum = numbers.stream()
                         .reduce(0, (a,b) -> a + b);

        //기본형 특화 스트림, 박싱 언박싱
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> integerStream = intStream.boxed(); // 언박싱 -> 박싱

        //숫자 범위
        IntStream evenNumber = IntStream.rangeClosed(1,100)
                                        .filter(n -> n % 2 ==0);


        //값으로 스트림 만들기
        Stream<String> stringStream = Stream.of("Modern" , "java", "Name" , "Hyun");
        stringStream.map(String::toUpperCase)
                    .forEach(System.out::println);

        //스트림 비우기
        Stream<String> emptyStream = Stream.empty();


        //무한 스트림 (iterate)
        Stream.iterate( 0, m-> m +3)
              .limit(10)
              .forEach(System.out::println);

        //무한 스트림 (generate)
        Stream.generate(Math::random)
              .limit(5)
              .forEach(System.out::println);

    }
}
