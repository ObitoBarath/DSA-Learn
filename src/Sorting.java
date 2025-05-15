import HashTables.HashTables;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static java.util.stream.Collectors.maxBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sorting {

    public void bubbleSortAlgo() {
        int[] unSortedArray = new int[]{12, 213, 123, 1, 5231, 42, 512, 5, 6};

        for (int i = 0; i < unSortedArray.length; i++) {

            for (int j = i + 1; j < unSortedArray.length; j++) {
                if (unSortedArray[i] > unSortedArray[j]) {
                    int temp = unSortedArray[j];
                    unSortedArray[j] = unSortedArray[i];
                    unSortedArray[i] = temp;
                    System.out.println("unSortedArray = " + Arrays.toString(unSortedArray));
                }
            }
        }


    }


    public void bubbleSortAlgoUsingRecursion() {
        int[] array = new int[]{1, 213, 124, 15, 1521, 3};
        int i = 0, j = 0;
        System.out.println("array = " + array.length);
        bubbleRecursion(array, i, j, array.length);
        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
    }

    public void bubbleRecursion(int[] array, int i, int j, int n) {

        if (i == n - 1) {
            return;
        }

        if (j == n) {

            i++;
            j = i;

        }

        if (array[i] > array[j]) {

            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;


        }

        j += 1;

        bubbleRecursion(array, i, j, n);


    }


    public void selectionSortAlgo() {
        int[] array = new int[]{ 12, 214, 12, 16161661, 5, 6  };

        int minimumValue = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            minimumValue = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minimumValue] > array[j]) {
                    minimumValue = j;
                }
            }
            int temp = array[minimumValue];
            array[minimumValue] = array[i];
            array[i] = temp;
        }
        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
    }

    public void insertionSortAlgo() {
        int[] array = {900, 24, 115, 12, 125, 123};

        for (int i = 1; i < array.length; i++) {

            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }

        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
    }

    public void mergeSortAlgo() {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        splittingIntoHalf(array);
//        mergeSort(array);
        System.out.println(STR."Arrays.toString(array) = \{Arrays.toString(array)}");
    }

    public void splittingIntoHalf(int[] array) {
        int middle = array.length / 2;


        if (array.length <= 1) return;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[array.length - middle];

        int i = 0, j = 0;

        for (; i < array.length; i++) {
            if (i < middle) {
                leftArray[i] = array[i];
            } else {
                rightArray[j] = array[i];
                j++;
            }
        }

        splittingIntoHalf(leftArray);

        splittingIntoHalf(rightArray);

        mergeTheHalfArrays(leftArray, rightArray, array);
    }

    public void mergeTheHalfArrays(int[] leftArray, int[] rightArray, int[] array) {
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0;

        while (l < leftSize && r < rightSize) {

            if (leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while (l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while (r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }

        System.out.println("array = " + Arrays.toString(array));

    }

    private static void mergeSort(int[] array) {

        int length = array.length;
        if (length <= 1) return; //base case

        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0; //left array
        int j = 0; //right array

        for (; i < length; i++) {
            if (i < middle) {
                leftArray[i] = array[i];
            } else {
                rightArray[j] = array[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array) {

        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0; //indices

        //check the conditions for merging
        while (l < leftSize && r < rightSize) {
            if (leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while (l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while (r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }

    public void main(String[] args) throws ClassNotFoundException {




//        bubbleSortAlgo();
//        bubbleSortAlgoUsingRecursion();
//        selectionSortAlgo();
//        insertionSortAlgo();

        System.out.println("Hello");
        mergeSortAlgo();

        String string = "CuMar";


        char[] charArray = string.toCharArray();

        StringBuilder newString = new StringBuilder();
        for (char c : charArray) {


            char start = Character.isUpperCase(c) ? 'A' : 'a'; // Determine the alphabet's starting point
            newString.append((char) (((c - start - 3 + 26) % 26) + start));
        }
        System.out.println("newString = " + newString);


        int[] arr = {2, 5, 7};
//        0,1,2,3,4,5,6,7
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, n, i);
        }

        System.out.println("n = " + Arrays.toString(arr));

        int k = 5;
        int kCounter = 0;
        for (int i = 0; i < arr[n - 1]; i++) {

            System.out.println("i = " + i);

            if (!searchArray(arr, i)) {
                kCounter++;
            }

            if (kCounter == k) {
                System.out.println("found = " + i);
                return;
            }
        }

        String decodeString = "2[abc]3[cd]ef";

        StringBuilder stringBuilder = new StringBuilder();

        char[] charArray1 = decodeString.toCharArray();
        for (int i = 0; i < charArray1.length; i++) {
            System.out.println("char  = " + charArray1[i]);
            if (Character.isDigit(charArray1[i])) {
                String substring = decodeString.substring(i + 1);
                String splittedString = substring.split("]")[0];

                String string1 = splittedString.split("\\[")[1];
                String countAsString = String.valueOf(charArray1[i]);
                int count = Integer.parseInt(countAsString);
                System.out.println("countAsString = " + countAsString + " string1 =" + string1);
                stringBuilder.append(getMultipliedString(count, string1));

            }
        }
        String[] split = decodeString.split("]");


        Pattern pattern = Pattern.compile("-?\\\\d+");


        Arrays.stream(split).map(item -> {
            Matcher matcher = pattern.matcher(item);
            System.out.println("matcher = " + matcher);
            return item;
        });

        Map<String, Integer> stringIntegerMap = new Hashtable<>();
        TreeMap<Student, Integer> stringIntegerTreeMap = new TreeMap<>();

        stringIntegerMap.put("1", 1);
        stringIntegerMap.put("4", 2);
        stringIntegerMap.put("1", 3);
        stringIntegerMap.put("2", 4);
        stringIntegerMap.put("1", 5);
        stringIntegerMap.put("1", 6);


        stringIntegerTreeMap.put(new Student("1"), 1);
        stringIntegerTreeMap.put(new Student("4"), 2);
        stringIntegerTreeMap.put(new Student("1"), 3);
        stringIntegerTreeMap.put(new Student("2"), 4);
        stringIntegerTreeMap.put(new Student("1"), 5);
        stringIntegerTreeMap.put(new Student("1"), 6);

     /*   System.out.println("stringIntegerMap" + stringIntegerMap);
        System.out.println("stringIntegerTreeMap" + stringIntegerTreeMap);
        System.out.println("stringIntegerTreeMap get " + stringIntegerTreeMap.get(new Student("1")));
//        System.out.println("stringIntegerTreeMap" + stringIntegerTreeMap);


        stringBuilder.append(split[split.length - 1]);
        System.out.println("stringBuilder = " + stringBuilder);*/


        int[] availabletime = {1, 2, 3}; // available times of 3 workers
        int[] processtime = {4, 5, 6, 7, 8, 9, 10, 11, 12}; // 9 tasks

        int minTime = findMinimumTime(availabletime, processtime);
//        System.out.println("Minimum time to finish all work: " + minTime);

//        GFG();
//        GFG1();
//        GFG2();
        hackerRank1();
    }

    public static void hackerRank1(){
/*
        String input = "12:01:00AM";

        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("hh:mm:ssa");
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalTime localDateTime = LocalTime.parse(input , inputFormat);
        System.out.println("localDateTime = " + localDateTime);
*/

        String time12Hour = "12:01:00AM";

        // Define input and output formats
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("hh:mm:ssa"); // Matches the exact format
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("HH:mm:ss"); // 24-hour format

        try {
            // Parse the 12-hour format time into LocalTime
            LocalTime time = LocalTime.parse(time12Hour, inputFormat);

            // Format the time into 24-hour format
            String time24Hour = time.format(outputFormat);

            // Print the results
            System.out.println("12-hour format: " + time12Hour);
            System.out.println("24-hour format: " + time24Hour);
        } catch (Exception e) {
            System.out.println("Error parsing time: " + e.getMessage());
        }












        List<Integer> arr = Arrays.asList(7, 69, 2, 221, 8974);
        arr.sort((o1, o2) -> {
            return o1.compareTo(o2);
        });


        int minSum = 0;
        int maxSum = 0;
        int n = arr.size();

        int i = 0 ;
        int j = n-1;
        int k = 4;

        while(i < n){
            if(i < k){
                minSum += arr.get(i);
                System.out.println("j = " + j);
                maxSum += arr.get(j);
            }

            i++;
            j--;
        }

        System.out.print(minSum + " " + maxSum);
    }
    public static int findMinimumTime(int[] availabletime, int[] processtime) {
        // Step 1: Sort availabletime and processtime
        Arrays.sort(availabletime);
        Arrays.sort(processtime);

        // Step 2: Calculate minimum time to finish all tasks
        int n = availabletime.length;
        int minTime = 0;

        // Step 3: Iterate and assign tasks in batches of 4
        for (int i = 0; i < n; i++) {
            // Batch start index for the current worker
            int startIndex = i * 4;
            System.out.println("startIndex = " + startIndex);
            // The time taken for the worker i is availabletime[i] + maximum processing time in their batch
            int finishTimeForBatch = availabletime[i] + processtime[startIndex ]; // 4th element in each batch
            minTime = Math.max(minTime, finishTimeForBatch);
        }

        return minTime;
    }

    private void GFG(){


        int[] arr = {-1,-2,-3,-4,-5};

        int target = -8;
        int size = arr.length ;;
        int i = 0 , j = size -1 ;

        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));


        System.out.printf("Result: %.6f%n", 5.2/3);
        HashMap<Integer , Integer> integerIntegerHashMap = new HashMap<>();



        for (int i1 = 0; i1 < arr.length; i1++) {

            int expectedValue = target - arr[i1];
            System.out.println("expectedValue = " + expectedValue);

            if(integerIntegerHashMap.containsKey(expectedValue)){
                Integer i11 = integerIntegerHashMap.get(expectedValue);
                System.out.println("Found using hashmap [ "+i11 +" , "+i1+"]");
                return;
            }


            integerIntegerHashMap.put(arr[i1],  i1);
            System.out.println("integerIntegerHashMap = " + integerIntegerHashMap);

        }


        while (i < arr.length && j < arr.length){
            System.out.println("i"+i+", j"+j);
            if (i == size){
                System.out.println("Not found");
                return;
            }

            if (arr[i] + arr[j] == target){
                System.out.println("Found [ "+i +" , "+j+"]");
                return;
            }

            if (j-1 == i){
                j = size -1;
                System.out.println("    next    ");
                i++;
            }else {
                j--;
            }

        }


    }


    private void GFG1(){
        String input = "This is geeksforgeeks";

        String[] split = input.split(" ");

        StringBuffer stringBuffer = new StringBuffer();
        String reversedString = "" ;
        for (String s : split){
            System.out.println("s = " + s);
            stringBuffer = new StringBuffer();
            StringBuffer reverse = stringBuffer.append(s+" ").reverse();
            reversedString += reverse;
        }
        System.out.println("reversedString = " + reversedString);
    }
    private void GFG2(){


        Integer[] duplicated = {2,1,3,5,6,2,8,2,5};

        Set<Integer> integers = new HashSet<>(Arrays.asList(duplicated));

        System.out.println("integers = " + integers);
        System.out.println("size = " + integers.size());


    }

    private String getMultipliedString(int n, String s) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < n; i++) {
            string.append(s);
        }
        return string.toString();
    }


    private boolean searchArray(int[] array, int value) {
        for (int a : array) {
            if (a == value)
                return true;
        }
        return false;
    }


    private void heapify(int[] array, int size, int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;


        if (left < size && array[left] > array[largest]) {
            largest = left;
        }
        if (right < size && array[right] > array[largest]) {
            largest = right;
        }


        if (largest != index) {
            int temp = array[index];
            array[index] = array[largest];
            array[largest] = temp;
            heapify(array, size, largest);
        }


    }

    class Student implements Comparable<Student> {
        String name;

        public Student(String n) {
            this.name = n;
        }

        @Override
        public String toString(){
            return  "Student = { name  ="+ this.name +" }";
        }
        @Override
        public int compareTo(Student other){
            return this.name.compareTo(other.name);
        }
    }
}
