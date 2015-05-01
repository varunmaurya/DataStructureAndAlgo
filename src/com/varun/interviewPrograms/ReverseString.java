package com.varun.interviewPrograms;

/**
 * Created by Varun on 5/1/2015.
 * Different ways of reversing the String
 */
public class ReverseString {

    public static void main(String[] args) {
        String text = "My Name Is Java";
        System.out.println(reverseSentence(text));
        System.out.println(reverseAsString(text));
        System.out.println(new StringBuilder(text).reverse());
    }

    private static String reverseAsString(String text) {
        char[] chars = text.toCharArray();
        int len = chars.length;
        StringBuilder sb = new StringBuilder();
        for (int i = len-1; i >=0 ; i--) {
                sb.append(chars[i]);
        }
        return sb.toString();
    }

    private static String reverseSentence(String text) {
        int i = text.indexOf(" ");
        return i== -1?text : reverseSentence(text.substring(i + 1)) +" " + text.substring(0,i);
    }
}
