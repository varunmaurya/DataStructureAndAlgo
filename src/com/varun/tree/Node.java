package com.varun.tree;

/**
 * Created by Varun on 5/3/2015.
 */
public class Node {
    // for ease of use i am making the attributes public, We should always make attributes private and should provide
    // getter and setter methods to access them
    public Object data;
    public Node left;
    public Node right;

    public Node(Object data){
        this.data = data;
        left=right=null;
    }

}
