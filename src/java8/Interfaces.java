package java8;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface Hello {
    void run();

    default void stop() {
        System.out.println("Stopped 🛑   ");
    }

}


public class Interfaces {

    public static void main(String[] args) {
        Hello hello = () -> {
            System.out.println("Running🏃");
        };
        hello.run();
        hello.stop();


        Predicate<Integer> isEven = input -> (input & 1) == 0;

//        System.out.println("isEven.test(10) = " + isEven.test(10));


        Consumer<Map<String, String>> consumer = input -> {
            input.put("Predicate" , isEven.test(10)+"");
        };

        Supplier<Map<String, String>> supplier = () -> {
            Map<String, String> stringStringMap = new HashMap<>();

            stringStringMap.put("A", "A");
            stringStringMap.put("B", "B");
            stringStringMap.put("C", "C");
            return stringStringMap;
        };
        Map<String, String> stringStringMap = supplier.get();
        consumer.accept(stringStringMap);

        System.out.println("stringStringMap =" +stringStringMap);

        Function<String , Integer>  function = input -> {
            return Integer.parseInt(input) * 2;
        };

        Integer apply = function.andThen(item -> {
            System.out.println("item = " + item);
            return item - 10;
        }).apply("20");
        System.out.println("apply = " + apply);

    }


}
