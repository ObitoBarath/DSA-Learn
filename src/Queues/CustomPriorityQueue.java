package Queues;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CustomPriorityQueue {


    List<PriorityQueueNode> priorityQueueNodes;

    public CustomPriorityQueue(){
        this.priorityQueueNodes = new ArrayList<>();
    }

    class PriorityQueueNode{
        int data;
        int priority;

        public PriorityQueueNode(int data , int priority){
            this.data = data;
            this.priority = priority;
        }

        @Override
        public String toString(){
            return data+"";
        }
    }

    public void enQueue(int data , int priority){

        priorityQueueNodes.add(new PriorityQueueNode(data,priority));
        priorityQueueNodes.sort((a , b) -> a.priority - b.priority);

    }



    public int deQueue(){
        if (priorityQueueNodes.isEmpty()){
            throw new NoSuchElementException() ;
        }
        return priorityQueueNodes.removeFirst().data;
    }
    public int peek(){
        return priorityQueueNodes.getFirst().data;
    }






}
