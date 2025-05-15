package Trees;



import java.nio.file.attribute.AttributeView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

@FunctionalInterface
interface hey {
    void sayHi();
}

abstract class  AbstractClass{

    public AbstractClass(){

    }
}


strictfp class  BinarySearchTree {

//    AbstractClass abstractClass = new AbstractClass();
    Node root;


     public strictfp void insert(Node node) {
        root = insertHelper(root, node);
    }

    private Node insertHelperCustom(Node root  , Node curr){
        int data = curr.data;

        if (root == null){
            root = curr;
            return root;
        }else if (root.data > data){
            root.left = insertHelperCustom(root.left , curr);
        }else {
            root.right = insertHelperCustom(root.right , curr);
        }
        return root;
    }

    public ArrayList<ArrayList<Integer>> levelOrderTraversal(Node root){
        ArrayList<ArrayList<Integer>> objects = new ArrayList<>();
        levelOrderTraversalRecursion(root , 0 ,objects);
        return objects;
    }

    private void levelOrderTraversalRecursion(Node root , int level , ArrayList<ArrayList<Integer>>  arrayLists){
        if (root == null){
            return ;
        }

        if (arrayLists.size() <= level){
            arrayLists.add(new ArrayList<>());
        }

        arrayLists.get(level).add(root.data);
        levelOrderTraversalRecursion(root.left ,level + 1 , arrayLists);
        levelOrderTraversalRecursion(root.right,level + 1 , arrayLists);
    }

    private Node insertHelper(Node root, Node node) {
        int data = node.data;
        if (root == null) {
            root = node;
            return root;
        } else if (root.data > data) {
            root.left = insertHelper(root.left, node);
        } else {
            root.right = insertHelper(root.right, node);
        }
        return root;

    }


    public void display() {
        displayHelper(root);
    }

    private void displayHelper(Node root) {
        if (root != null) {
            displayHelper(root.left);
            System.out.println("root = " + root.data);
            displayHelper(root.right);
        }

    }

    public boolean search(int data) {
        return searchHelper(root, data);
    }


    private boolean searchHelperCustom(Node root , int data){
        if (root == null){
            return false;
        }else if (root.data == data){
            return  true;
        }else if (root.data > data){
            return searchHelperCustom(root.left , data);
        }else {
            return  searchHelperCustom(root.right , data);
        }
    }
    private boolean searchHelper(Node root, int data) {
        if (root == null) {
            return false;
        } else if (root.data == data) {
            return true;
        } else if (data > root.data) {
            return searchHelper(root.right, data);
        } else {
            return searchHelper(root.left, data);
        }
    }

    public void remove(int data) {
        root = removeHelper(root, data);
    }

    private Node removeHelper(Node root, int data) {
        if (root == null) {
            return null;
        } else if (data < root.data) {

            root.left = removeHelper(root.left, data);

        } else if (data > root.data) {

            root.right = removeHelper(root.right, data);

        } else {

            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            } else {
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }
        }
        return root;
    }

    private int successor(Node root) {
        root = root.right;

        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    private int predecessor(Node root) {
        root = root.left;

        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    //preorder ->visit root node ---> traverse the left  --> traverse the right
    // inorder --> traverse the left substree < -- > visit root node < -- > traverse the right
    //post order--> traverse the left --> traverse the right --> visit the root


    void preOrderTraversal(Node node) {
        if (node == null)
            return;

        System.out.println("node = " + node.data);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    void postOrderTraversal(Node node) {
        if (node == null)
            return;

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println("node = " + node.data);

    }

    void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left); // Traverse left
        System.out.print(node.data + " "); // Visit root
        inOrderTraversal(node.right); // Traverse right
    }
}


public class MainTree {


    public void main(String[] args) {


        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(new Node(1));
        binarySearchTree.insert(new Node(2));
        binarySearchTree.insert(new Node(3));
        binarySearchTree.insert(new Node(4));
        binarySearchTree.insert(new Node(5));
        binarySearchTree.insert(new Node(6));
        binarySearchTree.insert(new Node(7));
        binarySearchTree.insert(new Node(8));
        binarySearchTree.insert(new Node(9));


        binarySearchTree.remove(32);

        binarySearchTree.display();
        System.out.println(binarySearchTree.search(0));
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.right.right = new Node(4);
        root.right.right.left = new Node(6);
        root.right.right.right = new Node(5);
        binarySearchTree.inOrderTraversal(binarySearchTree.root);
        ArrayList<ArrayList<Integer>> arrayLists = binarySearchTree.levelOrderTraversal(root);
        System.out.println("arrayLists = " + arrayLists);
    }
}
