package java8.functionalInterfaces;

import java.util.function.Function;

public class FunctionExample {

    static Function<String,String> upperCase =  (name) -> name.toUpperCase();

    static Function<String,String> addSomeString =  (name) -> name.toUpperCase().concat("default");

    static Function<String,Integer> strLength =  (name) -> name.length();




    public static void main(String[] args) {

        System.out.println("Result is : " + upperCase.apply("java8"));

        System.out.println("Result of andthen : " + upperCase.andThen(addSomeString).apply("java8"));

        System.out.println("Result of compose : " + upperCase.compose(addSomeString).apply("java8"));
        //Diff between andThen and compose is in andThen it performs uppercase first and then add some string and in
        //other it s opposite
        Function<String,String> abc = Function.identity();

        System.out.println(abc.apply("ABC"));


    }
}
