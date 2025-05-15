package Queues;

import java.util.*;

public class CircularQueue {

    int[] array;
    int front, rear, size, capacity;

    public CircularQueue(int capacity) {
        this.array = new int[capacity] ;
        this.front = -1;
        this.rear = -1;
        this.capacity = capacity;
        this.size = 0;
    }

    public void enQueue(int data) {
        if (size == capacity) {
            System.out.println("Queue is full");
            return;
        }

        if (size == 0) {
            front = 0;
        }
        rear = (rear + 1) % capacity;

        array[rear] = data;
        size++;
    }

    public int deQueue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int data = array[front];
        front = (front+1) % capacity;
        System.out.println("front  = " + front);
        System.out.println("data = " + data);
        size --;

        if (size == 0){
            rear = front = -1;
        }

        return  data;
    }


    public static void main(String[] args) {



    }


}
