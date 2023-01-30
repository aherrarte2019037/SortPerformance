package com.sortperformance;

import java.util.ArrayList;
import java.util.Collections;

public class RandomGenerator {
    public ArrayList<SortItem> generate(int count) {
        ArrayList<SortItem> list = new ArrayList<SortItem>();

        for (int index = 1; index < (count + 1); index++)
            list.add(new SortItem(index));

        Collections.shuffle(list);
        return list;
    }
}
