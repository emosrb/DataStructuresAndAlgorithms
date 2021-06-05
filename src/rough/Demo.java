package rough;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Java8Predicate5 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");


      List<String> result =  list.stream().map(x->x.toLowerCase()).collect(Collectors.toList());

        System.out.println(result);

    }
}