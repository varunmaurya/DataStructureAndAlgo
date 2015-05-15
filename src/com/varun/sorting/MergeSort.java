package com.varun.sorting;

import java.util.Arrays;

/**
 * Created by Varun on 5/9/2015.
 *
 */
public class MergeSort {
    static int[] tempArr; //O(n) aux space required
    public static void main(String[] args) {
        int[] unsortArr = {4,3,1,2,79,23,54,66,9,23,43,4};
        int len = unsortArr.length;
        tempArr = new int[len];
        System.out.println("Original Array : "+Arrays.toString(unsortArr));
        mergeSort(unsortArr,0,len-1);
        System.out.println("Sorted Array"+Arrays.toString(unsortArr));
    }

    private static void mergeSort(int[] unsortArr, int leftInd, int rightInd) {

        if(leftInd<rightInd){
            int mid = leftInd+(rightInd-leftInd)/2;
            mergeSort(unsortArr,leftInd,mid);
            mergeSort(unsortArr,mid+1,rightInd);
            mergeSortedArrays(unsortArr, leftInd, mid, rightInd);
        }

    }

    private static void mergeSortedArrays(int[] unsortArr, int left, int middle, int right) {
        int rightstrat = middle+1;
        System.out.println("Array to be merged  : "+Arrays.toString(unsortArr) + " with LeftArray ["+ left +","+ middle+"] Right Array [ "+rightstrat+", "+right+"]");
        int i = left;
        int j = middle+1;
        int k = left;
        //make a copy of array which we are sorting
        for (int l = left; l <=right ; l++) {
            tempArr[l] =unsortArr[l];
        }
        while(i<=middle && j <= right){
            if(tempArr[i]< tempArr[j]) {
                unsortArr[k] = tempArr[i];
                i++;
            }
            else{
                unsortArr[k] = tempArr[j];
                j++;
            }
            k++;
        }
        while(i<=middle){
            unsortArr[k]= tempArr[i];
            k++;
            i++;
        }

        System.out.println("Array After Merge  : " + Arrays.toString(unsortArr));



    }


}
