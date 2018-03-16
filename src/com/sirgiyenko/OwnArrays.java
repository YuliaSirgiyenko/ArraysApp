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
            array[i] = rand.nextInt(99);
        }
    }

    //Creation of sorted int array with definite length.
    OwnArrays(int length, int multiplication){
        array = new int [length];
        for (int i = 0; i < length; i++) {
            array[i] = i * multiplication;
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

    //Binary search in sorted array.
    public int binarySearch(int[] array, int searchedElement, int left, int right) {
        int searchedIndex = -1;

        if (searchedElement >= array[left] & searchedElement <= array[right]) {
            int baseElement = array[(right + left) / 2];
            if (searchedElement == baseElement) {
                searchedIndex = (right + left) / 2;
            } else if (searchedElement < baseElement) {
                searchedIndex = binarySearch(array, searchedElement, left, (right + left) / 2 - 1);
            } else if (searchedElement > baseElement) {
                searchedIndex = binarySearch(array, searchedElement, (right + left) / 2 + 1, right);
            }
        }

        return searchedIndex;
    }

    //Realization of bubble sort.
    public int[] bubbleSortToMax(int [] array){
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

    //Realization of quick sort.
    public int[] quickSortToMax(int[] array, int low, int high){

        if (low == high) {
            return array;
        }

        if ((low+1 == high) & (array[low] == array[high])) {
            return array;
        }

        //Base Element for sorting is last element of array.
        int baseElement = array[high];
        int quantityOfBaseElements = 1;
        //Temporary value for change making.
        int temp;

        /*Start index for part of array with elements lower than Base Element.
        * It's supposed initially is absent, so, definite as low index - 1.*/
        int i = low - 1;

        /*Last element of array for sorting.
        * Initially is lower for 1 element (last element = Base Element) than high level of array.*/
        int beforeBase = high - 1;

        //Cycle for dividing of array for 2 parts (up to Base Element & Higher than Base Element).
        for (int j = low; j <= beforeBase; j++) {

            /*If current element equal to Base Element, it will be changed with last element of sorted part
            * of array (without Base Element). As a result 2 (or more) last places will be occupied by Base Elements.
            * Sorted part of array is decreased for respective number of Base Elements.
            * Counter of Base Elements is increased respectively.*/
            while (array[j] == baseElement) {
                temp = array[j];
                array[j] = array[beforeBase];
                array[beforeBase] = temp;
                beforeBase--;
                quantityOfBaseElements++;
            }

            //Search of all elements lower than the Base Element and theirs transferring to the beginning of array.
            if (array[j] < baseElement) {
                i++;
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        /*As a result of last cicle:
        * - last index of elements lower than Base Element is i;
        * - first index of elements higher than Base Element is (i+1);
        * - first index of Base Element(s) is (beforeBase + 1);
        * - number of founded Base Elements is quantityOfBaseElements.*/

        //Block for transferring of Base Element(s) to their logical place between lower and high parts.
        int newHigh = i + 1;
        int newBase = beforeBase + 1;
        for (int j = 0; j < quantityOfBaseElements; j++) {
            temp = array[newHigh];
            array[newHigh] = baseElement;
            array[newBase] = temp;
            newHigh++;
            newBase++;
        }

        /*As a result of last block fulfillment:
        * - last index of elements lower than Base Element is i;
        * - first index of elements higher than Base Element is newHigh.*/

        if (low < i) {
            quickSortToMax(array, low, i);
        }

        if (newHigh < high) {
            quickSortToMax(array, newHigh, high);
        }

        return array;
    }

    //Realization of merge sort.
    public int[] mergeSortToMax(int[] array, int n){

        //Calculation of step for dividing (actually equal to actually sorted parts of array).
        int step = (n == 0) ? 1 : (n*2);

        /*Creation of 2 small arrays left and right. Sorted parts of initial array will be placed to left & right
        * for further merging.*/
        int leftAr[] = new int[step];
        int rightAr[] = new int[step];
        int i = 0, temp;

        while (i < array.length) {

            //Indexes for leftAr and rightAr respectively.
            int left = 0, right = 0;
            //Saving of current position of initial array. It will be used for re-filling of initial array by sorted values.
            int iStart = i;

            /*Dividing of array by 2 small arrays for further merge step-by-step. Step for dividing
             * is number of actually sorted positions of initial array (input parameter for method).*/

            /*Filling of left array. If there are enough elements for full left array, it will be filled fully.
            * In other case it will be filled partly.*/
            if ((i + step) < array.length) {
                for (int j = i; j < (i + step); j++) {
                    leftAr[left] = array[j];
                    left++;
                }
            } else {
                temp = array.length - i;
                for (int j = i; j < (i + temp); j++) {
                    leftAr[left] = array[j];
                    left++;
                }
            }
            i += step;

            /*Filling of right array in the same way.*/
            if ((i + step) < array.length) {
                for (int j = i; j < (i + step); j++) {
                    rightAr[right] = array[j];
                    right++;
                }
            } else if (i < array.length) {
                temp = array.length - i;
                for (int j = i; j < (i + temp); j++) {
                    rightAr[right] = array[j];
                    right++;
                }
            }
            i += step;

            /*Merging. At the beginning may be:
             * - 2 full arrays: left and right -> merging is needed;
             * - full left array and empty right -> left array is sorted, no needs in merging;
             * - partly filled left array and empty right -> left array is sorted, no needs in merging;
             * - full left array and partly filled right -> merging is needed.
             * Actual number of elements in each array known from indexes left & right.*/

            if (right != 0) {
                int leftCounter = 0, rightCounter = 0;

                while ((leftCounter < left) || (rightCounter < right)) {

                    if (leftCounter == left) {
                        array[iStart] = rightAr[rightCounter];
                        rightCounter++;
                    } else if (rightCounter == right) {
                        array[iStart] = leftAr[leftCounter];
                        leftCounter++;
                    } else if (rightAr[rightCounter] <= leftAr[leftCounter]) {
                        array[iStart] = rightAr[rightCounter];
                        rightCounter++;
                    } else if (leftAr[leftCounter] < rightAr[rightCounter]) {
                        array[iStart] = leftAr[leftCounter];
                        leftCounter++;
                    }
                    iStart++;
                }
            }

        }

        if (step * 2 < array.length) {
            mergeSortToMax(array, step);
        }

        return array;
    }

}
