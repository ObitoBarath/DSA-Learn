package HashTables;

import streams.MainStream;
import streams.Transaction;


import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HashMain {


    public void main(String[] args) {
        ConcurrentHashMap<String  , String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("hey" , "hey");
        concurrentHashMap.remove("hey" , "hey");
        System.out.println("concurrentHashMap = " + concurrentHashMap);
        Hashtable<String , String>  hashtable  = new Hashtable<>();

        Hashing<String,Object> stringObjectHashing  = new Hashing<String, Object>(10);

        stringObjectHashing.put("" , "");

        hashtable.put("a" , "b");

        hashtable.put("a" , "b");
        System.out.println("hashtable = " + hashtable);

        //java 8 streams


//        1. Write a Java program to calculate the average of a list of integers using streams.

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);


        Double collect = list.stream().collect(Collectors.averagingInt(item -> item));
        OptionalDouble average = list.stream().mapToInt(Integer::intValue).average();
        System.out.println("collect = " + collect);
        System.out.println("collect = " + average);


//        2. Write a Java program to convert a list of strings to uppercase or lowercase using streams.

        List<String> strings = Arrays.asList("A","B","C","D");


        List<String> collect1 = strings.stream().map(String::toUpperCase).toList();
        System.out.println("collect1 = " + collect1);

//        3. Write a Java program to calculate the sum of all even, odd numbers in a list using streams.

                List<Integer> oddAndEven = Arrays.asList(1,1,1,1,2,2,3,4,5,6,7);

//                boolean oddChecker = num -> ();

                Predicate<Integer> even = input -> (input & 1)==0;
                Predicate<Integer> odd = input -> (input & 1) !=0;

                int sum = oddAndEven.stream().filter(even).mapToInt(item -> item).sum();
                int sum1 = oddAndEven.stream().filter(odd).mapToInt(Integer::intValue).sum();


        System.out.println(sum);
        System.out.println(sum1);



//        Stack + Heap
//        StringPool
//        Object  Heap
        Function<Integer , Integer> integerIntegerFunction  = (input ) -> {
            if ((input & 1)==0){
                return input;
            }
            return  -1;
        };
        Map<String, List<Integer>> collect2 = oddAndEven.stream().collect(Collectors.groupingBy(item -> item % 2 == 0 ? "even" : "odd"));
        List<Integer> collect3 = oddAndEven.stream().distinct().collect(Collectors.toList());
        Set<Integer> collect4 = oddAndEven.stream().collect(Collectors.toSet());
        System.out.println("collect4 = " + collect4);
        System.out.println("collect3 = " + collect3);


        Map<String, ArrayList<Integer>> collect5 = oddAndEven.stream().collect(Collectors.toMap(
                num -> num % 2 == 0 ? "even" : "odd",
                value -> new ArrayList<>(Arrays.asList(value)),
                ((arrayList, arrayList2) -> {
                    arrayList.addAll(arrayList2);
                    return arrayList;
                })

        ));
        System.out.println("collect5 = " + collect5);






/*
        Map<String, List<Integer>> oddEvenMap = oddAndEven.stream()
                .collect(Collectors.toMap(
                        num -> num % 2 == 0 ? "even" : "odd", // Key: "even" or "odd"
                        num -> new ArrayList<>(Arrays.asList(num)), // Value: List containing the number
                        (existing, newList) -> { // Merge function for duplicate keys
                            existing.addAll(newList);
                            return existing;
                        }
                ));
*/




        System.out.println("collect2 = " + collect2);


//        4. Write a Java program to remove all duplicate elements from a list using streams.

        List<Integer> collect6 = Arrays.asList(1, 23, 1, 2, 3, 4, 5, 6).stream().distinct().collect(Collectors.toList());
        System.out.println("collect6 = " + collect6);


//        5. Write a Java program to count the number of strings in a list that start with a specific letter using streams.







//        6. Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams.

        Stream<String> words = Stream.of("a", "d", "c", "b", "e");


        List<String> list1 = words.sorted().toList();

        List<String> list2 = list1.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);

        TreeMap<String,String> stringStringTreeMap = new TreeMap<>();
//        stringStringTreeMap.put(null , null);

        System.out.println("stringStringTreeMap = " + stringStringTreeMap);


