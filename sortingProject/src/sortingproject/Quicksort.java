/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sortingproject;

import static sortingproject.SortingProject.paint;
import static sortingproject.SortingProject.repaint;

/**
 *
 * @author kyleluka
 */
public class Quicksort {
    
    int partition(int arr[], int min, int size) 
    { 
        int pivot = arr[size];  
        int i = (min-1); //the index of the smaller value 
        for (int j=min; j<size; j++) 
        { 
            // If current value is less than or equal to the pivot 
            if (arr[j] <= pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[size]; 
        arr[size] = temp; 
  
        return i+1; 
    } 
  
  
    //Main function that recursively calls QuickSort() 
    void sort(int arr[], int min, int size) 
    { 
        if (min < size) 
        { 
            // part is the partitioning index, arr[part] should go to correect place 
            int part = partition(arr, min, size); 
  
            // Recursively sort values of partition and repaint visuals
            repaint();
            sort(arr, min, part-1); 
            sort(arr, part+1, size); 
        } 
    } 
}
