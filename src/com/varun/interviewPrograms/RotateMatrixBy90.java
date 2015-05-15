package com.varun.interviewPrograms;

/**
 * Created by Varun on 5/1/2015.
 * Rotating matrix by 90 degree is nothing but converting rows into column.
 * 1st row becomes last column.
 * Time complexity => O(n^2)
 */
public class RotateMatrixBy90 {

    public static void main(String[] args) {
        int[][] matrices = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("original Matrix ");
        printMatrices(matrices);
        int[][] temp=rotateBy90degree(matrices, 3);
        System.out.println("Rotated Matrix ");
        printMatrices(temp);
        }

    private static void printMatrices(int[][] temp) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(temp[i][j]);
            }
            System.out.println("");
        }
    }

    private static int[][] rotateBy90degree(int[][] matrices, int n) {
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = matrices[n - j - 1][i];
            }
        }
        return result;
    }

}

