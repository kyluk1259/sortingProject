/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingproject;

/**
 *
 * @author kyleluka
 */
public class QuicksortTrue {

    public static int pivotVal, returnInd, j, part;

    int partition(int arr[], int min, int size) {
        pivotVal = arr[size];
        returnInd = (min - 1); //the index of the smaller value 
        for (j = min; j < size; j++) {
            // If current value is less than or equal to the pivot 
            if (arr[j] <= pivotVal) {
                returnInd++;

                // swap arr[i] and arr[j] 
                swap(arr, returnInd, j);
            }
        }

        // swap arr[returnInd+1] and arr[size] 
        swap(arr, returnInd + 1, size);

        return returnInd + 1;
    }

    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //Main function that recursively calls itself() 
    void sort(int arr[], int min, int size) {

        if (min < size) {
            // part is the partitioning index, arr[part] should go to correect place 
            part = partition(arr, min, size);

            // Recursively sort values of partition 
            sort(arr, min, part - 1);
            sort(arr, part + 1, size);

        }
    }
}
