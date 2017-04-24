package edu.dccarlos.util.algorithms;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

public class TestSortingAlgorithms {
	private Map<Integer, int[]> unordered;
	private Map<Integer, int[]> ordered;

	@Before
	public void prepareUseCases() {
		unordered = new TreeMap<>();
		ordered = new TreeMap<>();

		int[] test01 = new int[]{4, 6, 7, 8, 1, 2, 6, 10, 10, 5, 6, 1, 2, 3, 4, 5, 67, 8};
		int[] test01Copy = Arrays.copyOf(test01, test01.length);

		unordered.put(1, test01);
		Arrays.sort(test01Copy);
		ordered.put(1, test01Copy);

		int[] test02 = new int[]{4, 6, 7, 4, 5, 67, 8, 1, 1, 1, 1, 1, 2, 2, 2, 2, 23, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0};
		int[] test02Copy = Arrays.copyOf(test02, test02.length);

		unordered.put(2, test02);
		Arrays.sort(test02Copy);
		ordered.put(2, test02Copy);
	}

	@Test
	public void testInsertionSort() {
		SortingAlgorithms.insertionSort(unordered.get(1));
		assertArrayEquals("Arrays wasn't ordered correctly!", unordered.get(1), ordered.get(1));

		SortingAlgorithms.insertionSort(unordered.get(2));
		assertArrayEquals("Arrays wasn't ordered correctly!", unordered.get(2), ordered.get(2));
	}
}