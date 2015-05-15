package com.varun.heap;

import java.util.Arrays;

/**
 * Created by Varun on 5/7/2015.
 *
 * heap is specialized tree based data structure that satisfies heap property (Max or Min)
 * Max-Heap : parent Node would always be greater than child nodes
 * Min-Heap : parent Node would always be smaller than child nodes
 *
 * We can use this heap property to sort any given array.
 *
 * To create a heap : create a binary tree going down , left to right
 * We can represent this tree structure in form of Array as well where we can find the child and parents of any node
 * using below formula:
 * Childs of index i = 2i+1, 2i+2
 * parent of any index i = Floor{(i-1)/2}
 *
 */
public class Heap {
    public static void main(String[] args) {

        int[] unorderedArr = {4,12,3,6,2,10,7}; //Create a Max-heap out of this array
        heapSort(unorderedArr);
        System.out.println(Arrays.toString(unorderedArr));

    }

    private static void heapSort(int[] unorderedArr) {
        int size = unorderedArr.length-1;
        Heapify(unorderedArr,size); // creates heap
        for(int i = size; i>0;i--){ // since we have craeted max heap, top elements is always biggest.. swap it with last
                                    // element of array and again heapify the rest of the array so that next largest is on top
            swap(unorderedArr,0,i);
            Heapify(unorderedArr, i - 1);
        }
    }

    private static void Heapify(int[] unorderedArr,int size) {
        System.out.println("=========== Heapify Array ============");
        for(int i = size;i>=0;i-- ){
            MaxHeapCreater(unorderedArr, i);
        }
        System.out.println("heapify first "+size+" elemnts of array " +Arrays.toString(unorderedArr));
    }

    private static void MaxHeapCreater(int[] unorderedArr, int i) {
        //Here we are checking if for given value in Array , if the parent value is greater or not. If its not we swap
        // the values and again check for the parent of  this value for same.
          while(i>0){
            int parentInd = (i-1)/2;
            if(unorderedArr[i]>unorderedArr[parentInd]){
                swap(unorderedArr,i,parentInd);
                i=parentInd;
            }
            else{
                break;
            }
            System.out.println(Arrays.toString(unorderedArr));
        }

    }



    private static void swap(int[] unorderedArr, int parentIndex, int last) {
        int temp = unorderedArr[parentIndex];
        unorderedArr[parentIndex]=unorderedArr[last];
        unorderedArr[last]=temp;
    }

}
