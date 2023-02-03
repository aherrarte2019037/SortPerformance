package com.sortperformance;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class RadixSortTest {
    private static final int numbersCount = 20;

    @Test
    public void radixShouldSort() throws IOException {
        RandomFileManager fileManager = new RandomFileManager();
        RadixSort radixSort = new RadixSort();

        fileManager.saveRandomNumbers(numbersCount);
        ArrayList<SortItem> randomNumbers = fileManager.readRandomNumbers();

        ArrayList<SortItem> radixSorted = radixSort.execute(randomNumbers);
        ArrayList<SortItem> sorted = fileManager.readRandomNumbers();

        Collections.sort(sorted);

        assertEquals(radixSorted.get(0).getValue(), 1);
        assertEquals(radixSorted.get(19).getValue(), 20);
    }
}
