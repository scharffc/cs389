package junitdemo;

import java.util.concurrent.RecursiveTask;

public class RecursiveBinarySearch {

    /**
     * Searches for a given value in a sorted array using the recursive binary search algorithm
     * Precondition: The array is sorted
     *
     * @param arr    The sorted array to search within.
     * @param left   The starting index of the current search range.
     * @param right  The ending index of the current search range.
     * @param key    The value to search for.
     * @return The index of the key if found, otherwise -1.
     */
    public static int binarySearch(int[] arr, int left, int right, int key) {
        // Base case: If the search range is invalid (left > right), the key is not found.
        if (left > right) {
            return -1;
        }

        // Calculate the middle index.
        // Using (left + right) / 2 can lead to overflow for very large arrays,
        // so left + (right - left) / 2 is preferred.
        int mid = left + (right - left) / 2;

        // If the key is found at the middle index, return the index.
        if (arr[mid] == key) {
            return mid;
        } 
        // If the key is smaller than the middle element, search in the left subarray.
        else if (arr[mid] > key) {
            return binarySearch(arr, left, mid - 1, key);
        } 
        // If the key is larger than the middle element, search in the right subarray.
        else { // arr[mid] < key
            return binarySearch(arr, mid + 1, right, key);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Binary search");
        int[] sortedArray = {1,5,6,20};
        int key = 5;
        int index = RecursiveBinarySearch.binarySearch(sortedArray, 0, sortedArray.length, key);
        System.out.println("index = " + index);
    }

}
