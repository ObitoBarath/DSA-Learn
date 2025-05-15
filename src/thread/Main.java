package thread;

import java.util.Scanner;

public class Main {


    public static void singleThreadExample(){

/*
        Thread thread = Thread.currentThread();

        thread.setPriority(1);
        thread.setName("interview prep");

        System.out.println("thread = " + thread);*/

//        MyThread myThread = new MyThread();
//        myThread.run();

        GFGQuestions();
    }

    public static void GFGQuestions(){
//        Scanner scanner = new Scanner(System.in);
//        String string = System.console().readLine();

//        System.out.println("string = " + string);
//        int i = scanner.nextInt();
//        System.out.println("i = " + i);


//        float a1 = 0.5f;
//        float a2 =  0.6f;
//
//         final float finalValue = a1 * a2;
//        System.out.println("finalValue = " + finalValue);


        /*for (int i  =0  ; i <= 10 ; i ++){

            if ( (i & 1) == 0){
                System.out.println("even numbers = " + i);
            }

            if ( (i ^ 1) == i+1){
                System.out.println("even numbers = " + i);
            }

            if ( (i | 1) > i){
                System.out.println("even numbers = " + i);
            }

            if (Integer.toBinaryString(i).endsWith("0")){
                System.out.println("even numbers ="+i);
            }


        }*/



           /* String s1 = new String("1");
            String s2= "1";

            System.out.println(s1.equals( s2));*/
        int lcm = LCM(9, 2);
        System.out.println("lcm = " + lcm);


    }
    static int GCD(int u, int v)
    {
        if (u == 0)
            return v;
        return GCD(v % u, u);
    }

    // LCM of two numbers
    static int LCM(int u, int v)
    {
        return (u / GCD(u, v)) * v;
    }

    public static class MyThread implements Runnable{

            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Thread running: " + i);
                    try {
                        Thread thread = Thread.currentThread();
                        thread.setName("Barath");
                        Thread.sleep(1000);
                    } catch ( Exception e) {
                        System.out.println("Thread interrupted");
                    }
                    System.out.println("Thread Stopped: " + i);
                }
            }
        }


    public static void main(String[] args) {
        singleThreadExample();
    }
}
