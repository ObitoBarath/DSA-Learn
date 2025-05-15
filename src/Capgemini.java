import streams.Transaction;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class Capgemini {


    abstract class A{

        abstract void run();

    }

    interface C {

        void run();

        default void stop(){

            this.run();

        }

    }

    sealed class G permits B {

    }

    final class B extends G  implements C {
        @Override
        public void run() {

        }
    }


    public static void main(String[] args) throws InterruptedException {

        Map<String, List<String>> stringListMap = new HashMap<>();

        stringListMap.put("A" , Arrays.asList("1","2"));
        stringListMap.put("B" , Arrays.asList("1","8","3"));
        stringListMap.put("C" , Arrays.asList("1","2"));
        stringListMap.put("D" , Arrays.asList("1","2"));
        stringListMap.put("E" , Arrays.asList("1","2"));


        String s2 = stringListMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, value -> value.getValue().stream().mapToInt(Integer::parseInt).reduce(1, (p, c) -> p * c))).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
        System.out.println("s2 = " + s2);

        Map<String, Integer> collect4 = stringListMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().stream().map(Integer::parseInt).reduce(1, (p, c) -> p * c)));
        System.out.println("collect4 = " + collect4);

        stringListMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().stream().mapToInt(Integer::parseInt).reduce( 1 , (p , c) -> p*c)));


