package LinkedList;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    Node head;

    // CREATE: Insert a node at the end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp; // Link back to the previous node
    }

    // READ: Print the list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // READ: Print the list in reverse
    public void printListReverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        // Traverse to the last node
        while (temp.next != null) {
            temp = temp.next;
        }
        // Print in reverse
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    // UPDATE: Update a node's value
    public boolean update(int oldData, int newData) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == oldData) {
                temp.data = newData;
                return true; // Update successful
            }
            temp = temp.next;
        }
        return false; // Value not found
    }

    // DELETE: Delete a node by its value
    public boolean delete(int data) {
        if (head == null) {
            return false; // List is empty
        }
        Node temp = head;

        // If the node to be deleted is the head
        if (temp.data == data) {
            head = temp.next;
            if (head != null) {
                head.prev = null; // Update head's previous pointer
            }
            return true;
        }

        // Traverse the list to find the node
        while (temp != null && temp.data != data) {
            temp = temp.next;
        }

        if (temp == null) {
            return false; // Node not found
        }

        // Update pointers to bypass the node
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
        return true;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // CREATE
        dll.insert(10);
        dll.insert(20);
        dll.insert(30);
        dll.insert(40);

        // READ
        System.out.println("List:");
        dll.printList();

        // READ in Reverse
        System.out.println("List in Reverse:");
        dll.printListReverse();

        // UPDATE
        System.out.println("Updating 20 to 25:");
        if (dll.update(20, 25)) {
            dll.printList();
        } else {
            System.out.println("Value 20 not found");
        }

        // DELETE
        System.out.println("Deleting 30:");
        if (dll.delete(30)) {
            dll.printList();
        } else {
            System.out.println("Value 30 not found");
        }

        System.out.println("Deleting head (10):");
        if (dll.delete(10)) {
            dll.printList();
        } else {
            System.out.println("Value 10 not found");
        }
    }
}
