import java.lang.reflect.Array;
import java.util.*;


interface InterfaceA {
    String name = "A Bye Bye";

    void Hello();

    default void bye() {
        System.out.println("name = " + name);
    }

}

abstract class Overloading {
    abstract void method();

    abstract void method1();

    abstract void method(int x, String... args);

    void method1(short... args) {

    }

    ;
}

class D extends Overloading {

    @Override
    void method() {
//    super.method1(1);
    }

    @Override
    void method1() {

    }

    @Override
    void method(int x, String... args) {

    }
}


interface InterfaceB extends InterfaceA {
    String name = "B Bye Bye";

    void Hello();

    default void bye() {
        System.out.println("name = " + name);
    }

}


sealed class A implements InterfaceA, InterfaceB {


    String name;

    void sayHello() {
        System.out.println("Hello");
    }

    void sayHi() {
        System.out.println("HI");
    }

    @Override
    public void Hello() {

    }

    @Override
    public void bye() {
//        InterfaceA.super.bye();
    }
}

non-sealed class C extends A {
    String name;

    public C() {
        this.name = "Hello";
        super.name = "Super Name";

    }
}

non-sealed class B extends A {

    @Override
    public void sayHello() {

    }
}

public class AthenaHealth {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }


    }


    static class StaticChecker {

        public StaticChecker(int value) {
            System.out.println("value =>" + value);

            C object = new C();

            String name = object.name;

            System.out.println("name = " + name);

            Overloading overloading = new D();

            short i = 13123;

            overloading.method1();
        }

    }

    interface Hello {
        void run();

        default void stop() {
            System.out.println("Stopped");
        }

        ;


    }

    static StaticChecker s1 = new StaticChecker(1);
    StaticChecker s2 = new StaticChecker(2);
    static StaticChecker s3 = new StaticChecker(3);

    static {
        int[] nums  = {1,2,3,4} ;int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {  // Skip the current index
                    product *= nums[j];
                }
            }
            nums[i] = product; // Store result directly in the same array
        }

        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
    }


    public static void main(String[] args) {

//        vallies();


       /* Hello hello = () -> {
            System.out.println("Running");
        };
        hello.run();
        hello.stop();


        int[] array1 = {1, 0, 3, 40};
        int[] array2 = {2, 3, 1, 4, 0};

        Arrays.sort(array1);
        Arrays.sort(array2);
        System.out.println("array1 = " + Arrays.toString(array1));
        System.out.println("array2 = " + Arrays.toString(array2));


        int n = array1.length, m = array2.length;
        int i = 0, j = 0, k = 0;

        int[] mergedArray = new int[n + m];
        while (i < n && j < m) {

            *//*if (array1[i] == 0 || array2[j] ==0){
                i++;
                j++;
                continue;
            }

*//*

//            if (array1[i] <= array2[j]){
            mergedArray[k++] = array1[i++];
//            }else {
            mergedArray[k++] = array2[j++];
//            }

        }
        while (i < n) {
            mergedArray[k++] = array1[i++];
        }
        while (j < m) {
            mergedArray[k++] = array2[j++];
        }
        System.out.println("Arrays.toString(mergedArray) = " + Arrays.toString(mergedArray));

        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);

        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);


        Node dummyNode = new Node(-1);
        Node tailNode = dummyNode;

        while (head1 != null && head2 != null) {

            if (head1.data <= head2.data) {
                tailNode.next = head1;
                head1 = head1.next;
            } else {
                tailNode.next = head2;
                head2 = head2.next;
            }
            tailNode = tailNode.next;
        }

        if (head1 != null)
            tailNode.next = head1;

        if (head2 != null)
            tailNode.next = head2;


//        System.out.println("tailNode = " + tailNode);
//        printNodes(dummyNode.next);

        findTheLengthOfLinkedList(dummyNode.next);*/


    }

    private final static void findTheLengthOfLinkedList(Node next) {

        Node slow = next;
        Node fast = next.next;

        int size = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("size of the list = {}" + size * 2);

        printNodes(slow);
    }

    public static void printNodes(Node temp) {

        while (temp != null) {
            System.out.println("temp = " + temp.data);
            temp = temp.next;
        }

    }

    /*static {
        twoSum();
        firstRepeatingCharacter();
        buyStock();
        buyAndSellStock();
        searchEngine();
        findSecondLargestWithoutSorting();
        majorityElement();
        findFirstMissingPositiveNumber();
        findLengthOfNonRepeatingCharacters();
        trappingRainWaterSystem();
        KthLargestElement();
        int[] integers = {1,2,3,4};

//        24,12,8,6

        System.out.println("integers = " + Arrays.toString(integers));
        int i = 0 , n = integers.length , multiplier;

        for ( ; i < n ;i++){

            multiplier  = integers[i+1] ; //1

            for (int j = 0 ; j < n ; j++){

                if (i == j && integers[i+1] != integers[j]){ //0 0 --> 0 1 2
                    continue;
                }

                multiplier *= j;

            }

            integers[i] = multiplier;
        }

        System.out.println("integers = " + Arrays.toString(integers));

    }
*/

    private static void vallies() {
//        String string = "DDUUDDUU";
        String string = "UDDDUDUU";

        int floor = 0;
        int vallies = 0;
        int down = 0, up = 0;


        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);

            if (down == up && floor == 0) {
                vallies += 1;
            }
            if (c == 'D') {
                floor--;
                down++;
            } else if (c == 'U') {
                floor++;
                up++;
            }
        }
        System.out.println("vallies = " + vallies);



        /*
        * Id	Emp Name	Mgr ID
            101	A	null
            102	B	null
            103	C	101
            104	D	102
            105	E	101
            106	F	101
        *
        *
        * */

