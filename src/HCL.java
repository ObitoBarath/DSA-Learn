import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Student implements Comparator<Student> , Comparable<String>{

    public String name;


    @Override
    public int compare(Student o1, Student o2) {
        return 0;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}

public class HCL  extends TCS {




    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2025, 13, 123);



        String nonRepeatingChars = "geeksforgeeks";
        Character c = nonRepeatingChars.chars().mapToObj(item -> (char) item).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet().stream().filter(item -> item.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);
        System.out.println("c = " + c);
        String[] duplicateString = {"a" , "b" , "c" , "a" };
        Set<String> strings = new HashSet<>();

        List<String> collect = Arrays.stream(duplicateString).filter(item -> !strings.add(item)).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }
}
