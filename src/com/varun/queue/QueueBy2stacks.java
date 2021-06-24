package com.varun.queue;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Implement a queue using 2 stacks
 */
public class QueueBy2stacks {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}

class MyQueue{
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public MyQueue(){}

    public void enqueue(int num){s1.push(num);}

    public int dequeue(){
        if(s1.isEmpty() && s2.isEmpty()) throw new NoSuchElementException();
        if(!s1.isEmpty() && s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }


}