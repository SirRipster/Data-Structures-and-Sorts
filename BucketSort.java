// Name: David Ripley
// Class: CS 3305/Section3
// Term: Spring 2025
// Instructor: Umana Tasnim
// Assignment: 5

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BucketSorting {
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
        
        // Perform bucket sort
        bucketSort(arr);
        
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
    
    public static void bucketSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        
        // Find maximum and minimum values
        int max = arr[0];
        int min = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        
        // Create buckets
        int bucketCount = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }
        
        // Distribute input array values into buckets
        for (int num : arr) {
            int bucketIndex = (num - min) / arr.length;
            buckets.get(bucketIndex).add(num);
        }
        
        // Sort each bucket and place back into input array
        int currentIndex = 0;
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int num : bucket) {
                arr[currentIndex++] = num;
            }
        }
    }
}
    }