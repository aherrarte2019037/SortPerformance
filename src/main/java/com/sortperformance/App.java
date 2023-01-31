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

        GnomeSort gnomeSort = new GnomeSort();
        Long gnomeTime = Profiler.test((list) -> gnomeSort.execute(list), randomNumbers);
        System.out.println("Gnome sort: " + gnomeTime + " microsegundos");

        MergeSort mergeSort = new MergeSort();
        Long mergeTime = Profiler.test((list) -> mergeSort.execute(list), randomNumbers);
        System.out.println("Merge sort: " + mergeTime + " microsegundos");
    }
}
