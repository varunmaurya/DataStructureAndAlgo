package com.varun.interviewPrograms;

/**
 *
 * find largest odd number in given String
 *
 */
public class largestOddNumber {
    public static void main(String[] args) {
        String num = "239537672423884969653287101";
        String largestOddNum = largestOddNum(num);
        System.out.println(largestOddNum);


    }

    private static String largestOddNum(String num) {
        if(Character.getNumericValue(num.charAt(num.length()-1))%2!=0) return num;

        for (int i = num.length()-1; i >= 0; i--) {
            int numAti = Character.getNumericValue(num.charAt(i));
            if(numAti%2!=0){
                return num.substring(0,i+1);
            }
        }
        return "";
    }


}
