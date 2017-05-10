package edu.dccarlos.util.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayAlgorithms {
	public static final int getSubArrayIndex(int[] subArray, int[] array) {
		if((array.length - subArray.length) < 0) {
			return -1;
		}

		final int limit = array.length - subArray.length;

		for(int i = 0; i < limit + 1; i++) {

			boolean found = true;

			for(int j = 0; j < subArray.length && found; j++) {
				if(subArray[j] != array[i + j]) {
					found = false;
				}
			}

			if(found)
				return i;
		}

		return -1;
	}
	
	public static final boolean isContained(int P[][], int G[][]) {
		for(int gRow = 0; gRow < G.length; gRow++) {

			if(P.length < (G.length - gRow + 1)) {
				final List<Integer> foundRowsAt = getSubArrayIndexes(P[0], G[gRow]);

				for(Integer foundRowAt : foundRowsAt) {
					boolean found = true;

					for(int gIndex = gRow + 1, pRow = 1; (gIndex < G.length && pRow < P.length && found); gIndex++, pRow++) {
						found = getSubArrayIndexes(P[pRow], G[gIndex]).contains(foundRowAt);
					}

					if(found)
						return true;
				}

			} else
				return false;
		}

		return false;
	}

	public static final List<Integer> getSubArrayIndexes(int[] subArray, int[] array) {
		if((array.length - subArray.length) < 0) {
			Collections.emptyList();
		}

		final int limit = array.length - subArray.length + 1;
		List<Integer> indexes = new ArrayList<>();

		for(int i = 0; i < limit; i++) {

			boolean found = true;

			for(int j = 0; j < subArray.length; j++) {
				if(subArray[j] != array[i + j]) {
					found = false;
				}
			}

			if(found)
				indexes.add(i);
		}

		return indexes;
	}
}