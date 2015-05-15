package com.varun.linkedlist;

/**
 * Created by Varun on 5/14/2015.
 * LL1 ==>  1->2->4
 * LL2 ==>  5->6->7
 * Sum ==>  6->8->1->1
 */
public class AddTwoNumShownAsLL {
    public static void main(String[] args) {
        //considering that values at nodes are 1 digit only.
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        Node LL1 = new Node(null);
        LL1.next=n1;
        n1.next=n2;
        //n2.next=n4;

        Node LL2 = new Node(null);
        LL2.next = n5;
        n5.next=n6;
        n6.next=n7;
        printNode(LL1);
        printNode(LL2);
        Node sum = sumNodes(LL1, LL2);
        printNode(sum);

    }

    private static void printNode(Node sum) {
        System.out.println("\n");
        while(sum!=null){
            System.out.print(sum.data +"-->");
            sum = sum.next;
        }
    }

    private static Node sumNodes(Node ll1, Node ll2) {

        if(ll1 == null && ll2 == null){
            return null;
        }

        if(ll1 == null ){
            return ll2;
        }
        if(ll2 == null ){
            return ll1;
        }
        Node list1 = ll1.next;
        Node list2 = ll2.next;
        int carry =0;
        int sum = 0;
        Node result = new Node(null);
        Node temp = result;
        while(list1!=null && list2!=null) {
            sum = (carry + (Integer) list1.data + (Integer) list2.data) % 10;
            carry = (carry + (Integer) list1.data + (Integer) list2.data) / 10;
            result.next = new Node(sum);
            list1=list1.next;
            list2=list2.next;
            result = result.next;
        }
        while(list1!=null){
            sum = (carry + (Integer) list1.data) % 10;
            carry = (carry + (Integer) list1.data) / 10;
            result.next = new Node(sum);
            list1=list1.next;
            result = result.next;
        }
        while(list2!=null){
            sum = (carry + (Integer) list2.data) % 10;
            carry = (carry + (Integer) list2.data) / 10;
            result.next = new Node(sum);
            list2=list2.next;
            result = result.next;
        }
        if(carry!=0){
            result.next = new Node(carry);
        }

        return temp;

    }

}
