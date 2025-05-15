package java8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.time.LocalDate;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/*
@Target(ElementType.TYPE)
@interface VeryImportant{
    int time() default 1;
}
*/


//@VeryImportant(time = 3)
class  Student implements Comparable<Student> {

    Integer rollNumber;
    String name;


    public Student(int rollNumber , String name){

        this.rollNumber = rollNumber;
        this.name = name;

    }


    public Integer getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(Integer rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*@Override
    public boolean equals(Student o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student =  o;
        return Objects.equals(rollNumber, student.rollNumber) && Objects.equals(name, student.name);
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(rollNumber, name);
    }

    @Override
    public int compareTo(Student that) {
        return this.rollNumber.compareTo(that.rollNumber);
    }
/*
    public String toString(){
        return STR."Student = { rollNumber = \{rollNumber} , name =\{name} }";
    }*/
}

public class JavaEight {


    @FunctionalInterface
    public interface Start {
        void start();
    }

    interface A {
        void hey();

        void hi();

        default void bye() {

        }

    }

    public class B implements A {

        @Override
        public void hey() {

        }

        @Override
        public void hi() {

        }
    }


    /*public static void main(String[] args) {


        Start first = new Start() {
            @Override
            public void start() {
                System.out.println("started");
            }
        };


        Start second = () -> {
            System.out.println("started with lambda expression");
        };

        first.start();
        second.start();


        Predicate<String> stringPredicate = input -> input.contains("&");

        System.out.println("Predicate " + stringPredicate.test("%"));


        Consumer<Map<String, String>> mapConsumer = (inputMap) -> {
            inputMap.put("hello", "java8");
        };

        Map<String, String> stringStringMap = new LinkedHashMap<>();
        stringStringMap.put("FunctionalInterface", "Consumer");
        System.out.println("Before stringStringMap = " + stringStringMap);

        mapConsumer.accept(stringStringMap);

        System.out.println("After stringStringMap = " + stringStringMap);

        Function<Map<String, String>, String> function = map -> {
            return map.get("hi");
        };

        Map<String, String> helloMap = new LinkedHashMap<>();

        helloMap.put("hi", "vanakam da ");
        String apply = function.apply(helloMap);
        System.out.println("apply = " + apply);


        Supplier<Integer> integerSupplier = () -> (int) Math.abs(Math.random());
        *//*Integer i = integerSupplier.get();

        System.out.println("i = " + i);*//*

        Consumer<ArraysQuestions> numberOfGoodPairs = ArraysQuestions::numberOfGoodPairs;
        numberOfGoodPairs.accept(new ArraysQuestions());


        List<Integer> list = Arrays.asList(1, 6, 3, 4, 5, 5);


        list.sort(((o1, o2) -> {
            return o1 - o2;
        }));
        System.out.println("list = " + list);


        List<Student> students = Arrays.asList(new Student(1,"A"), new Student(3,"B"), new Student(2,"C"));

        Collections.sort(students);

        System.out.println("students = " + students);

        Runnable sayHi = JavaEight::sayHi;
        sayHi.run();

        Optional<Student> byAge = getByAge(2);

        byAge.ifPresent(student -> {
            System.out.println("byAge = " + student);
        });




        BiConsumer<Map<String,String> , List<String>> mapListBiConsumer = (map , array) -> {
            System.out.println("map = " + map);
            System.out.println("student= " + array);
        };

        mapListBiConsumer.accept(new LinkedHashMap<>() ,  new ArrayList<>());


        long start = System.currentTimeMillis();
        students.stream().forEach(System.out::println);
        long end  = System.currentTimeMillis();


        System.out.println("normal Stream "+(end - start));

        long parallelStart = System.currentTimeMillis();
        students.parallelStream().forEach(System.out::println);
        long parallelEnd  = System.currentTimeMillis();


        System.out.println("parall Stream "+(parallelEnd - parallelStart) );
        System.out.println("list -->" + list);

        List<Integer> collect = list.stream().map(item -> item * 2).collect(Collectors.toUnmodifiableList());

        List<Student> collect1 = students.stream().peek(item -> {
            if (item.getName().equals("A")) {
                item.setName("BARATH");
            }
        }).collect(Collectors.toList());


//        IntStream.range(1,10).parallel().forEachOrdered(System.out::println);
        try (Stream<String> stringStream = Stream.of("hello")) {
            System.out.println("stringStream = " + stringStream.anyMatch(item -> item.contains("z")));
        }

        boolean b = collect.stream().anyMatch(integer -> integer == 2);
        System.out.println("any = " + b);

        Stream<Integer> integerStream = collect.stream().filter(integer -> {
            return (integer % 2) == 0;
        });

        LongStream stream1 = LongStream.of(49L, 64L, 81L, 100L);

        // Using LongStream flatMap()
        LongStream stream2 = stream1.flatMap(num
                -> LongStream.of(Long.bitCount(num)));


        List<Integer> list1 = new ArrayList<>();
        list.sort(Integer::compareTo);

        Map<String,String>stringStringMap1 = new LinkedHashMap<>();


        String put = stringStringMap1.put(null, "nullValue");
        System.out.println("put = " + put);
        System.out.println("stringStringMap1 = " + stringStringMap1);


        Stream<Integer> integerStream1 = integerStream.filter(Objects::nonNull);
        integerStream1.forEach(item -> {
            System.out.println("item = " + item);
        });

        Map<String, Integer> c = students.stream().flatMap(item -> {
            if (item.getName().equals("C"))
                return Stream.of(item);
            else
                return Stream.empty();
        }).collect(Collectors.toMap(Student::getName, Student::getRollNumber));


        UnaryOperator<Boolean> identity = UnaryOperator.identity();

        identity.apply(false);
        System.out.println("c = " + c);

//        System.out.println("STUDENT = " + collect1);
//        System.out.println("collect -->" + collect);
        Function<Integer, Integer> add5 = x -> x + 5;
        Function<Integer, Integer> multiplyBy2 = x -> x * 2;

        Function<Integer,Integer> addOne = x -> {
         return  ++x;
        };
        // Combine them using andThen
        Function<Integer, Integer> combined = add5.andThen(multiplyBy2).andThen(addOne);

        // Apply the combined function to 3
        System.out.println(combined.apply(3));


        LocalDate localDate  = LocalDate.now();
        System.out.println("localDate =" + localDate);


        int[] integers  = {1,2,3,5};


        //for

        //Record
        for (int i = 0 ; i  < integers.length ; i ++){
            int integer = integers[i];
            if ((integer & 1) ==0){
                System.out.println("integer = " + integer);
                return;
            }
        }




    }*/


