package Queues;



public class CustomLinkedListQueue {
    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node front, rear;

    public CustomLinkedListQueue(){
        this.front = null;
        this.rear = null;


    }

    public void enQueue(int data){
        Node tempNode = new Node(data);
        if (rear == null){
            front = rear = tempNode;
        }

        rear.next  = tempNode;
        rear = tempNode;
    }

    public int deQueue(){
        int data = front.data;
        front = front.next;

        if (front == null){
            rear = null;
        }

        return data;
    }

    public int peek(){

        return  rear.data;
    }




}
