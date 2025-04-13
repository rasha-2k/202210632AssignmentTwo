import java.util.*;

/**
 * This class demonstrates sorting algorithms: QuickSort and MergeSort.
 * It includes methods to sort an array using both algorithms and a main method to test them.
 * 
 * @author Rasha Alsaleh
 * @version 1.0
 * @since 14-April-2024
 */
public class SortExample {
    /**
     * The main method where the program starts. It demonstrates sorting using QuickSort and MergeSort.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // This is unsorted array
        Integer[] array1 = new Integer[] { 12, 13, 24, 10, 3, 6, 90, 70 };
        int array2[] = { 2, 6, 3, 5, 1 };

        // Let's sort using quick sort
        quickSort(array1, 0, array1.length - 1);

        // Verify sorted array
        System.out.println(Arrays.toString(array1));
        mergeSort(array2, array2.length - 1);

        // Verify sorted array
        System.out.println(Arrays.toString(array2));
    }

    /**
     * Sorts an array using the QuickSort algorithm.
     *
     * The array is partitioned based on a pivot element, and the sub-arrays are sorted recursively.
     * 
     * @param arr  the array that needs to be sorted
     * @param low  the starting index of the sub-array
     * @param high the ending index of the sub-array
     */
    public static void quickSort(Integer[] arr, int low, int high) {

        // check for empty or null array
        if (arr == null || arr.length == 0) {
            return;
        }

        // If low is greater than or equal to high, it's already sorted
        if (low >= high) {
            return;
        }

        // Get the pivot element from the middle of the list
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            // Check until all values on left side array are lower than pivot
            while (arr[i] < pivot) {
                i++;
            }

            // Check until all values on left side array are greater than pivot
            while (arr[j] > pivot) {
                j--;
            }

            // Now compare values from both side of lists to see if they need swapping
            // After swapping move the iterator on both lists
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        // Do same operation as above recursively to sort two sub arrays
        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, i, high);
        }
    }

    /**
     * Swaps two elements in an array.
     *
     * @param array the array that contains the elements to be swapped
     * @param x     the index of the first element
     * @param y     the index of the second element
     */
    public static void swap(Integer array[], int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    /**
     * Sorts an array using the MergeSort algorithm.
     *
     * The array is divided into two halves, which are sorted recursively, and then merged back together.
     * 
     * @param a the array that needs to be sorted
     * @param n the length of the array
     */
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return; // Base case: if the array has 1 or 0 elements, it's already sorted
        }
        int mid = n / 2;
        int[] l = new int[mid]; // the left half of the array
        int[] r = new int[n - mid]; // the right half of the array

        // Copy data to left and right sub-arrays l[] and r[]
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }

        // Recursively sort the sub-arrays l[] and r[]
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        // Merge the sorted sub-arrays back into the original array a[]
        merge(a, l, r, mid, n - mid);
    }

    /**
     * Merges two sorted sub-arrays into a single sorted array.
     *
     * @param a     the original array
     * @param l     the left sub-array
     * @param r     the right sub-array
     * @param left  the length of the left sub-array
     * @param right the length of the right sub-array
     */
    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;

        // Merge the two sub-arrays into the original array a[]
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }

        // Copy the remaining elements from the left sub-array
        while (i < left) {
            a[k++] = l[i++];
        }

        // Copy the remaining elements from the right sub-array
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    /**
     * Checks if an array is sorted.
     *
     * @param x the array that needs to be checked
     * @return true if the array is sorted, false otherwise
     */
    private static boolean isSorted(int[] x) {
        for (int i = 0; i < x.length - 1; i++)
            if (x[i] > x[i + 1])
                return false;
        return true;
    }
}