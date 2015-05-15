package com.varun.tree.traversal;

import com.varun.tree.Node;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Varun on 5/9/2015.
 *
 * Tree in example ===>        10
 *                            /  \
 *                           8    17
 *                          /     / \
 *                         6     12  32
 *                        / \
 *                       2   7
 */
public class TreeTraversal {
    public static void main(String[] args) {
        {
            Node root = new Node(10);
            Node n1 = new Node(8);
            Node n2 = new Node(6);
            Node n3 = new Node(17);
            Node n4 = new Node(12);
            Node n5 = new Node(7);
            Node n6 = new Node(32);
            Node n7= new Node(2);


            root.left = n1;
            n1.left= n2;
            root.right = n3;
            n3.left=n4;
            n3.right = n6;
            n2.right=n5;
            n2.left=n7;

            System.out.println("\n************inOrderTraversal**********");
            inOrderTraversal(root);
            System.out.println("\n************preOrderTraversal**********");
            preOrderTraversal(root);
            System.out.println("\n************postOrderTraversal**********");
            postOrderTraversal(root);
            System.out.println("\n************levelOrderTraversal**********");
            levelOrderTraversal(root);
            System.out.println("\n************spiralTreeTraversal**********");
            spiralTreeTraversal(root);


        }
    }



    private static void inOrderTraversal(Node root) {
        // Inorder traversal prints values in sorted order (if tree is BST)
        // in general it prints left value, root value, right value
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + ",");
        inOrderTraversal(root.right);

    }

    private static void preOrderTraversal(Node root) {
        // preOrder traversal prints value in order as below
        // root value , left value, right value
        if(root == null){
            return;
        }
        System.out.print(root.data + ",");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }
    private static void postOrderTraversal(Node root) {
        // postOrder traversal prints value in order as below
        // left value, right value,root value
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + ",");
    }
    private static void levelOrderTraversal(Node root) {
        //Level order traversal prints the values of tree level by level from one direction
        levelOrderTraversalByStack(root);
        levelOrderTraversalByQueue(root);
    }

    private static void levelOrderTraversalByStack(Node root) {
        System.out.println("\n --- Level Order Traversal through Stack");
        if(root == null) return;
        Stack<Node> s1 = new Stack();
        Stack<Node> s2 = new Stack();
        s1.push(root);

        while (!s1.isEmpty()){
            Node top = s1.pop();
            System.out.print(top.data + ",");

            if(top.left!=null){
                s2.push(top.left);
            }
            if(top.right!=null){
                s2.push(top.right);
            }

            if(s1.isEmpty()){
                while(!s2.isEmpty()){
                    s1.push(s2.pop());
                }
            }
        }

    }

    private static void levelOrderTraversalByQueue(Node root) {
        if(root == null) return;
        System.out.println("\n --- Level Order Traversal through Queue");
        Queue<Node> q1 = new LinkedList();
        q1.add(root);
        while(!q1.isEmpty()){
            Node top = q1.poll();
            System.out.print(top.data + ",");
            if(top.left!=null){
                q1.add(top.left);
            }
            if(top.right!=null){
                q1.add(top.right);
            }
        }


    }

    private static void spiralTreeTraversal(Node root) {
        spiralTreeTraversalByStack(root);
        spiralTreeTraversalByQueue(root);
    }

    private static void spiralTreeTraversalByStack(Node root) {
        System.out.println("\n ---- spiralTreeTraversalByStack");
        if(root == null) return;
        Stack<Node> s1 = new Stack();
        Stack<Node> s2 = new Stack();
        s1.push(root);

        while(!s1.isEmpty() || !s2.isEmpty()){ // if any of the two stack have data
            // Important to notice is that while pushing data into s2 we push left first while pushing data in s1
            // we push right first, which insures the zigzag traversal.
            while(!s1.isEmpty()){
                Node top = s1.pop();
                System.out.print(top.data + ",");
                if(top.left!=null){
                    s2.push(top.left);
                }
                if(top.right!=null){
                    s2.push(top.right);
                }
            }

            while(!s2.isEmpty()){
                Node top = s2.pop();
                System.out.print(top.data + ",");
                if(top.right!=null){
                    s1.push(top.right);
                }
                if(top.left!=null){
                    s1.push(top.left);
                }

            }
        }

    }

    private static void spiralTreeTraversalByQueue(Node root) {
        // Add a null value to Deque and use that as seperater to switch when to add in start of  queue and when
        // to add at end of queue
        System.out.println("\n -- spiralTreeTraversalByQueue");
        Deque<Node> dq1 = new LinkedList();
        dq1.offer(null);
        dq1.offerFirst(root);

        while(dq1.size()>1){ // only null is present
            root = dq1.peekFirst();
            while(root!= null){ // checking if we traversed the queue from up and reached till null
                root = dq1.pollFirst();
                System.out.print(root.data + ",");
                if(root.left!=null){
                    dq1.offerLast(root.left);
                }
                if(root.right!=null){
                    dq1.offerLast(root.right);
                }
                root = dq1.peekFirst();
            }
            root = dq1.peekLast();
            while(root!=null){  // checking if we traversed the queue from bottom and reached till null
                root = dq1.pollLast();
                System.out.print(root.data + ",");
                if(root.right!=null){
                    dq1.offerFirst(root.right);
                }
                if(root.left!=null){
                    dq1.offerFirst(root.left);
                }
                root = dq1.peekLast();
            }

        }

    }


}
