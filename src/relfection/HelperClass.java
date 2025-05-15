package relfection;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class HelperClass{



    public  static <T> String  methodFounder( T instance , String headerName){
        System.out.println("instance  = " + instance);
        System.out.println("headerName = " + headerName);



        return "getPhoneNumber";
    }

    public static void main(String[] args) {
        int i = 11001;

        int digit =0;
        i = Math.abs(i);
        while (i > 0){
            i /= 10;
            digit++;
        }


        System.out.println("digit = " + digit);

        int decimal  = 0 , power = 0 ;
        while (i > 0 ){
            int remainder = i % 10;

            if (remainder !=0 && remainder != 1){
                System.out.println(" Invalid number" );
                return;
            }
            decimal += remainder * (1 << power);
            i /= 10;
            power ++;
        }
        System.out.println("decimal = " + decimal);


        List<String> collect = Stream.of("A", "B", "D").map(String::valueOf).collect(Collectors.toList());

        Stream<String> stringStream = Stream.of("a","a");
        String collect1 = stringStream.collect(Collectors.joining());
        System.out.println("collect1 = " + collect1);
        Student student1 = new Student("A",1,1d);
        Student student2 = new Student("A",1,1d);

        Map<Student , String> studentStringMap = new HashMap<>();

        studentStringMap.put(student2 , "1");
        studentStringMap.put(student1 , "2");
        studentStringMap.put(new Student() , "3");
        studentStringMap.put(new Student() , "4");

        String s = studentStringMap.get(student1);
        System.out.println("s = " + s);

        for (Map.Entry<Student, String> studentStringEntry : studentStringMap.entrySet()) {
            System.out.println("Key = {}" + studentStringEntry.getKey());
            System.out.println("Value= {}" + studentStringEntry.getValue());
        }
        Map<String , Object> stringObjectMap = new HashMap<>();

        String a = (String) stringObjectMap.getOrDefault("a", null);
        System.out.println("a = " + a);
        Set<Student> students = new HashSet<>();

        students.add(student1);
        students.add(student2);
        System.out.println("students = " + students);




    }



    public void mergeSort(int[] array){


        int middle = array.length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray  =new int[array.length - middle];

        int i= 0  , j = 0;
        for ( ; i < array.length ; i++){
            if (i < middle){
                leftArray[i] = array[i];
            }else {
                rightArray[j] = array[i];
                j++;
            }
        }

        mergeSort(leftArray);
        mergeSort(rightArray);

        int againLeftSize = array.length / 2;
        int againRightSize = array.length - againLeftSize;

        int flag = 0 , l = 0  , r = 0 ;
         while (l < againLeftSize && r > againRightSize){

             if (leftArray[l] < rightArray[r]){
                 array[flag] = leftArray[l];
                 flag++;
                 l++;
             }else {
                 array[flag] = rightArray[r];
                 flag++;
                 r++;
             }

         }
         while (l < againLeftSize){
             array[flag] = leftArray[l];
             l++;
             flag++;
         }
        while (r < againRightSize){
            array[flag] = rightArray[r];
            r++;
            flag++;
        }


    }

}
