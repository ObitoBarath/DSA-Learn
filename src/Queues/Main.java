package Queues;

import java.util.*;

class LinkedListStack<T>{
    LinkedList<T> stack;

    public LinkedListStack(){
        this.stack = new LinkedList<>();
    }


    public void add(T value){
        stack.add(value);
    }
    public T peek(){
        return stack.getLast();
    }
    public T pop(){
        return  stack.removeLast();
    }
    public void display(){
        stack.forEach(System.out::print);
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> integerLinkedListStack = new LinkedListStack<>();

        integerLinkedListStack.add(1);
        integerLinkedListStack.add(2);
        integerLinkedListStack.add(3);
        integerLinkedListStack.add(4);
        integerLinkedListStack.add(5);
        integerLinkedListStack.add(6);
//        System.out.println("peek " + integerLinkedListStack.peek());
//        System.out.println("pop " + integerLinkedListStack.pop());
//        integerLinkedListStack.display();

//        Student obj1  = new Object();
//        Object obj2  = new Object();
//        System.out.println(obj1.equals(obj2));
        Employee  employee = new Employee(1,"s");


        Employee  employee1 = new Employee(2,"S");



        System.out.println("employee equals  = " + employee.equals(employee1));

    }


}


 class LinkedListQueue<T>{

        LinkedList<T> queue;

        public LinkedListQueue(){
            this.queue = new LinkedList<>();

        }


        public void add(T value){
            queue.add(value);
        }

        public T pop(){
            return queue.removeFirst();
        }

        public T peek(){
              return queue.getFirst();
        }
        public int size(){
            return queue.size();
        }

        public void display(){
                queue.forEach(System.out::print);
        }

     public static void main(String[] args) {
         LinkedListQueue<String> linkedListQueue = new LinkedListQueue<>();
         linkedListQueue.add("1");
         linkedListQueue.add("2");
         linkedListQueue.add("3");
         linkedListQueue.add("4");
         linkedListQueue.add("5");
         System.out.println("peek " + linkedListQueue.peek());
         System.out.println("pop " + linkedListQueue.pop());
         linkedListQueue.display();


     }

}



public class Main {


    public static void main(String[] args) {
    /*    CustomQueue customQueue = new CustomQueue(10);
        customQueue.add(1);
        customQueue.add(2);
        customQueue.add(3);
        customQueue.add(4);
        customQueue.add(5);
        customQueue.add(6);
        customQueue.add(7);
        System.out.println("Arrays.toString(customQueue.queue) = " + Arrays.toString(customQueue.queue));
        System.out.println("front = " + customQueue.front);
        System.out.println("rear = " + customQueue.rear);

        for(int i =0 ; i < 4 ; i++){
            int pop = customQueue.pop();
            System.out.println("pop = " + pop);
            System.out.println("popping front = " + customQueue.front);
        }
        customQueue.add(8);
        customQueue.add(9);
        customQueue.add(10);
//        customQueue.add(11);
        System.out.println("peek = " + customQueue.peek());
        System.out.println("Arrays.toString(customQueue.queue) = " + Arrays.toString(customQueue.queue));
        System.out.println("front = " + customQueue.front);
        System.out.println("rear = " + customQueue.rear);
        System.out.println("size = " + customQueue.size);*/



        /*CustomLinkedListQueue customLinkedListQueue = new CustomLinkedListQueue();
        customLinkedListQueue.enQueue(2);
        customLinkedListQueue.enQueue(3);
        customLinkedListQueue.enQueue(4);
        customLinkedListQueue.enQueue(5);
        customLinkedListQueue.enQueue(6);

        System.out.println("customLinkedListQueue = " + customLinkedListQueue.deQueue());
        System.out.println("customLinkedListQueue = " + customLinkedListQueue.deQueue());
        System.out.println("customLinkedListQueue = " + customLinkedListQueue.deQueue());
        System.out.println("customLinkedListQueue = " + customLinkedListQueue.deQueue());
//        System.out.println("customLinkedListQueue = " + customLinkedListQueue.deQueue());
        System.out.println("peek  = " + customLinkedListQueue.peek());

        */


        /*CircularQueue circularQueue = new CircularQueue(10);
        circularQueue.enQueue(1);
        System.out.println("circularQueue = " + Arrays.toString(circularQueue.array));
        int i = circularQueue.deQueue();
        circularQueue.enQueue(2);

        System.out.println("i = " + i);
        System.out.println("circularQueue = " + Arrays.toString(circularQueue.array));*/


        /*PriorityQueue<Integer> integers = new PriorityQueue<>(Comparator.reverseOrder());
        integers.add(5);
        integers.add(4);
        integers.add(3);
        integers.add(2);
        integers.add(1);
        System.out.println("integers = " + integers);
        System.out.println("peek = " + integers.peek());
        System.out.println("poll = " + integers.poll());*/

        CustomPriorityQueue customPriorityQueue = new CustomPriorityQueue();
        customPriorityQueue.enQueue(10 , 3);
        customPriorityQueue.enQueue(50 , 1);
        customPriorityQueue.enQueue(20 , 2);


        System.out.println("customPriorityQueue = " + customPriorityQueue.priorityQueueNodes);


        PriorityQueue<String> strings = new PriorityQueue<>(Comparator.reverseOrder());


        strings.add("1");
        strings.add("4");
        strings.add("3");
        strings.add("2");
        System.out.println("strings = " + strings);



    }
}