//      select emp.emp_name as Employee_name , count(emp.Mgr_Id) as reporting_mgr from Employee emp where emp.mgr_id in ( select id from Employee  where Mgr_ID == NULL)  group by reporing_mgr having reporting_mgr > 2


    }

    private static void KthLargestElement() {
        int[] nums = {3, 2, 1, 5, 6, 6, 4};
        int k = 2;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int num : nums) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        Integer peek = maxHeap.peek();
        System.out.println("peek = " + peek);

    }

    private static void trappingRainWaterSystem() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }

        }

        System.out.println("water = " + water);

    }

    private static void findLengthOfNonRepeatingCharacters() {


        String s = "pwwkew";

        /*HashSet<Character> charSet = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println("maxLength = " + maxLength);*/


        HashSet<Character> charactersSet = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            while (charactersSet.contains(s.charAt(right))) {
                charactersSet.remove(s.charAt(left));
                left++;
            }
            charactersSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println("maxLength = " + maxLength);
    }

    private static void findFirstMissingPositiveNumber() {
        int[] nums = {3, 4, -1, 1};

        Arrays.sort(nums);
        System.out.println("nums = " + Arrays.toString(nums));
        int counter = 1;
        for (int num : nums) {

            if (num > 0) {
                if (counter == num)
                    counter += 1;
                else {
                    System.out.println("counter ==?" + counter);
                    return;
                }

            }


        }

    }

    private static void majorityElement() {
        int[] nums = {3, 3, 4, 2, 3, 3, 3};

        int counter = 0, candidate = 0;
        for (int num : nums) {
            if (counter == 0)
                candidate = num;

            counter += (num == candidate) ? 1 : -1;
        }
        System.out.println("counter = " + counter);
        System.out.println("candidate = " + candidate);
    }

    private static void findSecondLargestWithoutSorting() {
        int[] nums = {12, 35, 1, 10, 34, 1};

        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        System.out.println("largest = " + largest);
        System.out.println("secondLargest = " + secondLargest);


    }

    private static void searchEngine() {
        List<String> stringList = new ArrayList<>(Arrays.asList("mouse", "money", "monkey", "mango"));

        String input = "man";

        StringBuffer find = new StringBuffer();

        Map<String, List<String>> characterToWordsMap = new LinkedHashMap<>();

        for (char c : input.toCharArray()) {

            find.append(c);

            characterToWordsMap.put(find.toString(), stringList.stream().filter(item -> item.startsWith(find.toString())).toList());
        }

        for (Map.Entry<String, List<String>> entry : characterToWordsMap.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
        }
    }


    private static void buyStock() {


        int[] prices = {7, 1, 5, 3, 6, 4};

        int minPrice = Integer.MAX_VALUE, profit = 0;

        for (int price : prices) {

            if (price < minPrice)
                minPrice = price;
            else {
                profit = Math.max(profit, price - minPrice);

            }

        }
        System.out.println("profit = " + profit);


    }

    private static void buyAndSellStock() {
        int[] prices = {7, 1, 5, 3, 6, 4};


        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        System.out.println("maxProfit = " + maxProfit);
    }


    public static void firstRepeatingCharacter() {
        String input = "aaaaaa";

        boolean[] charArray = new boolean[256];
        for (char c : input.toLowerCase().toCharArray()) {

            if (charArray[c - 'a']) {
                System.out.println("c = " + c);
                return;
            }
            charArray[c - 'a'] = true;

        }

    }

    public static void twoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;


        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if (map.containsKey(compliment)) {
                int[] indexes = {map.get(compliment), i};
                System.out.println("Arrays.toString(indexes) = " + Arrays.toString(indexes));

                return;
            } else {
                map.put(nums[i], i);
            }

        }


    }


}
