package com.varun.linkedlist;

public class SumLinkedList {
    public static void main(String[] args) {
        //1->2->3->4 ( 4321)
        LLNode ll1 = new LLNode(1);
        ll1.next = new LLNode(2);
        ll1.next.next = new LLNode(3);
        ll1.next.next.next = new LLNode(4);
        //9->8->7 (789)
        LLNode ll2 = new LLNode(9);
        ll2.next = new LLNode(8);
        ll2.next.next = new LLNode(7);
        //sum : 0->1->1->5  (4321+789 = 5110)
        LLNode sum = sum(ll1,ll2);

        while(sum!=null){
            System.out.print(sum.val+" -> ");
            sum=sum.next;
        }
    }

    private static LLNode sum(LLNode ll1, LLNode ll2) {
        int sum = 0;
        int carry = 0;
        LLNode addition = new LLNode(0);
        LLNode head = addition;
        while(ll1!=null && ll2!=null){
            sum = (ll1.val+ll2.val+carry)%10;
            carry=(ll1.val+ll2.val+carry)/10;
            addition.next = new LLNode(sum);
            addition=addition.next;
            ll1=ll1.next;
            ll2=ll2.next;
        }


            while(ll1!=null){
                sum = (ll1.val+carry)%10;
                carry=(ll1.val+carry)/10;
                addition.next = new LLNode(sum);
                addition=addition.next;
                ll1=ll1.next;
            }



            while(ll2!=null){
                sum = (ll2.val+carry)%10;
                carry=(ll2.val+carry)/10;
                addition.next = new LLNode(sum);
                addition=addition.next;
                ll2=ll2.next;
            }

        if(carry>0){
            addition.next = new LLNode(carry);
        }

        return head.next;

    }

}
