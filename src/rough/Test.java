package rough;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Test {

    public static void main(String[] args) {
        Test t = new Test();
        List<String> list = Arrays.asList("a", "b", "a", "c", "p", "b");
        Map<String, Integer> map = t.convertListToMap(list, x -> x.length());
        System.out.println(map);

        Map<String,Integer> map1 = t.convertListToMap(list,t::getLength);
        System.out.println(map1);


        BiFunction<String,String,String> biFunction = (a,b)->a.concat(b);

        Function<String,String> function = a->a +" "+a.length();

        System.out.println(biFunction.andThen(function).apply("Saurabh","Kumar"));

    }

    <T, R> Map<T, R> convertListToMap(List<T> list, Function<T, R> func) {
        Map<T, R> result = new HashMap<>();
        for (T t : list) {
            result.put(t, func.apply(t));
        }
        return result;
    }

    private int getLength(String str) {
        return str.length();
    }
}
