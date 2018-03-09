package com.sirgiyenko;

import java.util.Random;

//Class for working with arrays.
public class OwnArrays {

    int[] array;

    //Creation of random int array with definite length.
    OwnArrays(int length){
        array = new int [length];
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            array[i] = rand.nextInt(50);
        }
    }

    //Array output to console.
    public void arrayPrint(int [] arrayForPrint) {
        for (int x : arrayForPrint) {
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

        int[] arrayForBubble = array.clone();
        int temp;

        for (int i = 0; i < arrayForBubble.length; i++) {
            for (int j = 0; j < (arrayForBubble.length - 1); j++) {
                if (arrayForBubble[j] > arrayForBubble[j + 1]) {
                    temp = arrayForBubble[j + 1];
                    arrayForBubble[j + 1] = arrayForBubble[j];
                    arrayForBubble[j] = temp;
                }
            }
        }

        return arrayForBubble;
    }

}
