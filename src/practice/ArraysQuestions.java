package practice;


import com.sun.source.tree.LiteralTree;

import java.util.*;
import java.util.stream.Collectors;

public class ArraysQuestions {


    public static void main(String[] args) {
        ArraysQuestions arraysQuestions = new ArraysQuestions();
//        arraysQuestions.trappingRainWater();


//        Map<String,Object>  stringObjectMap = new LinkedHashMap<>();

//        stringObjectMap.put("hello" , false);
//        System.out.println("stringObjectMap = " + stringObjectMap);
//        arraysQuestions.findMinimumAndMaximumOfArray();
//        arraysQuestions.reverseArray();
//        arraysQuestions.rotateArray();
//        int maximumProfit = arraysQuestions.findBestTimeToBuyAndSellStock(new int[]{7,1,5,3,6,4});
//        int maximumProfit = arraysQuestions.findBestTimeToBuyAndSellStockAndHold(new int[]{1,2,3,4,5});
//        System.out.println(maximumProfit);


//        arraysQuestions.arrayPermutation();
//        arraysQuestions.concatenationOfArray();
//        arraysQuestions.runningSumOf1dArray();
//        arraysQuestions.richestCustomerWealth();
//        arraysQuestions.shuffleTheArray();

//        arraysQuestions.kidsWithTheGreatestNumberOfCandies();
//        arraysQuestions.numberOfGoodPairs();
//        arraysQuestions.howManyNumbersAreSmallerThanTheCurrentNumber(); //todo
//        arraysQuestions.pangram();
//        arraysQuestions.trappingRainWater();
//        arraysQuestions.rotate3dArray();
//        arraysQuestions.longestCommonPrefix();
        arraysQuestions.validParenthesis();
    }


    public static int findBestTimeToBuyAndSellStockAndHold(int[] arrays) {


        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        int maxProfit = 0;

        for (int i = 0; i < arrays.length; i++) {
            System.out.println("minPrice = " + minPrice + " current price " + arrays[i]);
            if (minPrice < arrays[i]) {
                System.out.println("maxProfit = " + maxProfit);
                maxProfit += arrays[i] - minPrice;
                System.out.println("maxProfit = " + maxProfit);
            }

            minPrice = arrays[i];
            System.out.println("minPrice = " + minPrice);

        }
        return maxProfit;
    }

    public int maxProfit(int[] prices) {
        int max = 0;
        int start = prices[0];
        int len = prices.length;
        for (int i = 1; i < len; i++) {
            if (start < prices[i]) max += prices[i] - start;
            start = prices[i];
        }
        return max;
    }

    public static int findBestTimeToBuyAndSellStock(int[] arrays) {


        int minimumPrice = Integer.MAX_VALUE;
        int maximumPrice = 0;

        for (int i = 0; i < arrays.length; i++) {

            int currentPrice = arrays[i];

            if (currentPrice < minimumPrice) {
                minimumPrice = currentPrice;
                continue;
            }

            maximumPrice = Math.max(maximumPrice, currentPrice - minimumPrice);

        }
        return maximumPrice;

    }

    public void rotateArray() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int rotateCount = 2;
        int index = 0;

        int start = 0;
        int end = array.length - 1;


//        for (int i = 0 ; i < array.length ; i ++){
        int temp = array.length;
        array[array.length - 1] = array[0];
        array[0] = temp;


//        }


