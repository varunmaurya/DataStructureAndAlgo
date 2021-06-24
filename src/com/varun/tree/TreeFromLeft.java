package com.varun.tree;

public class TreeFromLeft {
    /**
     *      4
     *    5   6
     *  1   12
     *   7
     * @param args
     */
    public static int maxLevel = 0;
    public static void main(String[] args) {
        TNode root = new TNode(4);
        root.left = new TNode(5);
        root.right = new TNode(6);
        root.right.left = new TNode(12);

        root.left.left = new TNode(1);
        root.left.left.right = new TNode(7);

        printLeftView(root,1); // this must print 4,5,1,7
    }

    private static void printLeftView(TNode root, int level) {

        if (root== null) return;
        System.out.println("Maxlevel "+maxLevel+" level "+level);
        if(maxLevel < level){
            System.out.println(root.value);
            maxLevel++;
        }
        printLeftView(root.left,level+1);
        printLeftView(root.right,level+1);
    }

}

class TNode {
    TNode left,right;
    int value;

    public TNode(int value){
        this.value=value;
        left=right=null;
    }
}