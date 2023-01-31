package com.sortperformance;

import java.io.IOException;
import java.util.ArrayList;

public class App {
    // Count of random numbers to be generated
    private static final int numbersCount = 10;

    public static void main(String[] args) throws IOException {
        RandomFileManager fileManager = new RandomFileManager();

        fileManager.saveRandomNumbers(numbersCount);
        ArrayList<SortItem> randomNumbers = fileManager.readRandomNumbers();

        long mergeAverage = 0;
        long gnomeAverage = 0;
        long radixAverage = 0;

        for (int i = 0; i < 100; i++) {
            MergeSort mergeSort = new MergeSort();
            long mergeTime = Profiler.test(randomNumbers, mergeSort);
            mergeAverage = mergeAverage + mergeTime;

            GnomeSort gnomeSort = new GnomeSort();
            long gnomeTime = Profiler.test(randomNumbers, gnomeSort);
            gnomeAverage = gnomeAverage + gnomeTime;

            RadixSort radixSort = new RadixSort();
            long radixTime = Profiler.test(randomNumbers, radixSort);
            radixAverage = radixAverage + radixTime;
        }

        mergeAverage = mergeAverage / 100;
        gnomeAverage = gnomeAverage / 100;
        radixAverage = radixAverage / 100;

        System.out.println("Merge sort: " + mergeAverage + " microsegundos");
        System.out.println("Gnome sort: " + gnomeAverage + " microsegundos");
        System.out.println("Radix sort: " + radixAverage + " microsegundos");
    }
}
