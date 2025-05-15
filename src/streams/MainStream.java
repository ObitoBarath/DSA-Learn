package streams;


import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class MainStream  implements Serializable , Externalizable {


    public void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Predicate<Integer> oddFinder = input -> input % 2 != 0;
        List<Integer> list = numbers.stream().filter(oddFinder).toList();
        System.out.println("Odd list  = " + list);


        List<String> names = Arrays.asList("Jack", "Alice", "John", "Bob");
        List<String> j = names.stream().filter(item -> item.startsWith("J")).toList();
        System.out.println("j = " + j);

        List<Integer> findAllPrimeNumber = Arrays.asList(10, 15, 7, 19, 21, 13);

        List<Integer> collect = findAllPrimeNumber.stream().filter(item -> {
            if (item < 2) return false;
            return IntStream.range(2, item).noneMatch(i -> item % i == 0);

        }).collect(Collectors.toUnmodifiableList());
        System.out.println("collect = " + collect);
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 60000),
                new Employee("Bob", 45000),
                new Employee("Charlie", 70000)
        );

        Employee employee = employees.stream().filter(item -> item.salary >= 45000).findFirst().orElse(new Employee("0", 0));
        System.out.println("employee = " + employee);

        List<Transaction> transactions = Arrays.asList(
                new Transaction(1200, LocalDate.now().minusDays(3)),
                new Transaction(900, LocalDate.now().minusDays(10)),
                new Transaction(2000, LocalDate.now().minusDays(5)),
                new Transaction(2000, LocalDate.now().minusDays(5)),
                new Transaction(2000, LocalDate.now().minusDays(5))
        );


        transactions.stream().collect(Collectors.groupingBy(Transaction::getLocalDate , Collectors.summingInt(Transaction::getValue)));

        System.out.println("transactions = " + transactions);

        System.out.println("transactions = " + transactions);
        LocalDate localDate = LocalDate.now().minusDays(10);;
        int dayOfMonth = localDate.getDayOfMonth();
        System.out.println("dayOfMonth = " + dayOfMonth);

        Transaction transaction = transactions.stream().filter(item -> item.getValue() > 1000 && (IntStream.range(item.getLocalDate().getDayOfMonth()  , LocalDate.now().getDayOfMonth()).count() <= 7 )).findFirst().orElse(null);
        transactions.sort(Comparator.comparing(Transaction::getLocalDate).thenComparing(Transaction::getValue));
        Set<Integer> setTransaction  = new HashSet<>();
        List<Transaction> list1 = transactions.stream().filter(item -> !setTransaction.add(item.getValue())).toList();
        System.out.println("list1 = " + list1);
        setTransaction.forEach(System.out::println);
        System.out.println("transaction = " + transaction);
        System.out.println("transactionstransactionstransactionstransactions .entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue().stream().mapToInt(Transaction::getValue).sum() , Integer::sum));= " + transactions);


        List<String> words = Arrays.asList("ball", "apple", "banana", "cherry", "blueberry", "date");

        String s = words.stream().sorted().filter(item -> item.startsWith("b")).skip(2).findFirst().orElse(null);
        System.out.println("s = " + s);


        List<Integer> square = Arrays.asList(2, 3, 4);

        square = square.stream().map(item -> item * 2).toList();
        System.out.println("square = " + square);
        List<String> upperNames = Arrays.asList("john", "alice", "bob").stream().map(item -> {
             return item.substring(0 , 1).toUpperCase(Locale.ROOT) + item.substring(1).toLowerCase();
        }).toList();
        System.out.println("upperNames = " + upperNames);

        List<String> list2 = Arrays.asList(
                new Employee("Alice", 50000),
                new Employee("Bob", 60000)
        ).stream().map(item -> item.name).toList();
        System.out.println("list2 = " + list2);
        List<LocalDate> dates = Arrays.asList(
                LocalDate.of(2023, 12, 1),
                LocalDate.of(2024, 1, 15)
        );
        List<DayOfWeek> list3 = dates.stream().map(LocalDate::getDayOfWeek).toList();
        System.out.println("list3 = " + list3);
        List<String> sortedWords = Arrays.asList("hello", "world", "java", "stream" , "abcd");


//        char[] charArray = "hello".toCharArray();


