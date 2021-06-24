package com.varun.sorting;

/**
 * Time complexity : O(n^2)
 *
 * theoritically divide the array in two parts one sorted and another unsorted
 * Take elements from unsorted array and INSERT in sorted array at appropriate position.
 *
 * first element of array is sorted array, rest (1-> n-1) is unsorted array.
 * start looping from position i=1 and compare with all elements
 * of (0->i) i.e. sorted array and insert at appropriate position
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr =  {5,4,12,7,1,3,8};
        System.out.println("Original Array : ");
        printArray(arr);
        int[] sortedArr = InsertionSortArray(arr);
        System.out.println("sorted Array : ");
        printArray(sortedArr);


    }

    private static int[] InsertionSortArray(int[] arr) {
        System.out.println("Sorting Steps ...");
        int len = arr.length;
        for (int i = 1; i <len ; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j]>arr[i]){
                    int tmp = arr[j];
                    arr[j]=arr[i];
                    arr[i] = tmp;
                    printArray(arr);
                }
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
