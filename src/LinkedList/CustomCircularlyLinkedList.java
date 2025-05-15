package LinkedList;



public class CustomCircularlyLinkedList {

    private static class Node{
        int data;
        Node next;
        private Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    void append(int data){
        Node newNode = new Node(data);

        if (head == null){

            head = newNode;
            tail = newNode;
            newNode.next = head;

        }else {

            tail.next  = newNode;
            tail = newNode;
            tail.next = head;
        }
    }
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head); // Stop when we loop back to the head
        System.out.println("(head)");
    }

    public static void main(String[] args) {

        CustomCircularlyLinkedList circularlyLinkedList = new CustomCircularlyLinkedList();
        circularlyLinkedList.append(1);
        circularlyLinkedList.append(2);
        circularlyLinkedList.append(3);
        circularlyLinkedList.append(4);
        circularlyLinkedList.display();
    }


}