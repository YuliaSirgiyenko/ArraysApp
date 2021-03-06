package com.sirgiyenko;

//Demonstration of methods of OwnArray class.
public class MainDemo {

    public static void main(String[] args) {

        //Variable for calculation of time for sort mehtods.
        long start, finish;

        //Demo - creation of new random int array and its printing to console.
        OwnArrays arrayDemo = new OwnArrays(24);
        System.out.print("New random array for search of min/max elements: ");
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

        /*Demo - creation of new definite sorted int array, its printing to console and
        * demonstration of binary search. */
        OwnArrays arrayDemoSorted = new OwnArrays(10, 5);
        System.out.print("\nNew SORTED array for demonstration of binary search: ");
        arrayDemoSorted.arrayPrint(arrayDemoSorted.array);
        int searchedElement = 6;
        int searchedIndex = arrayDemoSorted.binarySearch(arrayDemoSorted.array, searchedElement, 0, arrayDemoSorted.array.length-1);
        if (searchedIndex == -1) {
            System.out.println("Element " + searchedElement + " isn't founded in array.");
        } else {
            System.out.println("Index of searched element of array (counting from zero) " + searchedElement + " is: " + searchedIndex);
        }

        /*Demo - sort methods for array sorting with calculation of time for each method working with
        * the same array*/
        System.out.print("\nRepeated print of random array for sort methods check: ");
        arrayDemo.arrayPrint(arrayDemo.array);

        //Bubble sort.
        System.out.print("\nArray after sorting by Bubble Sort  (from min to max): ");
        start = System.nanoTime();
        int [] arrayAfterBubble = arrayDemo.bubbleSortToMax(arrayDemo.array.clone());
        finish = System.nanoTime();
        arrayDemo.arrayPrint(arrayAfterBubble);
        System.out.println("Time for Bubble Sort method working in nanoseconds - " + (finish - start));

        //Quick sort.
        System.out.print("\nArray after sorting by Quick Sort   (from min to max): ");
        start = System.nanoTime();
        int [] arrayAfterQuick = arrayDemo.quickSortToMax(arrayDemo.array.clone(), 0, (arrayDemo.array.clone().length-1));
        finish = System.nanoTime();
        arrayDemo.arrayPrint(arrayAfterQuick);
        System.out.println("Time for Quick Sort method working in nanoseconds - " + (finish - start));

        //Merge sort.
        System.out.print("\nArray after sorting by Merge Sort   (from min to max): ");
        start = System.nanoTime();
        int [] arrayAfterMerge = arrayDemo.mergeSortToMax(arrayDemo.array.clone(), 0);
        finish = System.nanoTime();
        arrayDemo.arrayPrint(arrayAfterMerge);
        System.out.println("Time for Merge Sort method working in nanoseconds - " + (finish - start));

    }
}
