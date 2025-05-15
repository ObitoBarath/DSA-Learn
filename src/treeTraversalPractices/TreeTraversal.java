package treeTraversalPractices;


import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class TreeTraversal {


    class Student{
        String name;
        Student(String name ) throws Exception{
            this.name = name;
        }

        @Override
        public String toString(){
            return "Name = "+this.name;
        }
    }




    public void main(String[] args) throws Exception {
        TreeNode<String> treeNode = new TreeNode<>("100");

        treeNode.left = new TreeNode<>("20");
        treeNode.left.left = new TreeNode<>("10");
        treeNode.left.right = new TreeNode<>("30");


        treeNode.right = new TreeNode<>("200");
        treeNode.right.left = new TreeNode<>("150");
        treeNode.right.right= new TreeNode<>("300");


        TreeAPIHolder.getTreeTraversalAPI().preOrderTraversal(treeNode);
        TreeNode<String> stringTreeNode = TreeAPIHolder.getTreeTraversalAPI().inOrderTraversal(treeNode);
        while (stringTreeNode.right != null){
            System.out.print( stringTreeNode.data + " ");
            stringTreeNode = stringTreeNode.right;
        }



        Student[]  students = new Student[3];
        students[1] = new Student("a");
        students[2] = new Student("b");

        for (Student student : students) {
            System.out.println("student = " + student);
        }


        Queue<String> priorityQueue = new ArrayBlockingQueue<>(5);
        
        priorityQueue.add("e");
        priorityQueue.add("a");
        priorityQueue.add("b");
        priorityQueue.add("c");
        priorityQueue.add("d");
        priorityQueue.offer("d");



        System.out.println("priorityQueue = " + priorityQueue);




        int[] arr = new int [3];

        arr[1] = 1;
        arr[2] = 2;

        for (int i : arr) {
            System.out.println("i = " + i);
        }



//        StringBuffer a = new StringBuffer("abc");
//        String b = new String("abc");
//        String c = a;



//        System.out.println();
//        System.out.println(a.equals(b)); // true   // false
//        System.out.println(b==c); // true  // false
//        System.out.println(a==c); // true  // true

        int[] nums1 = {4, 5, 5, 2, 4};
        System.out.println("min steps " + minSteps(nums1));

    }

    private static int minSteps(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int res = 0;
        Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b)-> b.getKey() - a.getKey());

        maxHeap.addAll(map.entrySet());
        System.out.println("maxHeap = " + maxHeap);
        while(maxHeap.size() > 1) {
            Map.Entry<Integer, Integer> entry1 = maxHeap.poll();
            Map.Entry<Integer, Integer> entry2 = maxHeap.poll();
            res += entry1.getValue();
            entry2.setValue(entry2.getValue() + entry1.getValue());
            maxHeap.offer(entry2);
//            maxHeap.add()
        }
        return res;
    }

}
