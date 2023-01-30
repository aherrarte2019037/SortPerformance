package com.sortperformance;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class Profiler {

    public static Long test(Consumer<ArrayList<SortItem>> consumer, ArrayList<SortItem> list) {
        long start = System.nanoTime();

        consumer.accept(list);

        long finish = System.nanoTime();

        long timeElapsed = finish - start;
        long timeElapsedMicroseconds = TimeUnit.MICROSECONDS.convert(timeElapsed, TimeUnit.NANOSECONDS);

        return timeElapsedMicroseconds;
    }
}
