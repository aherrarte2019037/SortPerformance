package com.sortperformance;

import java.util.ArrayList;

// Base del programa tomadas de la pagina geeksforgeeks

@SuppressWarnings("unchecked")
public class InsertSort implements Sorter {
	public ArrayList<SortItem> execute(ArrayList<SortItem> list) {
		ArrayList<SortItem> listClone = (ArrayList<SortItem>) list.clone();
		sort(listClone);

		return listClone;
	}

	void sort(ArrayList<SortItem> arr) {
		int n = arr.size();
		for (int i = 1; i < n; ++i) {
			int key = arr.get(i).getValue();
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are
			 * greater than key, to one position ahead
			 * of their current position
			 */
			while (j >= 0 && arr.get(j).getValue() > key) {
				arr.set(j + 1, arr.get(j));
				j = j - 1;
			}
			arr.set(j + 1, new SortItem(key));
		}
	}
};