package com.sirgiyenko;

//Realization of math tasks with recursion using.
public class RecursionFunctions {

    //Calculation of sum of figures of number n.
    public static int sumByRecursion(int n) {
        int sum = 0;

        if (n > 9) {
            sum = n%10 + sumByRecursion(n/10);
        } else {
            sum += n;
        }

        return sum;
    }

    //Printing of all numbers from 1 to number n.
    public static void printByRecursion(int n) {
        if (n > 0) {
            printByRecursion(n - 1);
            System.out.print(n + " ");
        }
    }

}
