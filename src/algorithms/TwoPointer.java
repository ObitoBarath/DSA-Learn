package algorithms;


public class TwoPointer {

    public void twoSum() { //leetcode 1;

        /*int[] array = {2,7,11,15};
//        int[] array = {3,2,3};
        int target = 9 ;//6 ;



        int i =0;
        int j = array.length-1;

        while (i <= j){
            if (array[i] + array[j] == target){
                System.out.println("indices = [ " + i +","+ j+" ]");
                return;
            }else if (array[i] + array[j] < target) {
                i++;
            }else {
                j--;
            }
        }
        System.out.println("pairs not found ");*/

    }


    public void findTheClosestPairFromTwoSortedArray() { // GFG
//        int[] arr1 = {1, 4, 5, 7};
        int[] arr1 = {1, 4, 5, 7};
        int[] arr2 = {10, 20, 30, 40};
        int x = 50;

        int m = arr1.length ;
        int n = arr2.length ;

        int l = 0;
        int r = n - 1;

        int leftArrayIndex = 0;
        int rightArrayIndex = 0;

        int diff = Integer.MAX_VALUE;
        while (l < m && r >= 0) {
            if (Math.abs(arr1[l] + arr2[r] - x) < diff) {
                leftArrayIndex = l;
                rightArrayIndex = r;
                diff = Math.abs(arr1[l] + arr2[r] - x);
            }


            if (arr1[l] + arr2[r] > x) {
                r--;
            }else {
                l++;
            }
        }

        System.out.println("index = " + arr1[leftArrayIndex] +" , " +arr2[rightArrayIndex]);
        System.out.println("diff = " + diff);
    }


    public void main(String[] args) {
//        twoSum();
        findTheClosestPairFromTwoSortedArray();

    }


}
