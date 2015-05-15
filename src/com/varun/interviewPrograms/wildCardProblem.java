package com.varun.interviewPrograms;

/**
 * Created by Varun on 5/9/2015.
 * wildcard "?" can take value as 0 or 1
 * 00?  == > 000,001
 * 0?? ==> 000,001,010,011
 */
public class wildCardProblem {
    public static void main(String[] args) {
        String key = "00?";
        generateAllPossibilities(key);
    }

    private static void generateAllPossibilities(String key) {

        if(key.contains("?")){
            generateAllPossibilities(key.replaceFirst("\\?","0"));
            generateAllPossibilities(key.replaceFirst("\\?","1"));
        }
        else{
            System.out.println(key);
        }
    }
}
