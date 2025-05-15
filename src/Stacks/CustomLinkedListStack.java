package Stacks;

import java.util.EmptyStackException;

public class CustomLinkedListStack {

    public Node head;

    public CustomLinkedListStack    (){
        this.head = null;
    }


    static class Node{
        int data;
        Node next;

        public Node(){
            this.next = null;
        }
    }

    public void push(int data){

        if (head == null){
            head =new Node();
            head.data = data;
            head.next = null;

        }else {
            Node tempNode = new Node();
            tempNode.data = data;
            tempNode.next = head;
            head= tempNode;
        }


    }

    public int peek(){
        if (head ==null){
            throw  new EmptyStackException();
        }
        return head.data;
    }

    public int pop(){
        if (head == null){
            throw new EmptyStackException();
        }
        int temp = head.data;
        head = head.next;
        return temp;
    }

    public boolean isEmpty(){
        return head == null;
    }





}
