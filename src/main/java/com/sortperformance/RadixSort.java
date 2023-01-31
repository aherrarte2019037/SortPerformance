package com.sortperformance;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unchecked")
public class RadixSort implements Sorter {
    public ArrayList<SortItem> execute(ArrayList<SortItem> list) {
        ArrayList<SortItem> listClone = (ArrayList<SortItem>) list.clone();
        sort(listClone);

        return listClone;
    }

    private int getMax(ArrayList<SortItem> arr, int n) {
        int mx = arr.get(0).getValue();
        for (int i = 1; i < n; i++)
            if (arr.get(i).getValue() > mx)
                mx = arr.get(i).getValue();
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    private void countSort(ArrayList<SortItem> arr, int n, int exp) {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr.get(i).getValue() / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr.get(i).getValue() / exp) % 10] - 1] = arr.get(i).getValue();
            count[(arr.get(i).getValue() / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (i = 0; i < n; i++)
            arr.set(i, new SortItem(output[i]));
    }

    // The main function to that sorts arr[] of
    // size n using Radix Sort
    private void sort(ArrayList<SortItem> arr) {
        int n = arr.size();

        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
}
