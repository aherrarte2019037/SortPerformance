package com.sortperformance;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.Test;

public class MergeSortTest {
    private static final int numbersCount = 20;

    @Test
    public void mergeShouldSort() throws IOException {
        RandomFileManager fileManager = new RandomFileManager();
        MergeSort mergeSort = new MergeSort();

        fileManager.saveRandomNumbers(numbersCount);
        ArrayList<SortItem> randomNumbers = fileManager.readRandomNumbers();

        ArrayList<SortItem> mergeSorted = mergeSort.execute(randomNumbers);
        ArrayList<SortItem> sorted = fileManager.readRandomNumbers();

        Collections.sort(sorted);

        assertEquals(mergeSorted.get(0).getValue(), 1);
        assertEquals(mergeSorted.get(19).getValue(), 20);
    }
}