//        Hashtable<String , String>  hashtable1 = new Hashtable<>();
//        hashtable1.put("imran" , null);
//
//        System.out.println("hashtable1 = " + hashtable1);
//
        SortedSet<String> strings1  = new TreeSet<>();

        List<String> vectors = new Vector<>();

        Vector<String> vector = new Stack<>();
        HashSet<String> strings2  = new HashSet<>();
        Set<String>  strings3 = new TreeSet<>();








//        Set<String> collect7 = Stream.of("a", "d", "c", "b", "e").collect(Collectors.toSet());

//        System.out.println("collect7 = " + collect7);

//        7. Write a Java program to find the maximum and minimum values in a list of integers using streams.

        Map<String, Integer> collect7 = Stream.of(1, 2, 43, 5, 6, 0).collect(Collectors.teeing(
                Collectors.maxBy(Integer::compareTo),
                Collectors.minBy(Integer::compareTo),
                ((max, min) -> {
                    Map<String, Integer> stringIntegerMap = new WeakHashMap<>();
                    stringIntegerMap.put("max", max.orElse(null));
                    stringIntegerMap.put("min", min.orElse(null));
                    return stringIntegerMap;
                })
        ));


        List<Integer> collect8 = Arrays.asList( 5 , 1, 2, 3, 4).stream().limit(10).collect(Collectors.toList());
        System.out.println("collect8 = " + collect8);

        Integer int1 = 111;
        int numericValue = Character.getNumericValue(int1);
        System.out.println("numericValue = " + numericValue);

//        SortedSet<String> strings1 = new TreeSet<>();;

        Integer reduce = collect8.stream().reduce(10, Integer::sum);
        System.out.println("reduce = " + reduce);

        System.out.println("collect7 = " + collect7);

        String collect9 = collect8.stream().map(String::valueOf).collect(Collectors.joining("\n"));

        System.out.println("collect9 = " + collect9);
//        System.out.println("string = " + string);


//        8. Write a Java program to find the second smallest and largest elements in a list of integers using streams.

        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5, 6);

        Integer secondSmallest = list3.stream().sorted().skip(1).findFirst().orElse(null);
        Integer secondLargest = list3.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);


//        Integer i = list.stream().max(Integer::compareTo).orElse(null);
//        Integer i = list.stream().min(Integer::compareTo).orElse(null);
        List<String> sentences = Arrays.asList("Hello World", "Java Streams", "Let's Learn");

        String string = sentences.stream().flatMap(String::lines).toString();
        System.out.println("string = " + string);

        List<String> list4 = Stream.concat(sentences.stream(), list3.stream().map(String::valueOf)).toList();
        System.out.println("list4 = " + list4);


        /*List<Person> people = Arrays.asList(
                new Person("Alice", "New York"),
                new Person("Bob", "London"),
                new Person("Charlie", "New York"),
                new Person("David", "London")
        );


        Map<String, List<Person>> collect10 = people.stream().collect(Collectors.groupingBy(Person::getName));
        System.out.println("collect10 = " + collect10);

*/

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum12 = numbers.parallelStream().reduce(0, Integer::sum);
        System.out.println(sum12);

        List<Transaction> transactions = Arrays.asList(
                new Transaction(1200, LocalDate.now().minusDays(3)),
                new Transaction(900, LocalDate.now().minusDays(10)),
                new Transaction(2000, LocalDate.now().minusDays(5))
        );



        HashMap<String , String> hashMap = new HashMap<>();


        hashMap.put(null , null);
        ConcurrentHashMap<String ,String> concurrentHashMap1 = new ConcurrentHashMap<>();

//        concurrentHashMap1.put(null , null);

        List<String> arrayList = Arrays.asList("Java", "Spring", "Kafka", "JPA");

        Spliterator<String> stringSpliterator = arrayList.spliterator();
        Spliterator<String> stringSpliterator1 = stringSpliterator.trySplit();

        stringSpliterator.forEachRemaining(System.out::println);
        System.out.println("-----------------------");
        stringSpliterator1.forEachRemaining(System.out::println);
        System.out.println("stringSpliterator = " + stringSpliterator);

        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("Java", "Spring"),
                Arrays.asList("Kafka", "JPA")
        );
        Map<String, List<String>> collect10 = nestedList.stream().flatMap(Collection::stream).collect(Collectors.groupingBy(String::valueOf));

        System.out.println("collect10 = " + collect10);

        System.out.println("transactions = " + transactions);
        transactions.sort(Comparator.comparingInt(item -> item.getLocalDate().getDayOfYear()));
        System.out.println("After sorting  transactions = " + transactions);



    }







}
