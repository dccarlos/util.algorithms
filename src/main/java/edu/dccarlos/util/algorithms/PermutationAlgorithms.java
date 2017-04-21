package edu.dccarlos.util.algorithms;

public class PermutationAlgorithms {

	public static final void heapAlgorithmIterative(int n, char[] A) {
		int controller[] = new int[n];
		int upperIndex = 1;

		printArray(0, 0, A);

		while(upperIndex < n) {
			if(controller[upperIndex] < upperIndex) {
				int lowerIndex = upperIndex % 2 * controller[upperIndex];
				swap(upperIndex, lowerIndex, A);

				printArray(upperIndex, lowerIndex, A);

				controller[upperIndex]++;
				upperIndex = 1;
			} else {
				controller[upperIndex] = 0;
				upperIndex++;
			}
		}
	}

	public static final void heapAlgorithmRecursive(int n, char[] A) {
		if(n == 1) {
			printArray(A);
		} else {
			for(int i = 0; i < n - 1; i++) {
				heapAlgorithmRecursive(n - 1, A);

				if((n % 2) == 0) {
					swap(i, n - 1, A);
				} else {
					swap(0, n - 1, A);
				}
			}
			heapAlgorithmRecursive(n - 1, A);
		}
	}

	public static final void swap(int element1, int element2, char[] A) {
		char tmp = A[element1];
		A[element1] = A[element2];
		A[element2] = tmp;
	}

	public static final void printArray(int element1, int element2, char[] A) {
		for(char i : A) {
			System.out.print(i);
		}

		System.out.println();
	}

	public static final void printArray(char[] A) {
		for(char i : A) {
			System.out.print(i);
		}

		System.out.println();
	}
}