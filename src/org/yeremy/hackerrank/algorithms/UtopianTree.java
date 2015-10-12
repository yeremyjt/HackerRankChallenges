package org.yeremy.hackerrank.algorithms;

import java.io.*;
import java.util.*;

/*
 * Solution to HackerRank Challenge Utopian Tree
 * https://www.hackerrank.com/challenges/utopian-tree
 */


public class UtopianTree {

	private static int calculateHeight(int n) {
		int height = 1;
		boolean springCycle = false;
		boolean summerCycle = true;
		
		for (int i = 0; i < n; i++)
		{
			if (summerCycle) {
				height *= 2;
				summerCycle = false;
				springCycle = true;
				continue;
			}
			
			if (springCycle) {
				height += 1;
				springCycle = false;
				summerCycle = true;
				continue;
			}
		}
		
		return height;
		
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int cycles = 0;
		
		for (int i = 0; i < n; i++) {
			cycles = in.nextInt();
			System.out.println(calculateHeight(cycles));
		}
		
		

	}

}
