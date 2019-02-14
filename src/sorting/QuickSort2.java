/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author myego
 */
public class QuickSort2 {

    public static void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);

    }

    static void sort(Comparable[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);

            int minLength = 10;
            
            

            /*if ((pivot - low - 1) < minLength && (pivot - low - 1) != 0) {
                InsertionSort.sort(array, low, pivot + 1);
                sort(array, pivot + 1, high);//sort right
                System.out.print(" Works (left)" + (pivot - low - 1) + "\n");

            } else if ((high - pivot + 1) < minLength && (high - pivot + 1) != 0) {
                InsertionSort.sort(array, pivot + 1, high + 1);
                System.out.print(" Works (right)" + (high - pivot + 1) + "\n");
                sort(array, low, pivot - 1); //sort left
            } else {
                sort(array, pivot + 1, high);//sort right
                sort(array, low, pivot - 1); //sort left
            }*/
             
            if ((pivot - low - 1) < minLength) {
                InsertionSort.sort(array, low, pivot + 1);
               // System.out.print(" Works (left)" + (pivot - low -1) + "\n");
            } else {
                sort(array, low, pivot - 1); //sort left
               // System.out.print(" Works quicksort left" + "\n");
            }
            if ((high - pivot + 1) < minLength) {
                InsertionSort.sort(array, pivot + 1, high + 1);
                //System.out.print(" Works (right)" + (high - pivot + 1) + "\n");
                
            } else {
                sort(array, pivot + 1, high);//sort right
                //System.out.print(" Works quicksort right \n");
            }

        }
    }


static int partition(Comparable[] array, int low, int high) {
        Comparable pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (lessEqual(array[j], pivot)) {
                i++;
                exchange(array, i, j);

            }
        }
        exchange(array, i + 1, high);
        return i + 1;
    }

    private static boolean lessEqual(Comparable v, Comparable w) {
        return (v.compareTo(w) <= 0);
    }

    private static void exchange(Comparable[] array, int i, int j) {
        Comparable t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static boolean isSorted(Double[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
