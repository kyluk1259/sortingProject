/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingproject;

import java.awt.Color;
import static sortingproject.SortingProject.*;

/**
 *
 * @author kyleluka
 */
public class Quicksort {

    public static int pivotVal, pivotInd, j, part, swi;

    int partition(int arr[], int min, int size) {
        swi = size;
        pivotVal = arr[size];
        pivotInd = (min - 1); //the index of the smaller value 

        for (j = min; j < size; j++) {
            bars.get(j).isPaintingForPrint();
            bars.get(j).isOptimizedDrawingEnabled();
            bars.get(j).setBackground(Color.blue);
            try {
                bars.get(j).wait(sleep);
            } catch (Exception e) {
            }

            // If current value is less than or equal to the pivot, increase by 1
            if (arr[j] <= pivotVal) {
                pivotInd++;

                // swap arr[pivotInd] and arr[j] 
                swap(arr, pivotInd, j);

                bars.get(pivotInd).isPaintingForPrint();
                bars.get(pivotInd).isOptimizedDrawingEnabled();

                bars.get(pivotInd).setBackground(Color.orange);
                try {
                    bars.get(pivotInd).wait(sleep);
                } catch (Exception e) {
                }
                content.updateUI();
            }
            try {
                Thread.sleep(sleep);
            } catch (Exception e) {
            }
        }

        // swap arr[pivotInd+1] and arr[size]        
        swap(arr, pivotInd + 1, size);

        //return next pivot index 
        return pivotInd + 1;
    }

    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //Main function that recursively calls QuickSort() 
    void sort(int arr[], int min, int size) {

        if (min < size) {
            // part is the partitioning index, arr[part] should go to correect place 
            try {
                wait(1);
            } catch (Exception e) {
            }
            part = partition(arr, min, size);

            // Recursively sort values of partition and repaint visuals            
            repaint();
            try {
                sort(arr, min, part - 1);
            } catch (StackOverflowError e) {
                sort(arr, part + 1, size);
            }
            sort(arr, part + 1, size);
        }
    }

    //Update visuals on JFrame after each stage of sorting
    void repaint() {

        for (int i = 0; i < bars.size() - 1; i++) {

            bars.get(i).setBackground(Color.white);
            bars.get(i).setBorder(blackline);
            bars.get(i).setBounds((int) ((WIDTH / arr.length) * i), 500 - arr[i], (int) (WIDTH / arr.length), arr[i]);
            bars.get(i).setVisible(true);
            bars.get(i).isOptimizedDrawingEnabled();
            bars.get(j).isPaintingForPrint();
            content.updateUI();
        }
    }
}
