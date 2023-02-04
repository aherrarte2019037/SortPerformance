package com.sortperformance;

import java.io.IOException;
import java.util.ArrayList;

public class App {
    // Count of random numbers to be generated
    private static final int numbersCount = 5000;

    public static void main(String[] args) throws IOException {
        RandomFileManager fileManager = new RandomFileManager();

        fileManager.saveRandomNumbers(numbersCount);
        ArrayList<SortItem> randomNumbers = fileManager.readRandomNumbers();

        long mergeAverage = 0;
        long mergeAverageAlreadyOrdered = 0;
        long gnomeAverage = 0;
        long gnomeAverageAlreadyOrdered = 0;
        long radixAverage = 0;
        long radixAverageAlreadyOrdered = 0;
        long insertAverage = 0;
        long insertAverageAlreadyOrdered = 0;
        
        for (int i = 0; i < 3; i++) {
            MergeSort mergeSort = new MergeSort();
            long mergeTime = Profiler.test(randomNumbers, mergeSort);
            long mergeTimeAlreadyOrdered = Profiler.testAlreadyOrdered(numbersCount, mergeSort);
            mergeAverage = mergeAverage + mergeTime;
            mergeAverageAlreadyOrdered = mergeAverageAlreadyOrdered + mergeTimeAlreadyOrdered;

            GnomeSort gnomeSort = new GnomeSort();
            long gnomeTime = Profiler.test(randomNumbers, gnomeSort);
            long gnomeTimeAlreadyOrdered = Profiler.testAlreadyOrdered(numbersCount, gnomeSort);
            gnomeAverage = gnomeAverage + gnomeTime;
            gnomeAverageAlreadyOrdered = gnomeAverageAlreadyOrdered + gnomeTimeAlreadyOrdered;

            RadixSort radixSort = new RadixSort();
            long radixTime = Profiler.test(randomNumbers, radixSort);
            long radixTimeAlreadyOrdered = Profiler.testAlreadyOrdered(numbersCount, radixSort);
            radixAverage = radixAverage + radixTime;
            radixAverageAlreadyOrdered = radixAverageAlreadyOrdered + radixTimeAlreadyOrdered;
        
            InsertSort insertSort = new InsertSort();
            long insertTime = Profiler.test(randomNumbers, insertSort);
            long insertTimeAlreadyOrdered = Profiler.testAlreadyOrdered(numbersCount, insertSort);
            insertAverage = insertAverage + insertTime;
            insertAverageAlreadyOrdered = insertAverageAlreadyOrdered + insertTimeAlreadyOrdered;
        }

        mergeAverage = mergeAverage / 3;
        mergeAverageAlreadyOrdered = mergeAverageAlreadyOrdered / 3;

        gnomeAverage = gnomeAverage / 3;
        gnomeAverageAlreadyOrdered = gnomeAverageAlreadyOrdered / 3;

        radixAverage = radixAverage / 3;
        radixAverageAlreadyOrdered = radixAverageAlreadyOrdered / 3;
        
        insertAverage = insertAverage / 3;
        insertAverageAlreadyOrdered = insertAverageAlreadyOrdered / 3;

        System.out.println("Merge sort: " + mergeAverage + " microsegundos");
        System.out.println("Merge sort already ordered: " + mergeAverageAlreadyOrdered + " microsegundos");
        System.out.println();

        System.out.println("Gnome sort: " + gnomeAverage + " microsegundos");
        System.out.println("Gnome sort already ordered: " + gnomeAverageAlreadyOrdered + " microsegundos");
        System.out.println();

        System.out.println("Radix sort: " + radixAverage + " microsegundos");
        System.out.println("Radix sort already ordered: " + radixAverageAlreadyOrdered + " microsegundos");
        System.out.println();
        
        System.out.println("Insert sort: " + insertAverage + " microsegundos");
        System.out.println("Insert sort already ordered: " + insertAverageAlreadyOrdered + " microsegundos");
    }
}
