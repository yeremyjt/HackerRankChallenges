package org.yeremy.hackerrank.algorithms;

import java.io.*;
import java.util.*;

public class ServiceLane {

	private static int largestVehicle(int i, int j, int[] array) {
		int maxWidth = Integer.MAX_VALUE;
		
		for (int x = i; x <= j; x++) {
			if (array[x] < maxWidth)
				maxWidth = array[x];
		}
		
		return maxWidth;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int tests = in.nextInt();
		
		int[] array = new int[n];
		
		for (int i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}
		
		for (int i = 0; i < tests; i++) {
			System.out.println(largestVehicle(in.nextInt(), in.nextInt(), array));
		}
		

	}

}
