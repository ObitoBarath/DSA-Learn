package LinkedList;

public class SinglyNode {
    Integer data;
    SinglyNode next;

    public SinglyNode(){
    }
    public SinglyNode(int data){
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + (next != null ? next : null) +
                '}';
    }
}