//        Arrays.asList("1","2").stream().map(item -> item)
        long sum = stringListMap.entrySet().stream().max(Comparator.comparing(item -> item.getValue().size())).map(Map.Entry::getValue).orElse(Collections.emptyList()).stream().collect(Collectors.summarizingInt(Integer::parseInt)).getSum();
        System.out.println("sum = " + sum);


        Map<String, Integer> collect = stringListMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().stream().map(Integer::parseInt).reduce(1, (a, b) -> a * b)));
        System.out.println("collect = " + collect);

        Map<String, Integer> collect1 = stringListMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, item -> item.getValue().stream().map(Integer::parseInt).reduce(2, (a, b) -> a * b)));
        System.out.println("collect1 = " + collect1);

        List<Transaction> transactions = Arrays.asList(
                new Transaction(100 ,  LocalDate.of(2023, 12, 1)),
                new Transaction(100 ,  LocalDate.of(2023, 11, 1)),
                new Transaction(100 ,  LocalDate.of(2023, 11, 1)),
                new Transaction(100 ,  LocalDate.of(2023, 12, 1)),
                new Transaction(100 ,  LocalDate.of(2023, 12, 1))
        );


        Map<LocalDate,Double> collect2 = transactions.stream().collect(Collectors.groupingBy(Transaction::getLocalDate)).entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, item -> item.getValue().stream().map(Transaction::getValue).collect(Collectors.summarizingInt(Integer::intValue)).getAverage()));

        Integer i2 = transactions.stream().collect(Collectors.groupingBy(Transaction::getLocalDate, Collectors.summingInt(Transaction::getValue))).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getValue).orElse(null);
        System.out.println("i2 = " + i2);

        System.out.println("collect2 = " + collect2);

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "IT", 70000),
                new Employee("Bob", "HR", 50000),
                new Employee("Charlie", "IT", 80000),
                new Employee("David", "Finance", 60000),
                new Employee("Eve", "HR", 55000)
        );

        String s = employees.stream().collect(Collectors.groupingBy(Employee::dept)).entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, value -> value.getValue().stream().mapToInt(Employee::salary).sum())).entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).map(Map.Entry::getKey).orElse(null);
        System.out.println("s = " + s);

        String s1 = employees.stream().collect(Collectors.groupingBy(Employee::dept, Collectors.summingInt(Employee::salary))).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
        System.out.println("s1 = " + s1);

        Map<String, List<Employee>> collect5 = employees.stream().collect(Collectors.groupingBy(Employee::dept));
        collect5.forEach( (k , v) -> {
            Employee employee = v.stream().max(Comparator.comparing(item -> item.salary)).orElse(null);
            System.out.println("dept === >"+k + " employee = " + employee);
        });
        List<Employee> list1 = employees.stream().sorted(Comparator.comparing((Employee e) -> e.salary).thenComparing(employee -> employee.name)).toList();
        System.out.println("list1 = " + list1);
        Map<String, Employee> collect3 = employees.stream().collect(Collectors.groupingBy(Employee::dept)).entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, value -> value.getValue().stream().max(Comparator.comparing(item -> item.salary)).orElse(null))).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::salary).reversed())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue , (p , c) -> p, LinkedHashMap::new));
        System.out.println("collect3 = " + collect3);

        boolean[] boolean1 = new boolean[120];

        System.out.println("boolean1 = " + Arrays.toString(boolean1));

        List<Integer> numbers = Arrays.asList(5,8,12,12,12,3,3,10,8);

        Integer i = numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(0).findFirst().orElse(null);
        System.out.println("i = " + i);

        List<Integer> list = numbers.stream().distinct().toList();
        System.out.println("list = " + list);


        Integer i1 = numbers.stream().collect(Collectors.groupingBy(Integer::valueOf, Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (p, e) -> p, LinkedHashMap::new)).keySet().stream().skip(1).findFirst().orElse(null);
        System.out.println("collect3 = " + i1);


        List<String> a =Collections.singletonList("a");

        List<String> b = new ArrayList<>();
        b.add("a");
        a.stream().forEach(b::remove);

        System.out.println("b = " + b);




        String string = "a"; //string constant pool
        string = string.concat("a");
        System.out.println("string = " + string);

        int x = -1;

        x -= (-5);

        System.out.println("x = " + x);
        LocalTime time = LocalTime.now(); // Get current time
        int minutes = time.getHour() * 60 + time.getMinute();
        if (minutes % 2 ==0){
            System.out.println("EVEN");
        }else{
            System.out.println("ODD");
        }

        WeakHashMap<String, String> weakMap = new WeakHashMap<>();
        String key1 = new String("1");
        String key2 =new String("2");

        weakMap.put(key1, "Value 1");
        weakMap.put(key2, "Value 2");

        System.out.println("Before GC: " + weakMap);

        key1 = null; // Remove strong reference
        System.gc(); // Request Garbage Collection
        Thread.sleep(1000); // Give GC some time

        System.out.println("After GC: " + weakMap);

        Engine engine = new Engine("Hegin"){
            @Override
            void hello(){
                String name1 = this.name;
                System.out.println("name1 = " + name1);
            }
        };
        engine.hello();


        long startTime = System.currentTimeMillis();






//        int i1 = Runtime.getRuntime().availableProcessors();

        /*System.out.println("i1 = " + i1);
        for (int i = 0 ; i < 24_000 ; i++){



            try(ExecutorService executorService = Executors.newFixedThreadPool(i1)){
                executorService.execute(() -> {
                    Thread current = Thread.currentThread();
                    System.out.println("My Name  =" + current.getName());
                    try {
                        current.wait(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                });
            }
        }*/
        long endTime = System.currentTimeMillis();

        System.out.println("final time -= " +(endTime - startTime) / 1000 );


        int[] arr = {1, 2, 3, 5, 6};  // Missing 3

        int missingNumber = findMissingNumber(arr, arr[arr.length - 1]);

        System.out.println("missingNumber = " + missingNumber);

    }

    public static abstract class Engine {
        String name;
        public  Engine (String name){
            this.name = name;
        }
        abstract void hello();

    }
    public static int findMissingNumber(int[] arr, int n) {
        int expectedSum = n * (n + 1) / 2;// Sum formula
        System.out.println("expectedSum = " + expectedSum);
        int actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        System.out.println("actualSum = " + actualSum);

        return expectedSum - actualSum;  // Missing number
    }
    public record Employee(String name , String dept , Integer salary){}

}

