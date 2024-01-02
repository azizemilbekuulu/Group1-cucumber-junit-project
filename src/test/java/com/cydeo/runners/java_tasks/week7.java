package com.cydeo.runners.java_tasks;

import com.sun.jdi.IntegerValue;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class week7 {
    public static void main(String[] args) {
        //Q.1
        int[] maxNum = {10, 9, 8, 74,6,1};
        System.out.println(maximumNumber(maxNum));

        //Q.2
        int[] sortedArray = {10, 9, 8, 74,6,1};
        System.out.println(Arrays.toString(sortedArray(sortedArray)));

        //Q.3
        int[] descendingArray = {10, 9, 8, 74,6,1};
        System.out.println(Arrays.toString(descendingOrder(descendingArray)));


    }
    //QUESTION 1:
    //Write a method that can find the maximum number from an int Array
    public static int maximumNumber(int[] array){
        int maxNum = 0;
        for (int eachNumber : array){
            if(eachNumber>maxNum) maxNum = eachNumber;
        }
        return maxNum;
    }
    //QUESTION 2:
    //Write a method that will sort an array in ascending order without using the sort method
    public static int[] sortedArray(int[] array){
        //convert the array into a tree map, and then convert it back to an array.
        Map<Integer, Integer> arrayToMap = new TreeMap<>();
        //storing all numbers of array into a treeMap using for each loop.
        for (int eachNumOfArray : array){
            arrayToMap.put(eachNumOfArray, eachNumOfArray);
        }
        //storing all "values" of the treeMap into a sorted array as int primitive values.
        int[] sortedArray = new int[arrayToMap.size()];
        int indexNumber = 0;
        for (int eachValue : arrayToMap.values()){
            sortedArray[indexNumber] = eachValue;
            indexNumber++;
        }

        return sortedArray;

    }
    //QUESTION 3:
    //Write a method that will sort an array in descending order without using the sort method
    public static int[] descendingOrder(int[] array){
        //Sort the array in ascending order using the method from question 2.
        int[] sortedArray = sortedArray(array);

        int[] descendingOrderArray = new int[sortedArray.length];

        for (int i = array.length-1, j = 0; i>=0; i--, j++){
            descendingOrderArray[j] = sortedArray[i];
        }

        return descendingOrderArray;
    }






}
