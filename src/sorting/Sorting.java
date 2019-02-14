/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author myego
 */
public class Sorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        long start;
        long stop;
        long elapsedTime;
        
        long sum = 0;
        long avg = 0;
        int  times =10;
        
        int arrlen = 10000;
        
        RandomArray array = new RandomArray();
        Double[] newArray1 = array.fillArray(arrlen);
        Double[] newArray2 = array.fillArray(arrlen);
        Double[] newArray3;
        List <Double> newArraylList1;

        start = System.nanoTime();
        QuickSort2.sort(newArray1); //test QuickSort2
        stop = System.nanoTime();
        elapsedTime = stop - start;
        System.out.println("\n Time Performance of QuickSort2 :\n " + elapsedTime);

        start = System.nanoTime();
        QuickSort.sort(newArray2);//test QuickSort
        stop = System.nanoTime();
        elapsedTime = stop - start;
        System.out.println("\n Time Performance of QuickSort1 :\n " + elapsedTime );

        //calculate average 
        for (int i = 0; i < times; i++) {
            newArray3 = array.fillArray(arrlen);
            start = System.nanoTime();
            java.util.Arrays.sort(newArray3);//test java.util.Arrays.sort
            stop = System.nanoTime();
            elapsedTime = stop - start;
            sum += elapsedTime;
        }
        avg = sum / times;
        System.out.println("\n Time Performance of default sorting algorithm:\n " + avg );

        sum = 0;
        for (int i = 0; i < times; i++) {
            newArraylList1 = array.createList(20000);
            start = System.nanoTime();
            newArraylList1.parallelStream().sorted().toArray(Double[]::new);//test parallel Stream sorting algorithm
            stop = System.nanoTime();
            elapsedTime = stop - start;
            sum += elapsedTime;
        }
        avg = sum / times;
        System.out.println("\n Time Performance of parallel stream sorting algorithm:\n " + avg );

        //test if the arrays were sorted right and print out result
        System.out.println("\n " + QuickSort2.isSorted(newArray1) + "\n " + QuickSort2.isSorted(newArray1) + "\n " + QuickSort2.isSorted(newArray1) + "\n");

    }

}
