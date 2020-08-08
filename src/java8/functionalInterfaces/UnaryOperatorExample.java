package java8.functionalInterfaces;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

    static UnaryOperator<String> unaryOperator = (s)->s.concat("Default");


    //UnaryOperator if i/p and o/p are of same type
    public static void main(String[] args) {

        System.out.println(unaryOperator.apply("java8"));


    }
}
