package interviewQuestions;

import java.util.*;

public class Main {


    public static void main(String[] args) {

//    1) length of the longest sub string
        /*int i = lengthOfLongestSubstring("pwwkew");
        System.out.println("i = " + i);*/


//    2_
//        findMedianSortedArrays();


//        3_
//        twoSum();

//        4_

    }

    private static ListNode AddTwoNumbers(){
        ListNode listNode1 = new ListNode(1);


        return null;
    }

    public static void twoSum(){

        int[] nums = {2, 7, 11, 15};;
        int target = 9;

        HashMap<Integer , Integer> integerHashMap  = new HashMap<>();



        for (int i = 0 ; i< nums.length ;i++){
            int value = nums[i];

            int compliment = target - value;

            if (integerHashMap.containsKey(compliment)){
                int[] ints  = {integerHashMap.get(compliment) , i};

            }

            integerHashMap.put(value , i);


        }

        for (int i = 0 ; i < nums.length ; i ++){

            int value = nums[i];
            int complement = target - value;


            if (integerHashMap.containsKey(complement)){
                int[] ints = {integerHashMap.get(complement), i};
                System.out.println("ints = " + Arrays.toString(ints));
                break;
            }
            integerHashMap.put(value , i);


        }


    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>(); // To store unique characters in the current window
        int left = 0; // Left pointer of the sliding window
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left)); // Remove the leftmost character
                left++; // Move the left pointer forward
            }
            charSet.add(s.charAt(right)); // Add the current character to the set
            maxLength = Math.max(maxLength, right - left + 1); // Update the max length
        }

        return maxLength;
    }



    public static void findMedianSortedArrays() {
        int[] nums1 = {1,3}, nums2 = {2};



        int[] finalNums = new int[nums1.length + nums2.length];
        int index = 0;
        for (int i = 0 ; i < nums1.length ; i ++){
            finalNums[index++]=nums1[i];
        }
        for (int i = 0 ; i < nums2.length ; i ++){
            finalNums[index++]=nums2[i];
        }


        System.out.println("finalNums = " + Arrays.toString(finalNums));


    }

}
