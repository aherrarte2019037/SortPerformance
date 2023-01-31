package com.sortperformance;

import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class MergeSort implements Sorter {
	public ArrayList<SortItem> execute(ArrayList<SortItem> list) {
		ArrayList<SortItem> listClone = (ArrayList<SortItem>) list.clone();
		sort(listClone, 0, listClone.size() - 1);

		return listClone;
	}

	void merge(ArrayList<SortItem> arr, int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr.get(l + i).getValue();
		for (int j = 0; j < n2; ++j)
			R[j] = arr.get(m + 1 + j).getValue();

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr.set(k, new SortItem(L[i]));
				i++;
			} else {
				arr.set(k, new SortItem(R[j]));
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr.set(k, new SortItem(L[i]));
			i++;
			k++;
		}

		while (j < n2) {
			arr.set(k, new SortItem(R[j]));
			j++;
			k++;
		}
	}

	void sort(ArrayList<SortItem> arr, int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = l + (r - l) / 2;

			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}
}