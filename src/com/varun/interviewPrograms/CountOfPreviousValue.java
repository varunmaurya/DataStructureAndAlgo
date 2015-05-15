package com.varun.interviewPrograms;

import java.util.*;

/**
 * Created by Varun on 5/4/2015.
 * Consider series of numbers ==> 1, 11, 21, 1211, 111221, 312211,......
 * find the nth number of above series
 *
 * Solution : while paying close attention, we figured it out that from index 2 onwards... each index is representing
 * the number of different digits in value of previous index. eg value at index 4 = 1211 shows that at index 3 there is
 * exactly 1 count of number 2 and 1 count of number 1, value at index 5 = 111221 shows that at index 4 there is 1 count
 * of number 1 then 1 count of number 2 and then 2 count of number 1.
 */
public class CountOfPreviousValue {

    public static void main(String[] args) {
        int n = 7;
        System.out.println(findNthInSeries(n));
    }

    private static String findNthInSeries(int n) {
       String curr = "1";
        for (int i = 1; i <n ; i++) {
            curr = generateSeq(curr);
        }
        return curr;
    }

    private static String generateSeq(String curr) {

        String out="";
        if(curr.equals("1")){
            return "11";
        }
        else{

            for (int i = 1; i <=curr.length() ; i++) {
                int count=1;
                while(i<curr.length() &&(curr.charAt(i-1)==curr.charAt(i))){
                    count++;
                    i++;
                }
                out = out+count+curr.charAt(i-1);
            }
            return out;
        }

    }
}
