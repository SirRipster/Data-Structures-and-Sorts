// Name: David Ripley
// Class: CS 3305/Section3
// Term: Spring 2025
// Instructor: Umana Tasnim
// Assignment: 5

import java.util.Scanner;

public class mergeSorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get array size from user
        System.out.print("Enter the number of elements in the array (1-1000): ");
        int n = scanner.nextInt();
        while (n < 1 || n > 1000) {
            System.out.println("Invalid size. Please enter a number between 1 and 1000.");
            n = scanner.nextInt();
        }
        
        // Get array elements from user
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array (1-10000):");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            while (arr[i] < 1 || arr[i] > 10000) {
                System.out.println("Invalid element. Please enter a number between 1 and 10000.");
                arr[i] = scanner.nextInt();
            }
        }
        
        // Print original array
        System.out.print("Unsorted Array: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        
        // Perform merge sort
        mergeSort(arr, 0, arr.length - 1);
        
        // Print sorted array
        System.out.print("Sorted Array: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        
        scanner.close();
    }
    
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;
            
            // Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            
            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }
    
    public static void merge(int[] arr, int left, int mid, int right) {
        // Sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[mid + 1 + j];
        }
        
        // Merge the temp arrays
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        
        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}