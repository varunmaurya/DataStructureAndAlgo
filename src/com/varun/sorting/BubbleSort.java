package com.varun.sorting;

/**
 * O(n^2)
 *
 * Bubble Sort is the simplest sorting algorithm
 * that works by repeatedly swapping the adjacent
 * elements if they are in wrong order.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr =  {5,4,12,7,1,3,8};
        System.out.println("Original Array : ");
        printArray(arr);
        int[] sortedArr = bubbleSortArray(arr);
        System.out.println("sorted Array : ");
        printArray(sortedArr);
    }

    private static int[] bubbleSortArray(int[] arr) {
        System.out.println("Sorting Steps ... ");
        int len = arr.length;

        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len-1-i; j++) {
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                printArray(arr);
            }
        }
        return arr;
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

}
