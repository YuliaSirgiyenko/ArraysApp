package com.sirgiyenko;

//Demonstration of methods of OwnArray class.
public class MainDemo {

    public static void main(String[] args) {

        OwnArrays arrayDemo = new OwnArrays(10);
        System.out.print("New array for check of methods working is: ");
        arrayDemo.arrayPrint();

        System.out.println("Minimum element of array is " + arrayDemo.minimumValue());
        System.out.println("Maximum element of array is " + arrayDemo.maximumValue());

    }
}
