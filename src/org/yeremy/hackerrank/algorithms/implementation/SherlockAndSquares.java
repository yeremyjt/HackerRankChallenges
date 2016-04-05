package org.yeremy.hackerrank.algorithms.implementation;

import java.util.*;
import java.io.*;

/*
 * Solution to HackerRank challenge Sherklock and Squares
 * https://www.hackerrank.com/challenges/sherlock-and-squares
 */
public class SherlockAndSquares {

	private static int findSquares(int a, int b) {
		return (int) (Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println(findSquares(in.nextInt(), in.nextInt()));
		}
		

	}

}
