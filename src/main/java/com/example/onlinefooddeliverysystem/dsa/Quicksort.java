package com.example.onlinefooddeliverysystem.dsa;

import com.example.onlinefooddeliverysystem.models.Food;

public class Quicksort {

    // Method to quicksort the array of food items by price
    public static void quickSort(Food[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // Get partition index
            quickSort(arr, low, pi - 1);  // Sort left part
            quickSort(arr, pi + 1, high); // Sort right part
        }
    }

    // Partition logic to place pivot in correct position
    private static int partition(Food[] arr, int low, int high) {
        double pivot = arr[high].getPrice(); // Choose pivot (last item's price)
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].getPrice() <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                Food temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in correct location
        Food temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}

