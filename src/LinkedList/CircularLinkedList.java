package LinkedList;
class BarathNode{
    int data;
    BarathNode next;

    public BarathNode(int data){
        this.data =data;
        this.next = null;
    }

}

class BarathLinkedList{
    BarathNode root;


    public void insert(int data){

        BarathNode newNode = new BarathNode(data);
        if (root == null){
            root = newNode;
        }else {
            BarathNode temp = root;

            while (temp.next != null){
                temp = temp.next;
            }

            temp.next = newNode;

        }
    }

    public  BarathNode delete (int data){
        if (root != null){
            root = root.next;
            return root;
        }
            BarathNode tempNode = root;

            while (tempNode.next != null && tempNode.next.data != data){
                tempNode = tempNode.next;
            }

            if (tempNode.next == null){
                System.out.println("key not found");
                return root;
            }
            tempNode.next = tempNode.next.next;

            return tempNode;

    }

}
class BarathDoublyNode{
    int data;
    BarathDoublyNode next;
    BarathDoublyNode prev;

    public BarathDoublyNode(int data){
        this.data = data;
        this.next = this.prev = null;
    }
}

class BarathDoublyLinkedList{

    BarathDoublyNode root;

    public  void insert(int data){
        BarathDoublyNode barathDoublyNode = new BarathDoublyNode(data);
        if (root == null)
        {
            root =barathDoublyNode;
        }

        BarathDoublyNode temp = root;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = barathDoublyNode;
        barathDoublyNode.prev = temp;


    }

    public void delete(int data){
            if (root == null){
                return;
            }
            BarathDoublyNode temp = root;

            if (temp.next != null && temp.next.data != data){
                temp  = temp.next;
            }

            if (temp.next != null){
                temp.next.prev = temp.prev;
                temp.prev.next = temp.next;
            }
    }


}





public class CircularLinkedList {
    Node head;

    // CREATE: Insert a node at the end of the circularly linked list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head; // Point to itself to form a circular structure
        } else {
            Node temp = head;
            while (temp.next != head) { // Traverse to the last node
                temp = temp.next;
            }
            temp.next = newNode; // Link the last node to the new node
            newNode.next = head; // Point the new node back to the head
        }
    }

    // READ: Print the circularly linked list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head); // Loop until we come back to the head
        System.out.println();
    }

    // UPDATE: Update a node's value
    public boolean update(int oldData, int newData) {
        if (head == null) {
            return false; // List is empty
        }
        Node temp = head;
        do {
            if (temp.data == oldData) {
                temp.data = newData;
                return true; // Update successful
            }
            temp = temp.next;
        } while (temp != head);
        return false; // Value not found
    }

    // DELETE: Delete a node by its value
    public boolean delete(int data) {
        if (head == null) {
            return false; // List is empty
        }

        Node current = head, previous = null;

        // Case 1: Deleting the only node in the list
        if (head.next == head && head.data == data) {
            head = null;
            return true;
        }

        // Case 2: Deleting the head node
        if (head.data == data) {
            // Find the last node to update its next pointer
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next; // Update last node's next pointer
            head = head.next; // Update the head
            return true;
        }

        // Case 3: Deleting a node other than the head
        do {
            previous = current;
            current = current.next;

            if (current.data == data) {
                previous.next = current.next; // Bypass the node
                return true;
            }
        } while (current != head);

        return false; // Value not found
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        // CREATE
        cll.insert(10);
        cll.insert(20);
        cll.insert(30);
        cll.insert(40);

        // READ
        System.out.println("List:");
        cll.printList();

        // UPDATE
        System.out.println("Updating 20 to 25:");
        if (cll.update(20, 25)) {
            cll.printList();
        } else {
            System.out.println("Value 20 not found");
        }

        // DELETE
        System.out.println("Deleting 30:");
        if (cll.delete(30)) {
            cll.printList();
        } else {
            System.out.println("Value 30 not found");
        }

        System.out.println("Deleting head (10):");
        if (cll.delete(10)) {
            cll.printList();
        } else {
            System.out.println("Value 10 not found");
        }

        System.out.println("Deleting 25:");
        if (cll.delete(25)) {
            cll.printList();
        } else {
            System.out.println("Value 25 not found");
        }
    }
}
