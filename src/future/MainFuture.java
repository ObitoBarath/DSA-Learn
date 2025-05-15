package future;

import HashTables.HashTables;


import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class MainFuture implements Serializable , Externalizable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {





     /*   ExecutorService executor = Executors.newSingleThreadExecutor();

        // Submit a task that sleeps for a few seconds
        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(3000); // Simulate a long-running task
            return 1;
        });

        // Check the task status before it completes
        System.out.println("Task completed: " + future.isDone()); // false
        System.out.println("Task canceled: " + future.isCancelled()); // false

        // Wait for the task to complete
        Integer result = future.get();

        // Check status after completion
        System.out.println("Task completed: " + future.isDone()); // true
        System.out.println("Task canceled: " + future.isCancelled()); // false
        System.out.println("Result: " + result);

        executor.shutdown();

        executor.shutdownNow();



*/

        CompletableFuture<String> stringCompletableFuture = new CompletableFuture<>();
//        stringCompletableFuture.





//        System.out.println("s = " + s);
        Map<String , String> hashtable  = new Hashtable<>();

        hashtable.put(null , new String());

        System.out.println("hashtable = " + hashtable);

        HashMap<String , String>stringStringHashMap  = new HashMap<>();

//        Deque

        stringStringHashMap.put(null , null);

        stringStringHashMap.put(null , null);

        stringStringHashMap.put(null , null);

        System.out.println("stringStringHashMap = " + stringStringHashMap);

        String caseCheck = "1";

        String cas = switch (caseCheck){
            case "1" -> {
                    yield "sunny";
            }
            default -> "ASdasd";
        };


        System.out.println("cas = " + cas);


    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }


    static {

        List<List<Integer>> lists =  new ArrayList<>();


        List<Integer> integers = new ArrayList<>();
        integers.add(10);
        integers.add(20);
        integers.add(30);
        integers.add(40);
        lists.add(integers);
        List<Integer> integers1 = new ArrayList<>();
        integers1.add(20);
        integers1.add(30);
        integers1.add(40);
        integers1.add(50);
        lists.add(integers1);

        System.out.println("lists.get(1) = " + lists.get(1));



        System.out.println("lists = " + lists);


    }


}
