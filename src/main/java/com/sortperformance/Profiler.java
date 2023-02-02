package com.sortperformance;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Profiler {

    public static Long test(ArrayList<SortItem> list, Sorter sorter) {
        long start = System.nanoTime();

        sorter.execute(list);

        long finish = System.nanoTime();

        long timeElapsed = finish - start;
        long timeElapsedMicroseconds = TimeUnit.MICROSECONDS.convert(timeElapsed, TimeUnit.NANOSECONDS);

        return timeElapsedMicroseconds;
    }

    public static Long testAlreadyOrdered(int numbersCount, Sorter sorter) {
        ArrayList<SortItem> list = new ArrayList<SortItem>();
        for (int index = 0; index < numbersCount; index++) {
            list.add(new SortItem(index + 1));
        }

        long start = System.nanoTime();

        sorter.execute(list);

        long finish = System.nanoTime();

        long timeElapsed = finish - start;
        long timeElapsedMicroseconds = TimeUnit.MICROSECONDS.convert(timeElapsed, TimeUnit.NANOSECONDS);

        return timeElapsedMicroseconds;
    }
}
