package edu.dccarlos.util.algorithms;

public class SortingAlgorithms {
	public static final void insertionSort(int[] array) {
		for(int j = 1; j < array.length; j++) {
			int key = array[j];
			int i = j - 1;

			while(i > -1 && array[i] > key) {
				array[i + 1] = array[i];
				i = i - 1;
			}

			array[i + 1] = key;
		}
	}
}