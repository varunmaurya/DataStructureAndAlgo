package com.varun.interviewPrograms;

/**
 * Created by Varun on 5/3/2015.
 * Tower of hanoi takes 2^n - 1 moves
 */
public class TowerOfHanoiRecursive {
    public static void main(String[] args) {
        int numOfDisk = 4;
        createTOH(numOfDisk, "Source", "Dest", "Aux-Space");
    }

    private static void createTOH(int numOfDisk, String source, String dest, String aux) {
        if(numOfDisk == 1){
            System.out.println("moving disk "+numOfDisk +" from "+source +" to "+dest);
            return;
        }
        createTOH(numOfDisk - 1, source, aux, dest);
        System.out.println("Moving disk "+numOfDisk+" from " +source +" to "+dest );
        createTOH(numOfDisk - 1, aux, dest, source);
    }

}
