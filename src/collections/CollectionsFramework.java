package collections;
import javax.lang.model.type.MirroredTypeException;
import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

interface InterfaceClassA {
     void hello();

    default void say() {

    }
}
class TemplateCLass{
    public  void hello(){

    }
}
interface InterfaceClassB  {
    void hello();

    default void say() {

    }
}
abstract class AbstractClass{
    abstract  void hello();
}


public class CollectionsFramework  extends TemplateCLass {


    public static void main(String[] args) {

        int[] array = {1,2,3,5,6};

        int i = Arrays.stream(array).max().orElseThrow();

        System.out.println("i = " + i);

        Integer i1 = Arrays.stream(array).distinct().boxed().sorted((Comparator.reverseOrder())).skip(1).findFirst().orElseThrow(() -> new IllegalArgumentException(""));
        System.out.println("i1 = " + i1);


        String password = "aaabbbccdd";


        StringBuilder stringBuilder = new StringBuilder();


        int length = password.length();
        int start = 1;
        int letterCount = 1;
        while (start < length){

            if (password.charAt(start) == password.charAt(start -1)){
                letterCount ++;
            }else {
                stringBuilder.append(password.charAt(start-1)).append(letterCount);
                letterCount =1;
            }
            start ++;
        }

        stringBuilder.append(password.charAt(length-1)).append(letterCount);

        System.out.println("stringBuilder.toString() = " + stringBuilder);


        StringBuilder decompressString = new StringBuilder();

        int compressedStringLength = stringBuilder.length();

        String compressedString  = stringBuilder.toString();

        int startIndex = 0;
        while (startIndex <  compressedStringLength){

            if (Character.isDigit(compressedString.charAt(startIndex)))
            {

                int finalStartIndex = startIndex;

                char c = compressedString.charAt(startIndex);

                IntStream.range(0 ,Integer.parseInt(String.valueOf(c))).forEach(item -> {
                    decompressString.append(compressedString.charAt(finalStartIndex -1));
                });

            }

            startIndex ++;
        }
        System.out.println("decompressString = " + decompressString);







        /*List<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");



        List<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");


        Vector<String> vector = new Vector<>(); // synchronized version of arraylist (Thread Safe)
        vector.addElement("1");
        vector.add("1");

        Stack<String> stack = new Stack<>();
        stack.add("asdsad");





ArrayDeque<String>  strings = new ArrayDeque<>();
strings.addFirst("");
strings.removeFirst();
strings.removeLast();
//strings.get


      SortedSet<String> strings1 = new TreeSet<>();





*/


    }

    @Override
    public void hello() {

    }

//    static {
//        /*int offsetMark = 3;
//        int[] questionPaper = {2 , 2 , 4};
//
//        Set<Integer> collect = Arrays.stream(questionPaper).boxed().collect(Collectors.toSet());
//        int i =  questionPaper.length -collect.size() ;
//        int sum = collect.stream().mapToInt(Integer::intValue).sum();
//
//
//        for (int k = 0 ; k < i ;k++){
//            sum += offsetMark;
//        }
//
//        System.out.println("sum = " + sum);*/
//
//
//        String input = "malayalam";
//
//        System.out.println("makePalindrome(input) = " + makePalindrome(input));
//
//
//    }
    public static String makePalindrome(String input) {
        Map<Character, Integer> charCount = new HashMap<>();

        // Count character frequencies
        for (char c : input.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        System.out.println("charCount = " + charCount);
        StringBuilder firstHalf = new StringBuilder();
        String middleChar = "";

        // Construct palindrome parts
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();
            System.out.println("count = " + count);
            if (count % 2 != 0) {
                System.out.println("middleChar = " + middleChar);
                if (!middleChar.isEmpty()) {
                    return "Cannot form a palindrome";
                }
                middleChar = String.valueOf(ch);
            }
            System.out.println("count = " + count);
            for (int i = 0; i < count / 2; i++) {
                firstHalf.append(ch);
            }
            System.out.println("firstHalf = " + firstHalf);
        }

        // Construct the final palindrome
        String secondHalf = new StringBuilder(firstHalf).reverse().toString();
        return firstHalf + middleChar + secondHalf;
    }

    static {



        int[] array = {3,7,8,5};
        String intern = "Original";
        Integer[] array1 = Arrays.stream(array).boxed().toArray(Integer[]::new);

        Arrays.sort( array1, Comparator.comparingInt(Integer::bitCount));
        System.out.println("array1 = " + Arrays.toString( array1));

    }




}
