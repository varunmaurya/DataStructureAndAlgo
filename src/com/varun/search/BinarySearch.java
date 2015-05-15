package com.varun.search;

/**
 * Created by Varun on 5/2/2015.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr1 = {2,4,6,9,12,45,32,7};
        BinarySearch(arr1,0,arr1.length-1,11);
    }

    private static void BinarySearch(int[] arr, int left,int right, int x){

        while(left<=right){
            int m = (right+left)/2;
            if(arr[m]==x){
                System.out.println("Data found in array :"+ x);
                break;
            }
            if(arr[m]>x){
                right= m-1;
            }
            if(arr[m]<x){
                left=m+1;
            }

        }
        if(left>right)
        System.out.println("Data Not found in array :" +x);
    }
}
