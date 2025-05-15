package collections;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomSet<T>  extends LinkedHashSet<T>  {

    AtomicInteger atomicInteger = new AtomicInteger(0) ;

    LinkedHashMap<Integer , T> linkedHashMap = new LinkedHashMap<>();

    @Override
    public boolean add(T e){
        linkedHashMap.put(atomicInteger.addAndGet(1) , e);
        return true;
    }

    public T get(int index){
        return  linkedHashMap.get(index);
    }

    public static void main(String ...max)  throws RuntimeException {

        CustomSet<String> strings = new CustomSet<>();
        strings.add("10");
        strings.add("20");
        strings.add("30");
        strings.add("40");


        String s = strings.get(2);
        strings.add("3");

      /*  A object = new A() {

            void show() {
                System.out.println("HELLO A ");
            }
        };

        object.show();


        ArrayList<String> strings = new ArrayList<>();
        strings.add(0 , "");

        try{
            RuntimeException hello = new RuntimeException("hello");
            throw  hello;
        }catch ( NullPointerException e){
            System.out.println("Exception = {}" + e);
        }finally {
            System.out.println("Hello");
        }


        System.out.println("strings = " + strings);
*/


        LinkedList<Integer> integers = new LinkedList<>();
        System.out.println("integers = " + integers);

        Map<Object  , String >  objectStringMap  = new HashMap<>();

//        objectStringMap.


    }




}