        System.out.println("rotated Array = {}" + Arrays.toString(array));


    }

    public void reverseArray() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};

        int start = 0;
        int end = array.length - 1;

        while (end > start) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }

        System.out.println("reversed Array = {}" + Arrays.toString(array));


    }

    public void findMinimumAndMaximumOfArray() {
        int[] array = {12312312, 1, 2, 1312, 3123123, 124, 24};

        if (array.length == 0 || array == null) {
            throw new IllegalArgumentException("Array is empty ");
        }
        /*Arrays.sort(array);
        System.out.println(STR." sorted array = \{Arrays.toString(array)}");

        System.out.println(STR."minimum = \{array[0]}");
        System.out.println(STR."maximum = \{array[array.length - 1]}");*/
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {

            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("max = " + max);
        System.out.println("min = " + min);


    }

    public void arrayPermutation() { //Leetcode 1920
        int[] array = new int[]{0, 2, 1, 5, 3, 4};
//        int[] array = new int[]{5,0,1,2,3,4};

        /* int[] newArray = new int[array.length];

        for (int i = 0  ; i < array.length ; i ++){
            newArray[i] = array[array[i]];
        }
        System.out.println("newArray = " + Arrays.toString(newArray));*/

        //cyclic in place permutation
/*
        int[] array = new int[]{0, 2, 1, 5, 3, 4};
        int n = array.length;

        for (int i = 0; i < n; i++) {
            while (array[i] != i) { // Swap elements until the correct value is at position i
                int temp = array[array[i]];
                array[array[i]] = array[i];
                array[i] = temp;
            }
        }


        System.out.println("Cyclic in place newArray = " + Arrays.toString(array));*/

        //encoding and decoding

        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] + (array[array[i]] % array.length) * array.length;

        }
        System.out.println("Encoded array = " + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] / array.length;

        }

        // Encode both old and new values in the array


        System.out.println("Decoded array = " + Arrays.toString(array));


    }


    public void permutation(int[] nums, int index) {
        if (index < nums.length) {
            nums[index] = nums[nums[index]];
            permutation(nums, index + 1);
        }

    }


    public void concatenationOfArray() { // Leetcode 1929
        int[] array = new int[]{1, 2, 1};

        int n = array.length;

        int count = 0;
        int[] newArray = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {

            if (count == n) {
                count = 0;
            }

            newArray[i] = array[count];
            count++;
        }
        System.out.println("newArray = " + Arrays.toString(newArray));


//        int[] newArrayCopy = new int[n*2];
//        System.arraycopy(array , 0 , newArray , 0 , n);
//        System.arraycopy(array , 0 , newArray , n , n);

        int[] ans = new int[array.length * 2];
        System.arraycopy(array, 0, ans, 0, array.length);
        System.out.println("Arrays.toString(ans) = " + Arrays.toString(ans));
        System.arraycopy(array, 0, ans, array.length, array.length);
        System.out.println("Arrays.toString(ans) = " + Arrays.toString(ans));


    }

    public void runningSumOf1dArray() { //leetcode   1480

        int[] array = new int[]{1, 2, 3, 4};

        int i = -1;
        for (int k = 0; k < array.length; k++) {

            if (k != 0) {
                array[k] = array[++i] + array[k];
            }
        }
        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
    }

    public void richestCustomerWealth() { //leetcode 1672
        int[][] array = new int[][]{{1, 2, 3}, {1, 2, 5}};

        System.out.println("Arrays.toString(array) = " + Arrays.deepToString(array));

        int customerWealth = 0;
        for (int i = 0; i < array.length; i++) {
            int wealth = 0;
            for (int i1 : array[i]) {
                wealth += i1;
            }

            if (customerWealth < wealth) {
                customerWealth = wealth;
            }
        }
        System.out.println("wealth = " + customerWealth);

    }

    public void shuffleTheArray() { //Leetcode 1470


        int[] array = new int[]{2, 5, 1, 3, 4, 7};
        int n = 3;


//        int[] newArray = new int[array.length];

        int arr[] = new int[2 * n];
        for (int i = 0; i < n; i++) {

            arr[i * 2] = array[i];
            arr[i * 2 + 1] = array[n + i];
        }

        System.out.println("Arrays.toString(array) = " + Arrays.toString(arr));

    }

    public void kidsWithTheGreatestNumberOfCandies() { //leetcode 1431
        int[] arrays = new int[]{2, 3, 5, 1, 3};
        int extraCandies = 3;
        int max = Integer.MIN_VALUE;

        List<Boolean> booleans = new ArrayList<>();
        for (int k = 0; k < arrays.length; k++) {

            if (max < arrays[k]) {
                max = arrays[k];
            }
        }

        for (int arr : arrays) {
            if (arr + extraCandies >= max) {
                booleans.add(true);
            } else {
                booleans.add(false);
            }
        }


    }

    public void numberOfGoodPairs() { //leet code 1512


        int[] array = new int[]{1, 2, 3, 1, 1, 3};
//        int[] array = new int[]{1,1,1,1,1,1};

        int numberOfGoodPairs = 0;

        for (int i = 0; i < array.length; i++) {

            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    numberOfGoodPairs++;
                }
            }
        }
        System.out.println("numberOfGoodPairs = " + numberOfGoodPairs);


        Map<Integer, Integer> integerIntegerMap = new LinkedHashMap<>();
        int numberOfPairs = 0;
        for (int i = 0; i < array.length; i++) {
            Integer i1 = integerIntegerMap.get(array[i]);
            if (i1 != null) {

                numberOfPairs += i1;
                integerIntegerMap.put(array[i], i1 + 1);
            } else {

                integerIntegerMap.put(array[i], 1);
            }
        }

        System.out.println("numberOfPairs = " + numberOfPairs);

    }

    public void howManyNumbersAreSmallerThanTheCurrentNumber() { //leetcode 1365


        int[] array = new int[]{8, 1, 2, 2, 3};

        int i = 0, j = 0, count = 0;
        int[] newArray = new int[array.length];

        twoPointerAlgorithm(i, j, array, count, newArray, array.length);

        System.out.println("newArray = " + Arrays.toString(newArray));
    }

    public void twoPointerAlgorithm(int i, int j, int[] array, int count, int[] newArray, int n) {

        if (i == array.length)
            return;

        if (j == n) {
            newArray[i] = count;
            System.out.println("count = " + count);
            count = 0;
            j = 0;
            i++;
        } else {

            System.out.println("j = " + j);

            if (array[i] < array[j]) {
                count += 1;
            }

            j += 1;
        }


        twoPointerAlgorithm(i, j, array, count, newArray, n);
    }

    public void pangram() { //leetcode 1832
        String input = "thequickbrownfoxjumpsoverthelazydog";

        String alphabets = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < alphabets.length(); i++) {

            if (input.indexOf(alphabets.charAt(i)) == -1) {
                //return false;
            }
        }

    }

    public void trappingRainWater() {
        int[] array = {3, 0, 1, 0, 4, 0, 2};

        int[] arr = {2, 1, 5, 3, 1, 0, 4};


        int n = arr.length;

        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            int left = arr[i];

            for (int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }

            int right = arr[i];
            for (int j = i + 1; j < n; j++) {
                right = Math.max(right, arr[j]);
            }

            res += Math.min(left, right) - arr[i];
        }
        System.out.println("res = " + res);

        int left = 1;
        int right = n - 2;
        int lMax = arr[left - 1];
        int rMax = arr[right + 1];
        int result = 0;


        while (left <= right) {
            if (rMax <= lMax) {
                result += Math.max(0, rMax - arr[right]);
                rMax = Math.max(rMax, arr[right]);
                right -= 1;
            } else {
                result += Math.max(0, lMax - arr[left]);
                lMax = Math.max(lMax, arr[left]);
                left += 1;
            }
        }
        System.out.println("result = " + result);




 /*       int left  =1;
        int right  = array.length -2;

        int lMax = array[left -1];
        int rMax = array[right +1];


        int result =0 ;
        while (left <= right){

            if (lMax <= rMax){
//                result
            }
        }





*/


    }


    public static void rotate3dArray() {
        int[][] matrix = {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3},
        };
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
        System.out.println("Arrays.deepToString(matrix) = " + Arrays.deepToString(matrix));

    }

    public void palindrome() {
        int x = 121;


        System.out.println(String.valueOf(x).equalsIgnoreCase(new StringBuilder(String.valueOf(x)).reverse().toString()));
    }

