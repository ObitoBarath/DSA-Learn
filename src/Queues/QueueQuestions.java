package Queues;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueQuestions {

    static Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        solve(q, k);
        int s = q.size() - k;
        while( s-- > 0){
            int x = q.poll();
            q.add(x);
        }
        return q;
    }
    static void solve(Queue<Integer> q, int k){
        if(k == 0) return;
        int e = q.poll();
        solve(q, k - 1);
        q.add(e);
    }


/*
    private void solve(Queue<Integer> integers, int k) {
        if (k == 0 )return;
        Integer poll = integers.poll();
        solve(integers , k -1);
        integers.add(poll);
    }
*/


    public  void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.add(70);
        queue.add(80);
        queue.add(90);
        queue.add(100);

        int k =5;
        reverseFirstK(queue , k);
        System.out.println("queue = " + queue);
    }
}
