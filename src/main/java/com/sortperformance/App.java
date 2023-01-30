package com.sortperformance;

import java.io.IOException;
import java.util.ArrayList;

public class App {
    // Count of random numbers to be generated
    public static final int numbersCount = 10;

    public static void main(String[] args) throws IOException {
        RandomFileManager fileManager = new RandomFileManager();
        SortList sortList = new SortList();

        fileManager.saveRandomNumbers(numbersCount);
        ArrayList<SortItem> randomNumbers = fileManager.readRandomNumbers();

        Long timeMicroseconds = Profiler.test((list) -> sortList.gnome(list), randomNumbers);
        System.out.println(timeMicroseconds);
    }
}
