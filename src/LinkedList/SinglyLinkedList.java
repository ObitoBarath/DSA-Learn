package LinkedList;

import java.security.PublicKey;

public class SinglyLinkedList {


    SinglyNode head;

    public SinglyLinkedList(){
        head = null;
    }

    public int size(){
        int counter = 0;
        SinglyNode temp = head;
        while(temp != null){

            temp = temp.next;
            counter++;
        }
        return counter;
    }

    public SinglyNode reversedList(){

        SinglyNode currentNode = head , previousNode = null , nextNode;

        while (currentNode != null){

            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return  previousNode;
    }

    public SinglyNode rotateArrayInNTimes(int k){


        for (int i = 0; i < k; ++i) {
            SinglyNode curr = head;

            while (curr.next != null)
                curr = curr.next;

            // Move the first node to the last
            System.out.println("curr = " + curr);
            curr.next = head;
            System.out.println("curr = " + curr);
            curr = curr.next;
            System.out.println("curr = " + curr);
            head = head.next;
            System.out.println("curr = " + curr);
            curr.next = null;

        }
        return  head;
    }
    public int getMiddleValue(){
        int midIndex = size() / 2;
        System.out.println("midIndex = " + midIndex);

        SinglyNode temp = head;
        while (midIndex > 0){
            temp = temp.next;
            midIndex --;
        }

        System.out.println("midIndex = " + midIndex);
        System.out.println("temp = " + temp);
        return temp.data;
    }

    public void add(int data){
        SinglyNode newNode = new SinglyNode(data);
        if (head == null){
            head = newNode;
        }else{

           SinglyNode temp  = head;
           while (temp.next  != null){
               temp = temp.next;
           }

           temp.next = newNode;
        }

    }

    public void display(){
        if (head == null){
            System.out.println("Empty List");
            return;
        }


        System.out.print("{ ");
        SinglyNode temp = head;
        while (temp != null){
            System.out.print(temp.data + " , ");
            temp = temp.next;

        }
        System.out.println(" }");
    }
    public void removeByValue(int key){

        SinglyNode temp = head;
        System.out.println(" before temp = " + temp);
        while (temp.next != null && temp.next.data != key) {
            System.out.println("temp = " + temp);
            temp = temp.next; // Move to the next node
        }

        System.out.println(" after temp = " + temp);


    }

    public void delete(int key) {
        // If the list is empty
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        // If the head node contains the key, remove it
        if (head.data == key) {
            System.out.println("key = " + key);
            head = head.next; // Move the head pointer to the next node
            return;
        }

        // Traverse the list to find the node to delete
        SinglyNode temp = head;

        while (temp.next != null && temp.next.data != key) {
            System.out.println("before  temp = " + temp);
            temp = temp.next; // Move to the next node
            System.out.println("after temp = " + temp);
        }


        // If the key is not found in the list
        if (temp.next == null) {
            System.out.println("Key not found.");
            return;
        }

        // Remove the node containing the key
        System.out.println("temp = " + temp);
        temp.next = temp.next.next; // Bypass the node to be deleted
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

//        linkedList.removeByValue(2);
//        linkedList.delete(3);
//        System.out.println("linkedList = " + linkedList.size());
//        System.out.println("linkedList = " + linkedList.getMiddleValue());
        System.out.println("linkedList = " + linkedList.reversedList());
//        System.out.println("linkedList = " + linkedList.rotateArrayInNTimes(1));

//        linkedList.display();
    }



}