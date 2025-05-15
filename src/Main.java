import java.util.*;

public class Main extends Fibonacci {

    public void main(String[] args) {

        /*super.findNthFibonacci(10);

        int  L =0 , R = 25  ,d =3 , k =1  ;

        int count = 0;

        String target = Integer.toString(d);

        for (int  i = L ; i <= R ; i ++ ){


            String string = Integer.toString(i);

            count += (int) string.chars().filter(c -> c == target.charAt(0)).count();

        }
        System.out.println("count = " + count);*/
//        encodePassword();
        spiralTraversalInArray();
    }

    private void spiralTraversalInArray(){
        int[][] arr = {
                {1,2,3,4},
                {12,13,14,5},
                {11,16,15,6},
                {10,9,8,7},
        };

        List<Integer> list = clockwiseSpiralOrder(arr);

        System.out.println("list = " + list);

    }

    public static List<Integer> clockwiseSpiralOrder(int[][] matrix){
        LinkedList<Integer> integers  = new LinkedList<>();

        int top = 0 , left = 0 ;
        int bottom = matrix.length -1 , right = matrix[0].length -1;


        while (top <= bottom && left <= right){

            for (int i = left ; i <= right ; i++){
                integers.add(matrix[top][i]);
            }
            top ++;
            for (int i = top ; i <= bottom ; i ++){
                integers.add(matrix[i][right]);
            }
            right --;

            if (top <= bottom){

                for (int i =  right ; i >= left ; i--){

                    integers.add(matrix[bottom][i]);

                }

                bottom --;

            }

            if (left <= right){
                for (int i = bottom ; i >= top ; i--){
                    integers.add(matrix[i][left]);
                }
                left ++;
            }


        }


        return  integers;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        System.out.println("bottom = " + bottom);
        System.out.println("right" + right);

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                // Traverse from right to left
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                // Traverse from bottom to top
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    private void encodePassword(){
        String input = "222333445522";


        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        char[] chars = input.toCharArray();

        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                ArrayList<Integer> group = new ArrayList<>();
                group.add(count);
                group.add(chars[i - 1] - '0'); // Convert char to integer
                arrayLists.add(group);
                count = 1;
            }
        }

        // Add the last group
        ArrayList<Integer> lastGroup = new ArrayList<>();
        lastGroup.add(count);
        lastGroup.add(chars[chars.length - 1] - '0'); // Convert char to integer
        arrayLists.add(lastGroup);

        // Build the encoded string
        StringBuilder result = new StringBuilder();
        for (ArrayList<Integer> group : arrayLists) {
            result.append(group.get(0)); // Append count
            result.append(group.get(1)); // Append digit
        }

        System.out.println(result.toString());

    }




}