package LinkedList;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class CustomDoublyLinkedList {

    Node head ,tail = null;

    @Override
    public String toString() {
        return "DoublyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }


    class Node{
        private  Integer data;
        private  Node previous;
        private  Node next;

        Node(int data){
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node { previous = "+ ( previous  == null  ?  null  : previous.data ) +" , data = "+data+" , next = " + ( next == null  ?  null  : next.data) + " } ";
        }
    }

    public void addNode(int data) {
        //Create a new node
        Node newNode = new Node(data);

        //If list is empty
        if(head == null) {
            //Both head and tail will point to newNode
            head = tail = newNode;
            //head's previous will point to null
            head.previous = null;
            //tail's next will point to null, as it is the last node of the list
            tail.next = null;
        }
        else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            tail.next = null;
        }
    }
    public void display() {
        //Node current will point to head
        Node current = head;
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while(current != null) {
            //Prints each node by incrementing the pointer.

            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {

        CustomDoublyLinkedList doublyLinkedList  = new CustomDoublyLinkedList();

        doublyLinkedList.addNode(1);
        doublyLinkedList.addNode(2);
        doublyLinkedList.addNode(3);
        doublyLinkedList.addNode(4);
        doublyLinkedList.addNode(5);
        doublyLinkedList.addNode(6);

        LinkedList<String> strings = new LinkedList<>();
        strings.offer("aa");
        strings.offer("1");
        strings.removeLast();
        System.out.println("strings = " + strings);


        Pattern pattern =  Pattern.compile("]");

        doublyLinkedList.display();

    }

}
