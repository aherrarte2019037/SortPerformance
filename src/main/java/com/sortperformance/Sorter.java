package com.sortperformance;

import java.util.ArrayList;

abstract interface Sorter {
    public ArrayList<SortItem> execute(ArrayList<SortItem> list);
}
