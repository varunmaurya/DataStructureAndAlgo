package com.varun.linkedlist;

public class DeleteNNodesAfterMNodes {

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
            printLL(n0);
            Node remainingList = deleteNAfterM(2,1,n0);
            System.out.println("After Deleting ...."  );
            printLL(remainingList);

        }

    public static Node deleteNAfterM(int n, int m, Node head){
        if(head == null){
            return head;
        }

        for (int i = 0; i < m && head.next !=null; i++) {
            head = head.next;
        }
        Node temp = head;
        for (int j = 0; j <=n && head.next !=null ; j++) {
            head =head.next;
        }
        temp.next = head;
        return temp;
    }

    private static void printLL(Node remainingList) {
        while(remainingList!=null){
            System.out.print(remainingList.data + "-->");
            remainingList=remainingList.next;
        }
        System.out.print("null\n");
    }

}

