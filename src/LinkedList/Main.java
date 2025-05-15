package LinkedList;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Student implements Comparable<Student>{
    Integer id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  /*  @Override
    private int compareTo(Student otherStudent){
        return this.id.compareTo(otherStudent.id);
    }*/
/*
    @Override
    public int compareTo(Student that) {
        return this.id.compareTo(that.id);
    }*/


    @Override
    public int compareTo(Student o) {
        return this.id.compareTo(o.id);
    }
}
public class Main  {

    public static void main(String[] args) {
        LinkedListAPI linkedListAPI = new LinkedListImplementation();
        linkedListAPI.addLSinglyLinkedList(1);
        linkedListAPI.addLSinglyLinkedList(3);
        linkedListAPI.addLSinglyLinkedList(2);

        LinkedListAPI linkedListAPI1 = new LinkedListImplementation();
        linkedListAPI1.addLSinglyLinkedList(1);
        linkedListAPI1.addLSinglyLinkedList(3);
        linkedListAPI1.addLSinglyLinkedList(2);

        SinglyNode singlyNode = linkedListAPI.addAndSortTwoSinglyLinkedList(linkedListAPI.getNode(), linkedListAPI1.getNode());
        System.out.println("combined singlky node   = " + singlyNode);



        List<Student> strings = new LinkedList<>();


//        linkedListAPI.addLSinglyLinkedList(4);
//        linkedListAPI.addLSinglyLinkedList(5);
//        linkedListAPI.addLSinglyLinkedList(55);
//        linkedListAPI.addLSinglyLinkedList(72);

//      linkedListAPI.removeSinglyLinkedListElement(55);
//      linkedListAPI.displaySinglyLinkedList();

//      SinglyNode singlyNode = linkedListAPI.reverseSinglyLinkedList();
//        System.out.println("singlyNode = " + singlyNode);
//      linkedListAPI.displaySinglyLinkedList();
//        int i = linkedListAPI.sizeOfLinkedList();

//        System.out.println("middle = " + linkedListAPI.getMiddleOfSinglyLinkedList());
        System.out.println("rotated = " + linkedListAPI.rotateSinglyLinkedList(1));
        linkedListAPI.displaySinglyLinkedList();
        System.out.println("linkedListAPI = " + linkedListAPI.detectTheCycleOrLoopIsPresentInSinglyLinkedList());

/*
        String pwd = "101011" ;//"100110";
        int zerosFlips = 0;
        int onesFlips = 1;
        for(char character : pwd.toCharArray()){
            if (character == '0'){
                zerosFlips ++;
            }else {
                onesFlips++;
            }
        }
        System.out.println("Math.min(zerosFlips , onesFlips) = " + Math.min(zerosFlips, onesFlips));*/


        int rob = rob(new int[]{1, 2, 3, 1});

        System.out.println("rob = " + rob);
    }
    public static int rob(int[] nums) {
        int evenCounter = 0;

        for (int i = 0 ; i  < nums.length ; i++){
            System.out.println("i = " + i);
            evenCounter = nums[2 * i + 2];
        }

        return evenCounter;
    }






// Map<Person,Amount>  perstonToAmountMap = new LinkedHashMap<>();
// sarah --> 400      --> 100  --> 100  -->  400
//  Alice  --> 0    --> 100  --> 150 -->  0
//  Bob --> 0        --> 100  --> 150  --> 0
//  John   --> 0        --> 100   --> 0 --> 0



// reduce money from john by spending (100)
    // 100/2 --> 50
    // Alice , Bob have to add divident value (50)
    // traverse Map without sarah --> get the money from others and add up to sarah





//    Sarah --> 100 +300 =400
//    Alice --> 100 + 50
//    Bob -->   100 + 50
//    John  --> 0

    ///

    /*
    *
    * Sarah rents a car for the trip - she pays $400 for the car, which is used by Alice, John, Bob and herself.
Later in the trip, John went out and bought groceries for $100, which was used only by Alice and Bob.

Now, the trip is over and everyone wants to get paid back what they are owed - print out the list
of transactions that would settle everyone's debts.
    *
    * */
}
