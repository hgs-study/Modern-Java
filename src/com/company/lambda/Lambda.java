package com.company.lambda;

import java.util.Comparator;


public class Lambda {

    public static void main(String[] args) {


        //익명 클래스
        Comparator<Person> byHeight1 = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getHeight().compareTo(p2.getHeight());
            }
        };

        //람다 이용
       Comparator<Person> byHeight =
                (Person p1, Person p2)->p1.getHeight().compareTo(p1.getHeight());


//        람다 문법
//        (String s)-> s.length()
//        (Person p) -> p.getHeight() > 150
//        (int x, int y) -> {
//            System.out.println("result")
//            System.out.println(x+y)
//        }
//        () -> 42
//        (Person p1, Person p2) -> p1.getHeight().compareTo(p2.getHeight())


//        List<Person> tallerThan180cm =
//        filter(people,(Person person) -> person.getHeight() > 180 );

    }

}
