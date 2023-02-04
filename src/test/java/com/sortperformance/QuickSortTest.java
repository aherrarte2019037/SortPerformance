package com.sortperformance;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.Test;

public class QuickSortTest {
    private static final int numbersCount = 20;

    @Test
    public void quickShouldSort() throws IOException {
        RandomFileManager fileManager = new RandomFileManager();
        QuickSort quickSort = new QuickSort();

        fileManager.saveRandomNumbers(numbersCount);
        ArrayList<SortItem> randomNumbers = fileManager.readRandomNumbers();

        ArrayList<SortItem> quickSorted = quickSort.execute(randomNumbers);
        ArrayList<SortItem> sorted = fileManager.readRandomNumbers();

        Collections.sort(sorted);

        assertEquals(quickSorted.get(0).getValue(), 1);
        assertEquals(quickSorted.get(19).getValue(), 20);
    }
}
