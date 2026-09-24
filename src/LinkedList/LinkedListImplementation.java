package LinkedList;

import java.util.ArrayList;
import java.util.Collections;

public class LinkedListImplementation implements LinkedListAPI {
    public SinglyNode head;

    @Override
    public SinglyNode addAndSortTwoSinglyLinkedList(SinglyNode node1, SinglyNode node2) {
        ArrayList<Integer> integers =  new ArrayList<>();

        while (node1 != null){
            integers.add(node1.data);
            node1 = node1.next;
        }

        while (node2 != null){
            integers.add(node2.data);
            node2 = node2.next;
        }
        Collections.sort(integers);
        Collections.reverse(integers);
        System.out.println("integers = " + integers);


        SinglyNode dummy = new SinglyNode(-1);
        SinglyNode curr = dummy;

        for (int i = 0; i < integers.size(); i++) {
            curr.next = new SinglyNode(integers.get(i));
            curr = curr.next;
            System.out.println("curr = " + curr);
            System.out.println("dummy = " + dummy);
        }



        return dummy.next;


    }

    @Override
    public SinglyNode getNode() {
        return head;
    }

    public void addLSinglyLinkedList(int data) {
        SinglyNode newNode = new SinglyNode(data);
        if (head == null) {
            head = newNode;
        }else {
            SinglyNode tempNode = head;

            while (tempNode.next != null){
                tempNode = tempNode.next;
            }

            tempNode.next = newNode;
        }
    }


    abstract class Account {
        private Long accountNo;
        private String Name;

        public Long getAccountNo() {
            return accountNo;
        }

        public void setAccountNo(Long accountNo) {
            this.accountNo = accountNo;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }
        abstract void calculateBalance();
    }

    class SavingAccount extends Account{

        @Override
        public void calculateBalance(){
            Long accountNo = super.getAccountNo();

        }

        public void calculateBalance(int date){

        }


    }

    public void displaySinglyLinkedList(){

        if (head == null){
            System.out.println("List is empty ");
            return;
        }

        SinglyNode temp = head;
        System.out.print("[ ");
        while (temp != null){
//            System.out.print(STR."\{temp.data}");
            temp = temp.next;
            System.out.print(",");
        }
        System.out.print(" ] " );

    }

    public void removeSinglyLinkedListElement(int data){

        if (head == null){
            System.out.println(" List is empty ");
            return;
        }

        SinglyNode temp = head;

        while (temp.next != null && temp.next.data != data){
            temp = temp.next;
        }

        if (temp.next == null){
            System.out.println(" No Data found ");
            return;
        }

        temp.next = temp.next.next;

    }

    public SinglyNode reverseSinglyLinkedList(){
        SinglyNode prev = null, current = head , next ;


        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public int sizeOfLinkedList(){
        SinglyNode temp = head;
        int count = 0;
        while (temp != null){
            temp = temp.next;

            count ++;
        }
        return count;

    }
    public int getMiddleOfSinglyLinkedList(){

        // slow and fast pointer algorithm , tortoise or horse algorithm or two pointer algorithm;

        SinglyNode slow = head;
        SinglyNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        return slow.data;

        /*SinglyNode temp = head;
        int sizeOfLinkedList = this.sizeOfLinkedList() / 2 ;
        int counter = 0;
        while (counter < sizeOfLinkedList-1 && temp != null){
            temp = temp.next;
            counter++;
        }

        return temp.data;*/
    }
    public SinglyNode rotateSinglyLinkedList(int k){

        System.out.println("head = " + head);
        // Rotate the list by k nodes
        for (int i = 0; i < k; ++i) {
            SinglyNode curr = head;
            while (curr.next != null)
                curr = curr.next;

            System.out.println("curr.next = " + curr);
            curr.next = head;
//            System.out.println("curr.next2 = " + curr.next);

            curr = curr.next;
//            System.out.println("curr.next = " + curr);
//            System.out.println("curr = " + curr);
            head = head.next;
//            System.out.println("head = " + head);
            curr.next = null;
            System.out.println("cur= " + curr);
        }
        return head;

    }


    public boolean detectTheCycleOrLoopIsPresentInSinglyLinkedList(){

        head.next.next = head;

        
        SinglyNode slow = head, fast = head;

        // Move slow and fast 1 and 2 steps
        // ahead respectively.
        slow = slow.next;
        fast = fast.next.next;

        // Search for loop using slow and fast pointers
        while (fast != null && fast.next != null) {
            if (slow == fast)
                return true;

            slow = slow.next;
            fast = fast.next.next;
        }




        return  false;
    }




}
