package com.sortperformance;

import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class SortList {

    public ArrayList<SortItem> gnome(ArrayList<SortItem> list) {
        ArrayList<SortItem> listClone = (ArrayList<SortItem>) list.clone();

        int i = 1;
        int length = listClone.size();

        while (i < length) {
            if (i == 0 || listClone.get(i - 1).getValue() <= listClone.get(i).getValue()) {
                i++;
            } else {
                SortItem temp = listClone.get(i);
                listClone.set(i, listClone.get(i - 1));
                listClone.set(--i, temp);
            }
        }

        return listClone;
    }
}
