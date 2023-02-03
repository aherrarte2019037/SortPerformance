package com.sortperformance;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.Test;

public class GnomeSortTest {
    private static final int numbersCount = 20;

    @Test
    public void gnomeShouldSort() throws IOException {
        RandomFileManager fileManager = new RandomFileManager();
        GnomeSort gnomeSort = new GnomeSort();

        fileManager.saveRandomNumbers(numbersCount);
        ArrayList<SortItem> randomNumbers = fileManager.readRandomNumbers();

        ArrayList<SortItem> gnomeSorted = gnomeSort.execute(randomNumbers);
        ArrayList<SortItem> sorted = fileManager.readRandomNumbers();

        Collections.sort(sorted);

        assertEquals(gnomeSorted.get(0).getValue(), 1);
        assertEquals(gnomeSorted.get(19).getValue(), 20);
    }
}
