package thread;

import Queues.CircularQueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class SharedResource {
    synchronized void printMessage() {
        try {

            System.out.println("Waiting...");


            Queue<?> strings = new ArrayDeque<>();

            resumeThread();

            wait();
            System.out.println("Resumed...");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void resumeThread() {
        System.out.println("Notifying...");
        notify();  // ✅ notify() is also inside synchronized

    }
}

public class MultiThreading {
    public static boolean areAnagrams(String str1, String str2) {
        // Remove spaces and convert to lowercase
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        // If lengths are not equal, not an anagram
        if (str1.length() != str2.length()) {
            return false;
        }

        int xorSum = 0;

        // XOR all characters from both strings
        for (int i = 0; i < str1.length(); i++) {
            xorSum ^= str1.charAt(i);
            xorSum ^= str2.charAt(i);
        }

        // If the result is 0, they are anagrams
        return xorSum == 0;
    }
    public static void main(String[] args) {
        /*SharedResource obj = new SharedResource();

        Thread t1 = new Thread(obj::printMessage);
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            }catch (InterruptedException _) {

            }
            obj.resumeThread();
        });

        t1.start();
//        t2.start();
*/
        System.out.println(areAnagrams("listen" , "silent"));
    }
}
