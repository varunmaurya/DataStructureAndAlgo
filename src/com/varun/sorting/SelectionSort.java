package com.varun.sorting;

/**
 * time complexity O(n^2)
 * array length = n
 * loop through the array from 0 -> n-1,
 * find the smallest number
 * swap with 0th element
 *
 * loop through the array from 1- > n-1
 * find the smallest number
 * swap with 1st element
 *
 * repeat intil last element
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr =  {5,4,12,7,1,3,8};
        System.out.println("Original Array : ");
        printArray(arr);
        int[] sortedArr = sortArray(arr);
        System.out.println("sorted Array : ");
        printArray(sortedArr);


    }

    private static int[] sortArray(int[] arr) {
        System.out.println("Sorting Steps ....");
        int arrLen = arr.length;

        for (int i = 0; i < arrLen-1; i++) {
            int minIndex = i;
            for (int j = i+1; j <arrLen ; j++) {
                if(arr[minIndex]>arr[j]){
                    minIndex = j;
                }
            }
            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
            printArray(arr);
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
