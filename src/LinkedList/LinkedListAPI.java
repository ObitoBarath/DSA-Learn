package LinkedList;

public interface LinkedListAPI {

    SinglyNode addAndSortTwoSinglyLinkedList(SinglyNode node1 , SinglyNode node2);

    SinglyNode getNode();
    void addLSinglyLinkedList(int data);

    void displaySinglyLinkedList();

    void removeSinglyLinkedListElement(int data);
    
    SinglyNode reverseSinglyLinkedList();

    int sizeOfLinkedList();

    int getMiddleOfSinglyLinkedList();

    SinglyNode rotateSinglyLinkedList(int k);

    boolean detectTheCycleOrLoopIsPresentInSinglyLinkedList();
}
