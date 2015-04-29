package com.varun.linkedlist;

/**
 * Created by Varun on 4/28/2015.
 */
public class SwapAlternateNode {

    public static void main(String[] args) {
        System.out.println("Varun");
        Node n0 = new Node(null);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        //creating linkedlist
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;

        System.out.println("Data :: " + n0.data + "-->" + n1.data + "-->" + n2.data + "-->" + n3.data + "-->" + n4.data + "-->" + n5.data + "-->" + n6.data);
        //passing data and not head
        swapAlternateNodesIterative(n0.next);
        System.out.println("Iterative swap :: " + n0.data + "-->" + n1.data + "-->" + n2.data + "-->" + n3.data + "-->" + n4.data + "-->" + n5.data + "-->" + n6.data);
        swapAlternateNodesRecurrsive(n0.next);
        System.out.println("Recurrsive swap :: " + n0.data + "-->" + n1.data + "-->" + n2.data + "-->" + n3.data + "-->" + n4.data + "-->" + n5.data + "-->" + n6.data);
    }

    private static void swapAlternateNodesIterative(Node head) {
        if (head == null) {
            return;
        }
        while (head.next != null)
            if (head != null && head.next != null) {
                swapNodeData(head);
                if (head.next.next != null) {
                    head = head.next.next;
                } else {
                    head = head.next;
                }

            }
    }

    private static void swapAlternateNodesRecurrsive(Node head) {
        if (head == null) {
            return;
        }

        if (head != null && head.next != null) {
            swapNodeData(head);
            swapAlternateNodesRecurrsive(head.next.next);
        }
    }

    private static void swapNodeData(Node head) {
        Object tempData = head.data;
        head.data = head.next.data;
        head.next.data = tempData;
    }
}
