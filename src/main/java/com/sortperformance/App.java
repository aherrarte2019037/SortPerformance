package com.sortperformance;

import java.io.IOException;
import java.util.ArrayList;

public class App {
    // Count of random numbers to be generated
    public static final int numbersCount = 10;

    public static void main(String[] args) throws IOException {
        // Save random numbers to file
        RandomFileManager fileManager = new RandomFileManager();
        fileManager.saveRandomNumbers(numbersCount);

        // Read random numbers from file
        ArrayList<SortItem> randomNumbers = fileManager.readRandomNumbers();
    }
}
