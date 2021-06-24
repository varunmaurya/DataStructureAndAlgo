package com.varun.linkedlist;

public class LinkedListIntersection {
    public static void main(String[] args) {
        LLNode head = new LLNode(1);
        head.next = new LLNode(2);
        head.next.next = new LLNode(3);
        head.next.next.next = new LLNode(4);
        head.next.next.next.next = new LLNode(5);
        LLNode commonNode = new LLNode(6);
        head.next.next.next.next.next = commonNode;
        commonNode.next = new LLNode(8);
        commonNode.next.next = new LLNode(10);

        LLNode head2 = new LLNode(10);
        head2.next = new LLNode(20);
        head2.next.next = new LLNode(30);
        head2.next.next.next = commonNode;

        findIntersection(head,head2);

    }

    /**
     * 1) find lengtth of each LL an confirm if last Node is same for both , this confirms they intersect
     * 2) move pointer for large LL, by the diff of length
     * 3) now move both the pointers together , whichever node matched is the common node
     * @param head1
     * @param head2
     */
    private static void findIntersection(LLNode head1, LLNode head2) {
        //Step1
        LengthAndLastNode l1 = getLengthAndLastNode(head1);
        LengthAndLastNode l2 = getLengthAndLastNode(head2);

        if(l1.tail!=l2.tail){ System.out.println(" No Intersection"); return;}

        int diff = Math.abs(l1.length-l2.length);

        LLNode smaller = l1.length<l2.length?head1:head2;
        LLNode larger = l1.length<l2.length?head2:head1;

        //Step2
        for (int i = 0; i < diff; i++) {
            larger=larger.next;
        }

        //Step3
        while(smaller!=larger){
            smaller=smaller.next;
            larger=larger.next;
        }

        System.out.println(larger.val);


    }

    private static LengthAndLastNode getLengthAndLastNode(LLNode node) {
        int size =0;
        LLNode tail =null;
        while(node!=null){
            tail= node;
            node=node.next;
            size++;
        }
        return new LengthAndLastNode(size,tail);

    }
}
class LengthAndLastNode{
    int length;
    LLNode tail;

    public LengthAndLastNode(int length, LLNode tail){
        this.length = length;
        this.tail = tail;
    }
}
class LLNode{
    LLNode next;
    int val;

    public LLNode(int val){
        this.val=val;
        next=null;
    }
}