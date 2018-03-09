package com.sirgiyenko;

//Demonstration of methods of OwnArray class.
public class MainDemo {

    public static void main(String[] args) {

        //Variable for calculation of time for sort mehtods.
        long start, finish;

        //Demo - creation of new random int array and its printing to console.
        OwnArrays arrayDemo = new OwnArrays(20);
        System.out.print("New array for check of methods working is: ");
        arrayDemo.arrayPrint(arrayDemo.array);

        //Demo - searching of min and max elements of array.
        System.out.println("Minimum element of array is " + arrayDemo.minimumValue());
        System.out.println("Maximum element of array is " + arrayDemo.maximumValue());

        //Demo - result of working of 2 recursion methods.
        System.out.println("\nRecursion task 1: to calculate sum of figures of number n = 54321. " +
                "Result is " + RecursionFunctions.sumByRecursion(54321));
        System.out.print("Recursion task 2: to print all numbers from 1 to number n = 10. " +
                "Result is "); RecursionFunctions.printByRecursion(10);
        System.out.println();

        /*Demo - sort methods for array sorting with calculation of time for each method working with
        the same array*/

        //Bubble sort.
        System.out.print("\nArray after sorting by Bubble Sort (from min to max): ");
        start = System.nanoTime();
        int [] arrayAfterBubble = arrayDemo.bubbleSortToMax();
        finish = System.nanoTime();
        arrayDemo.arrayPrint(arrayAfterBubble);
        System.out.println("Time for Bubble Sort method working in nanoseconds - " + (finish - start));



    }
}
