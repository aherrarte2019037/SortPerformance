/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sortperformance;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 50250
 */
public class InsertSortTest {
    
    public InsertSortTest() {
    }

    @Test
    public void testExecute() {
        System.out.println("execute");
        ArrayList<SortItem> list = null;
        InsertSort instance = new InsertSort();
        ArrayList<SortItem> expResult = null;
        ArrayList<SortItem> result = instance.execute(list);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSort() {
        System.out.println("sort");
        int[] arr = null;
        InsertSort instance = new InsertSort();
        instance.sort(arr);
        fail("The test case is a prototype.");
    }

    @Test
    public void testPrintArray() {
        System.out.println("printArray");
        int[] arr = null;
        InsertSort.printArray(arr);
        fail("The test case is a prototype.");
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        InsertSort.main(args);
        fail("The test case is a prototype.");
    }
    
}
