package com.varun.interviewPrograms;

import java.util.Arrays;

/**
 * Created by Varun on 5/2/2015.
 */
public class UnionIntersectionOfArray {

    public static void main(String[] args) {
        int[] arr1 = {1,3,4,6,7,9,12};
        int[] arr2 = {3,6,21,8,24,20,16};
        System.out.println("Array 1 : "+Arrays.toString(arr1));
        System.out.println("Array 2 : "+Arrays.toString(arr2));
        System.out.println("Union Of Arrays");
        System.out.println(Arrays.toString(unionArr(arr1, arr2)));
        System.out.println("Intersection Of Arrays");
        intersectionArr(arr1,arr2);
    }

    private static int[] unionArr(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;

        int[] unionArr = new int[len1+len2];
        //sort the small array
        if(len1>len2){
            Arrays.sort(arr2);
            CombineArrays(arr1, arr2, len1, len2,  unionArr);
        }else{
            Arrays.sort(arr1);
            CombineArrays(arr2, arr1, len2, len1,  unionArr);
        }

        return unionArr;
    }

    private static void CombineArrays(int[] unsortedArr, int[] sortedArr, int unsortedArrLen, int sortedArrLen,int[] finalArr) {
        int incrementer=0; // using this to avoid 0s in between the final array in case there are common values in two arrays
        for (int i = 0; i <sortedArrLen ; i++) {
            finalArr[i]=sortedArr[i];
        }
        for(int j=0;j<unsortedArrLen;j++){
            if(!BinarySearch(sortedArr,0,sortedArrLen-1,unsortedArr[j])){
                finalArr[sortedArrLen+incrementer]=unsortedArr[j];
                incrementer++;
            }
        }
    }

    private static boolean BinarySearch(int[] arr, int left,int right, int x){

        while(left<=right){
            int m = (right+left)/2;
            if(arr[m]==x){
                return true;
            }
            if(arr[m]>x){
                right= m-1;
            }
            if(arr[m]<x){
                left=m+1;
            }

        }
        return false;
    }

    private static void intersectionArr(int[] int1, int[] int2) {
        int len1 = int1.length;
        int len2 = int2.length;
        int[] finalArr;
        if(len1>len2){
            finalArr = new int[len2];
            Arrays.sort(int2);
            for(int j=0;j<int1.length-1;j++){
                if(BinarySearch(int2,0,int2.length-1,int1[j])){
                    finalArr[j]=int1[j];
                }
            }

        }
        else{
            finalArr = new int[len1];
            Arrays.sort(int1);
            for(int j=0;j<int2.length-1;j++){
                if(BinarySearch(int1,0,int1.length-1,int2[j])){
                    finalArr[j]=int2[j];
                }
            }
        }

        System.out.println(Arrays.toString(finalArr));


    }
}
