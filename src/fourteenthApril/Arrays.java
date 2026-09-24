package fourteenthApril;

public class Arrays {


    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;


        int possibleIndex = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int value  = nums[i];



            if (value == target)
            {
                System.out.println("target present in index :: " + i);
                return;
            }else {
                if (target > value){
                    possibleIndex = i-1;
                    return;
                }

            }

        }

        System.out.println("possibleIndex = " + possibleIndex);

    }

}
