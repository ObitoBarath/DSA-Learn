package againDataStructure.LinkedList;

class Node<T> {
    T data;
    Node<T> next;


    public Node() {
        this.data = null;
        this.next = null;
    }

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

}

public class LinkedList<T> {

    Node<T> root;

    private boolean isEmpty() {
        return root == null;
    }

    public boolean add(T data) {

        if (isEmpty()) {
            root = new Node<>(data);
            return true;
        }

        Node<T> tempNode = root;

        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }

        tempNode.next = new Node<>(data);

        return true;
    }

    public boolean remove(T data) {

        if (isEmpty()) {
            return false;
        }

        Node<T> tempNode = root;

        while (tempNode.next != null && tempNode.next.data != data) {
            tempNode = tempNode.next;
        }
        if (tempNode.next == null) {
            System.out.println("No Items found");
            return false;
        }
        tempNode.next = tempNode.next.next;
        return true;
    }

    public boolean addFirst(T data) {
        Node<T> newNode = new Node<>(data);

        newNode.next = root;
        root = newNode;

        return true;
    }

    private Node<T> getMiddle(Node<T> head) {
        if (head == null || head.next == null) return head;

        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;

        Node middle = getMiddle(head);
        Node nextToMiddle = middle.next;
        middle.next = null; // Split the list into two halves

        Node left = mergeSort(head);
        Node right = mergeSort(nextToMiddle);

        return merge(left, right);
    }

    public void sort(){
        mergeSort(root);
    }

    private Node merge(Node<Integer> left, Node<Integer> right) {
        if (left == null) return right;
        if (right == null) return left;

        Node result;
        if (left.data <= right.data) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }
}
