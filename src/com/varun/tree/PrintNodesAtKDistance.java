package com.varun.tree;

/**
 * Created by Varun on 5/3/2015.
 * Print all the nodes situated at K distance from any given Node in a tree.
 * Tree in example ===>        10
 *                            /  \
 *                           8    17
 *                          /     /
 *                         6     12
 *                          \
 *                           7
 */
public class PrintNodesAtKDistance {

    public static void main(String[] args) {
        Node root = new Node(10);
        Node n1 = new Node(8);
        Node n2 = new Node(6);
        Node n3 = new Node(17);
        Node n4 = new Node(12);
        Node n5 = new Node(7);

        root.left = n1;
        n1.left= n2;
        root.right = n3;
        n3.left=n4;
        n2.right=n5;

        prinNodesAtKDistance(root,n1,2);

    }

    private static int prinNodesAtKDistance(Node root, Node targeNode, int k) {
        if(root == null){return -1;}
        if(root == targeNode){ // All the nodes at k distance would be child of root node.
            prinNodesAtKDistanceBelowRoot(root, k);
            return 0;
        }
        // if target node is a part of subtree of original tree. Then there would be possible nodes at length of K in
        // parent tree structure.Lets first see on which side of the root is target?

        int distLeft = prinNodesAtKDistance(root.left,targeNode,k); // distleft is distance of root.left from target
        if(distLeft !=-1){ // traversed left subtree and found the target node.
            if(1+distLeft == k){
                System.out.println(root.left.data);
            }
        }

        return -1;
    }

    private static void prinNodesAtKDistanceBelowRoot(Node root, int k) {
        if(root == null){return ;}
        if(k==0){
            System.out.println(root.data);
        }
        prinNodesAtKDistanceBelowRoot(root.left,k-1);
        prinNodesAtKDistanceBelowRoot(root.right,k-1);
    }
}
