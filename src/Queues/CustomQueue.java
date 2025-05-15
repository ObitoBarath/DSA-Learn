package Queues;



public class CustomQueue {


    int[] queue;
    int rear , front , capacity , size;
    public CustomQueue(int capacity){
        this.queue  = new int[capacity];
        this.capacity  = capacity;
        this.rear = -1;
        this.front = 0;
        this.size = 0;
    }

    public void add(int data){
        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;



    }
    public int pop(){
        size--;
//        rear--;
        front = (front + 1) % capacity;
        return queue[front];
    }

    public int peek(){
        return queue[front];
    }

    public boolean isFull(){
        return size == capacity;
    }


}