    public static void main(String[] args) {



        sayHi();
        System.out.println("without main ");
        System.exit(0);

    }


    /*private static Optional<Student> getByAge(int age){

        Student student = new Student(age,"Barath");

        return  Optional.ofNullable(student);
};*/
    public static void sayHi(){
        System.out.println("Hello world");
        int[] array1 = {1,3,5,7,9};
        int[] array2 = {2,4,5,8,10};
        int[] combinedArray = new int[array1.length + array2.length];
//        int[] newArray = new int[minCapacity * 2];
//            System.arraycopy(customStackArray , 0 ,newArray , 0 , minCapacity );
        System.arraycopy(array1 , 0  , combinedArray , 0  , array1.length);
        System.arraycopy(array2 , 0  , combinedArray , 5  , array1.length);
        Arrays.sort(combinedArray);

//        System.arraycopy(array2 , array1.length  , combinedArray , array1.length + array2.length , array1.length + array2.length);
        System.out.println("combined array = "+Arrays.toString(combinedArray));


        System.out.println("try finallay "+tryFinally());
    }

    public static String tryFinally(){
        try {
            throw  new RuntimeException();

        }catch (Exception e){
            System.out.println("catch ");
            return "catch;";
        }
        finally {

            return "finnally";
        }
    }
}