//        System.out.println("string = " + string);
        List<Integer> list4 = sortedWords.stream().filter(item -> {
            char[] charArray = item.toCharArray();
            return item.equals(IntStream.range(0, charArray.length).mapToObj(e -> String.valueOf(charArray[e])).sorted().collect(Collectors.joining()));
        }).map(item -> item.length()).toList();

        System.out.println("list4 = " + list4);
        List<Character> list5 = Arrays.asList("hello", "world").stream().flatMap(item -> item.chars().mapToObj(c -> (char) c)).toList();

        System.out.println("list5 = " + list5);


        List<List<Integer>> listOfList = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4)
        );
        List<Integer> list6 = listOfList.stream().flatMap(Collection::stream).toList();
        System.out.println("list6 = " + list6);

        List<String> sentences = Arrays.asList("hello world", "world of java", "hello java");
        List<String> collect1 = sentences.stream().flatMap(item -> Arrays.stream(item.split("\\s+"))).map(String::toLowerCase).distinct().toList();
        System.out.println("collect1 = " + collect1);

        List<User> users = Arrays.asList(
                new User("Alice", Arrays.asList("123", "456")),
                new User("Bob", List.of("789"))
        );



        List<String> list7 = users.stream().map(item -> item.phoneNumber).flatMap(item -> item.stream()).toList();
        System.out.println("list7 = " + list7);

        Map<String, String> collect2 = users.stream().collect(Collectors.toMap(
                o1 -> o1.name,
                o2 -> o2.phoneNumber.stream().flatMap(item -> item.describeConstable().stream()).collect(Collectors.joining())
        ));
        System.out.println("collect2 = " + collect2);


        /*List<Employee> employees1 = Arrays.asList(
                new Employee("Alice", Arrays.asList("ProjectX", "ProjectY")),
                new Employee("Bob", Arrays.asList("ProjectY", "ProjectZ" , "ProjectW"))
        );*/
/*
        Map<String, Long> collect3 = employees1.stream().collect(Collectors.toMap(
                o1 -> o1.name,
                o2 -> o2.projects.stream().flatMap(item -> item.describeConstable().stream()).count()
        ));*/

        String csv = "Alice,25 ; Bob,30 ; Charlie,22";


        Map<String, String> collect4 = Arrays.stream(csv.split(";")).map(item -> item.split(",")).collect(Collectors.toMap(
                k -> k[0],
                v -> v[1]
        ));
        System.out.println("collect4 = " + collect4);


//        System.out.println("collect3 = " + collect3);
//        System.out.println("collect4 = " + collect4);


        List<Integer> toBeSorted = Arrays.asList(5, 2, 8, 1);

        toBeSorted.sort(Comparator.comparing(Integer::intValue));

        System.out.println("toBeSorted = " + toBeSorted);


        toBeSorted.sort(Comparator.reverseOrder());
        System.out.println("toBeSorted = " + toBeSorted);



        List<Employee> sortBySalary = Arrays.asList(
                new Employee("Alice", 40000),
                new Employee("Bob", 60000),
                new Employee("Charlie", 50000)
        );


        sortBySalary.sort(Comparator.comparing(item -> item.salary));
        System.out.println("sortBySalary = " + sortBySalary);


        sortBySalary.sort(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary));
        System.out.println("sortBy name & Salary = " + sortBySalary);
        List<String> vowelsSort = Arrays.asList("banana", "apple", "cherry", "orange");


        List<String> list8 = vowelsSort.stream().sorted(Comparator.comparingInt(MainStream::countVowels)).toList();
        System.out.println("list8 = " + list8);


        String input = "apple";
        Map<Character, Long> collect5 = input.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("collect5 = " + collect5);


        List<Integer> list9 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list10 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list11 = Stream.concat(list9.stream(), list10.stream())
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(item -> item.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();


        String palindrome = "malaalam";

        System.out.println(palindrome.equalsIgnoreCase(new StringBuffer(palindrome).reverse().toString()));


        List<Integer> list12 = list9.stream().filter(list10::contains).toList();
        System.out.println("list12 = " + list12);
        System.out.println("list11 = " + list11);


        Vector<String>  strings = new Vector<>();

        strings.add("a");
        strings.add("a");
        strings.add("a");
        strings.add("a");
        strings.addElement("a");
        strings.insertElementAt("1",1);


        List<Employee> department = Arrays.asList(
                new Employee("Alice", "A",40000 ),
                new Employee("Bob","A", 60000),
                new Employee("Charlie","B", 50000),
                new Employee("Charlie","B", 20000)
        );

//        department.stream().collect(Collectors.groupingBy(Employee::getDepartment , Collectors.ma));
        System.out.println("strings = " + strings);




    }

    private static int  countVowels(String word) {
        return (int) word.toLowerCase()
                .chars()
                .filter(c -> "aeiou".indexOf(c) != -1)
                .count();
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        MainStream out1 = (MainStream) out;
        out1.writeExternal(out);

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int read = in.read();


    }

    static class Employee {
        String name;
        int salary;
        String department;
        Employee(String name, int salary) { this.name = name; this.salary = salary; }
        Employee(String name , String department , int salary){
            this.name = name;
            this.department = department;
            this.salary = salary;
        }


        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public String getProjects() {
            return department;
        }

        public void setProjects(String projects) {
            this.department = projects;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    ", department=" + department +
                    '}';
        }
    }






}

