package com.sortperformance;

public class SortItem implements Comparable<SortItem> {
    private int value;

    public SortItem(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(SortItem item) {
        return this.value - item.getValue();
    }

}
