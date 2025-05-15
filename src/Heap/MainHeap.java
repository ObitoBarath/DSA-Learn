package Heap;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MaxHeap {
    int[] heap;
    int capacity;
    int size;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[this.capacity];
    }


    public int parent(int index) {
        int i = (index - 1) / 2;
        System.out.println("parent= " + i + " of index = " + index);
        return i;
    }

    public int leftChild(int index) {
        return 2 * index + 1;
    }

    public int rightChild(int index) {
        return 2 * index + 2;
    }

    public void heapify(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;

    }

    public void heapifyUp(int index) {
        System.out.println("index = " + index);

        while ( index > 0 && heap[ parent(index) ] > heap[index]) {
            heapify(parent(index), index);
            index = parent(index);
        }
    }

    public void insert(int data) {
        if (size == capacity) {
            throw new IllegalStateException("Heap is full da ");
        }
        System.out.println("data = " + data);
        System.out.println("size = " + size);
        heap[size] = data;
        size++;
        System.out.println("Incremented size = " + size);
        heapifyUp(size - 1);


        printHeap();
    }

    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
    }

    public int getMax() {
        if (size == 0)
            throw new IllegalStateException(" Heap is empty da ");

        return heap[0];
    }

    public void heapifyDown(int index) {

        int largest = index;
        int left = leftChild(index);
        int right = rightChild(index);


        if (left < size && heap[left] < heap[largest]) {
            largest = left;
        }

        if (right < size && heap[right] < heap[largest]) {
            largest = right;
        }

        if (largest != index) {
            heapify(index, largest);
            heapifyDown(largest);
        }


    }


    public int extractMax() {
        int max = heap[0];

        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }


}


public class MainHeap {

    final static  int[] array = {8, 5, 4, 2, 1, 5};
    private static void maxHeapSort() {


        try (ExecutorService executorService = Executors.newFixedThreadPool(5)) {

            for (int  j = 0 ; j  < 10 ; j ++){
                executorService.execute(() -> {


                    int n = array.length;

                    for (int i = n / 2 - 1; i >= 0; i--) {
                        customHeapify(array, n, i);
                    }


                    for (int i = n - 1; i >= 0; i--) {
                        int temp = array[0];
                        array[0] = array[i];
                        array[i] = temp;
                        customHeapify(array, n, i);

                    }
                    System.out.println("n = " + Arrays.toString(array) + "  --> thread name "+Thread.currentThread().getName());
                });
            }

            executorService.shutdownNow();
        } catch (Exception e) {
            System.out.println("e = " + e);

        };


    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(5);

        maxHeapSort();
      /*  maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(30);
        maxHeap.insert(40);
        maxHeap.insert(5);



        int max = maxHeap.getMax();

        System.out.println("max = " + max);

        int i = maxHeap.extractMax();
        System.out.println("i = " + i);

        maxHeap.printHeap();

        *//*int age = -1;

        // Using assert to validate a condition
        assert age >= 0 : "Age cannot be negative!";

        System.out.println("Age is valid: " + age);*//*


//        PriorityQueue<Task> tasks  = new PriorityQueue<>();
        PriorityBlockingQueue<Task> tasks = new PriorityBlockingQueue<>();


        tasks.add(new Task(1, "1"));
        tasks.add(new Task(3, "3"));
        tasks.add(new Task(4, "4"));
        tasks.add(new Task(2, "2"));

        while (!tasks.isEmpty()) {
            Task poll = tasks.poll();
            System.out.println("current task = " + poll);
        }


        relativeRanks();*/
    }


    static class Task implements Comparable<Task> {
        int priority;
        String name;

        public Task(int priority, String name) {
            this.priority = priority;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "priority=" + priority +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Task otherTask) {
            return this.priority - otherTask.priority;
        }
    }

    public static void relativeRanks() { // leetcode 506

        int[] ranksArray = {5, 4, 3, 2, 10};
        convertedArrayToMaxHeap(ranksArray);
        System.out.println("array = " + Arrays.toString(ranksArray));
        int i = ranksArray[0];
        System.out.println("i = " + i);
        int i1 = ranksArray[1];

        System.out.println("i1 = " + i1);

        /*String weather = "winter";
        String ranks = switch (weather){
          case "sunny" -> {
              yield "sunny";
          }
          case "winter" -> "windter";
            default -> "Happy Code";
        };
        System.out.println("ranks = " + ranks);
*/


    }

    public static void convertedArrayToMaxHeap(int[] array) {
        int size = array.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(array, size, i);
        }

    }

    private static void heapify(int[] array, int size, int i) {

        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < size && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        if (rightChild < size && array[rightChild] > array[largest]) {
            largest = rightChild;
        }
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, size, i);
        }

    }


    private static void customHeapify(int[] array, int size, int index) {


        int largest = index;

        int leftTree = 2 * index + 1;
        int rightTree = 2 * index + 2;


        if (leftTree < size && array[leftTree] > array[largest]) {
            largest = leftTree;
        }
        if (rightTree < size && array[rightTree] > array[largest]) {
            largest = rightTree;
        }

        if (largest != index) {
            int temp = array[index];
            array[index] = array[largest];
            array[largest] = temp;

            customHeapify(array, size, largest);
        }


    }


}
