package org.yeremy.hackerrank.algorithms;

import java.io.*;
import java.util.*;


/*
 * Solution for Cut The Sticks HackRank challenge
 * https://www.hackerrank.com/challenges/cut-the-sticks 
 */
public class CutTheSticks {

	private static String cutTheSticks(Integer[] array) {
		sort(array);

		int firstIndex;
		int smallestNumber;
		int newLength = 0;
		String result = array.length + "\n";

		while (true) {
			newLength = 0;
			firstIndex = 0;
			smallestNumber = 0;

			while (true) {
				if (array[firstIndex] != 0) {
					smallestNumber = array[firstIndex];
					break;
				} else {
					firstIndex++;
					if (firstIndex == array.length)
						break;
				}
			}

			if (smallestNumber == 0) break;

			for (int i = firstIndex; i < array.length; i++) {
				array[i] -= smallestNumber;
				if (array[i] != 0) {
					newLength++;
				}
			}

			if (newLength != 0)
				result += newLength + "\n";

		}

		return result;

	}


	/**
	 * Rearranges the array in ascending order, using the natural order.
	 *
	 * @param a the array to be sorted
	 */
	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
		assert isSorted(a);
	}

	// quicksort the subarray from a[lo] to a[hi]
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
		assert isSorted(a, lo, hi);
	}



	// partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
	// and return the index j.
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while (true) {

			// find item on lo to swap
			while (less(a[++i], v))
				if (i == hi) break;

			// find item on hi to swap
			while (less(v, a[--j]))
				if (j == lo) break;      // redundant since a[lo] acts as sentinel

			// check if pointers cross
			if (i >= j) break;

			exch(a, i, j);
		}

		// put partitioning item v at a[j]
		exch(a, lo, j);

		// now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
		return j;
	}


	/***************************************************************************
	 * Helper sorting functions.
	 ***************************************************************************/

	// is v < w ?
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	// exchange a[i] and a[j]
	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}



	/***************************************************************************
	 * Check if array is sorted - useful for debugging.
	 ***************************************************************************/
	private static boolean isSorted(Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
	}

	private static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
			if (less(a[i], a[i - 1])) return false;
		return true;
	}



	/**
	 * Rearranges the array so that a[k] contains the kth smallest key;
	 * a[0] through a[k-1] are less than (or equal to) a[k]; and
	 * a[k+1] through a[N-1] are greater than (or equal to) a[k].
	 *
	 * @param a the array
	 * @param k find the kth smallest
	 */
	public static Comparable select(Comparable[] a, int k) {
		if (k < 0 || k >= a.length) {
			throw new IndexOutOfBoundsException("Selected element out of bounds");
		}
		int lo = 0, hi = a.length - 1;
		while (hi > lo) {
			int i = partition(a, lo, hi);
			if (i > k) hi = i - 1;
			else if (i < k) lo = i + 1;
			else return a[i];
		}
		return a[lo];
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Integer[] array = new Integer[n];


		for (int i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}

		System.out.println(cutTheSticks(array));

	}


}

