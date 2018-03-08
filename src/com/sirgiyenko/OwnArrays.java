package com.sirgiyenko;

import java.util.Random;

//Class for working with arrays.
public class OwnArrays {

    private int[] array;

    //Creation of random int array with definite length.
    OwnArrays(int length){
        array = new int [length];
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            array[i] = rand.nextInt(50);
        }
    }

    //Array output to console.
    public void arrayPrint() {
        for (int x : array) {
            System.out.print(x + "  ");
        }
        System.out.println();
    }

    //Search of maximum element of array.
    public int maximumValue(){
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    //Search of minimum element of array.
    public int minimumValue(){
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    //Realization of bubble sort.

    public int[] bubbleSortToMax(){
        int temp;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < (array.length - 1); j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }

}
