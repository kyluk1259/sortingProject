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
            // If current value is less than or equal to the pivot, increase by 1
            if (arr[j] <= pivotVal) {
                pivotInd++;

                // swap arr[pivotInd] and arr[j] 
                swap(arr, pivotInd, j);
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
            part = partition(arr, min, size);

            // Recursively sort values of partition and repaint visuals     
            
            try {
                Thread.sleep(00000000002);
            } catch (Exception e) {
                e.printStackTrace();
            }
            sort(arr, min, part - 1);
            sort(arr, part + 1, size);
            repaint();
        }
    }

    //Update visuals on JFrame after each stage of sorting
    void repaint() {
        
        for (int i = 0; i < bars.size()-1; i++) {
            
            content.updateUI();
             try {
                Thread.sleep(000000000015);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(i == pivotInd){
            bars.get(i).setBackground(Color.red);
            }else if (i == n-1){
                bars.get(i).setBackground(Color.green);
            }else{
                 bars.get(i).setBackground(Color.white);
            }
            bars.get(i).setBorder(blackline);
            bars.get(i).setBounds((int) ((WIDTH / arr.length) * i), 500 - arr[i], (int) (WIDTH / arr.length), arr[i]);
            bars.get(i).setVisible(true);
            bars.get(i).isOptimizedDrawingEnabled();
            content.updateUI();
        }
    }
}
