package com.varun.linkedlist;

/**
 * Created by Varun on 4/28/2015.
 */

public class DeleteNNodesAfterMNodes {
    //TODO Has to be completed
    public static void main(String[] args) {
        System.out.println("=====DeleteNNodesAfterMNodes====");

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
            Node remainingList = deleteNAfterM(2,1,n0.next);
            System.out.println("Data :: " + n0.data + "-->" + n1.data + "-->" + n2.data + "-->" + n3.data + "-->" + n4.data + "-->" + n5.data + "-->" + n6.data);

        }
    public static Node deleteNAfterM(int n, int m, Node head){
        if(head == null){
            return head;
        }

        for (int i = 0; i < n && head.next !=null; i++) {
            head = head.next;
        }
        Node temp = head;
        for (int j = 0; j <m && head.next !=null ; j++) {
            head =head.next;
        }
        temp.next = head;
        return temp;
    }

}