public void validParenthesis(){
        String s = "(]";//"()[]{}";
    String a = "{([])}";
        Stack<Character> stacks = new Stack<>();

        char[] charArray = s.toCharArray();


        for(char c : charArray){

            if(Arrays.asList('[','(','{').contains(c)){
                stacks.push(c);
                System.out.println("stacks = " + stacks);
            }else {


                if (stacks.isEmpty() || (c == ')' && stacks.pop() != '(') ||(c == '}' && stacks.pop() != '{') || (c == ']' && stacks.pop() != '[')) {
                    System.out.println("stacks = " + stacks);
                    System.out.println("false");
                    return ;
                }


            }

        }


    System.out.println(stacks.isEmpty());




}
    public void longestCommonPrefix() {
        String[] strings = {"flower", "flow", "flight"};



        StringBuilder stringBuilder = new StringBuilder();

        Arrays.sort(strings);

        int n = strings.length;
        String first = strings[0];
        String last = strings[n-1];



        for (int i = 0 ;  i < Math.min(first.length() , last.length()) ; i++){


            if (first.charAt(i) != last.charAt(i)){
                System.out.println("Longest prefix ="+stringBuilder.toString());
                return;
            }
            stringBuilder.append(first.charAt(i));
        }
        System.out.println("Longest prefix = "+stringBuilder.toString());




}


}
