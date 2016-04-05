package org.yeremy.hackerrank.algorithms.implementation;

import java.io.*;
import java.util.*;

/*
 * Solution to HackerRank challenge FindDigits
 * https://www.hackerrank.com/challenges/find-digits
 */
public class FindDigits {

	private static int findDigits(int number) {
		String numberStr = String.valueOf(number);
		int currentNumber = 0;
		int digitsCount = 0;
		
		for (int i = 0; i < numberStr.length(); i++) {
			if (numberStr.charAt(i) == '0')
				continue;
			
			currentNumber = Character.getNumericValue(numberStr.charAt(i));
			
			if (number % currentNumber == 0) {
				digitsCount++;
			}
		}
		
		return digitsCount;
		
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println(findDigits(in.nextInt()));
		}

	}

}
