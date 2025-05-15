package tries;



final class A extends B{

   final public void start(){
        System.out.println("start");
    };


}

class B  {
    public void start(){
        System.out.println("start");
    };

}

public class Palazzo  {



    //advanced --> oops , multithreading , core java  --> DSA ( Data Structures & Algorithms )

    // [1,2,3,4,5,7,8] -->


    //static , volatile ,synchronised ,transient

    //this ,new ,final , constructor , method overloading / overriding , object creation ( /// )  , access modifiers

    //set of data [ 123213213 , 123213  ,123213 ].manipulate

    /*
     * 1) OOPS
     * 2) Collections --> Map<Key ,Value> , Set<String> , List<Integer> , Queue<String>
     * 3)
     * */


    public String name; // /// value ;
    String age;
    //package-private


    //method to initialize an object (constructor)

    public Palazzo(String name) {
        this.name = name;
    }

    public Palazzo(String name , String age){
        this.name =  name;
        this.age = age;
    }


    final public void hello(String message) {
        System.out.println("message =" + message);
    }

    public void hello(String message, int value) {
        // -->method overloading
        //Wrapper class


        String a = null;

        Integer integer = 123; //integer pool

        String  name =  "Barath"; //

        float floatValue = 0.1f;

        double doubleValue = 0.55555d;

        char character = 'c';

        short shortValue = 15;

        //String constant pool (Stack)


    }


    //method overriding , overloading


    public static void main(String[] args) {


        // CLASS + OBJECT
        //primitive // non-primitve
        int i = 1;
        float a = 0.2f;


        final String string = "ABC";


        Palazzo palazzo = new Palazzo("asdasd"); //syntax to create an object


    }

    @Override
    public String toString() {
        return "Palazzo{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}