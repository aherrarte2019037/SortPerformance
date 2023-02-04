/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sortperformance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 50250
 */
public class InsertSortTest {
    private static final int numbersCount = 20;

    @Test
    public void testSort() throws IOException {
        RandomFileManager fileManager = new RandomFileManager();
        InsertSort insertSort = new InsertSort();

        fileManager.saveRandomNumbers(numbersCount);
        ArrayList<SortItem> randomNumbers = fileManager.readRandomNumbers();

        ArrayList<SortItem> radixSorted = insertSort.execute(randomNumbers);
        ArrayList<SortItem> sorted = fileManager.readRandomNumbers();

        Collections.sort(sorted);

        assertEquals(radixSorted.get(0).getValue(), 1);
        assertEquals(radixSorted.get(19).getValue(), 20);
    }
}
