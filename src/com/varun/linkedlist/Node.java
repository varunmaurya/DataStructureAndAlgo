package com.varun.linkedlist;

/**
 * Created by Varun on 4/28/2015.
 */
public class Node {
    public Object data;
    public Node next;

    Node(Object data) {
        this.data = data;
        next = null;
    }
    Node(){
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}