package org.yeremy.hackerrank.algorithms.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ACM_ICPC_Team 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		boolean[][] matrix = new boolean[n][m];
		
		for (int i = 0; i < n; i++)
		{
			String line = sc.next();
			char[] charArray = line.toCharArray();
			
			for (int j = 0; j < m; j++)
			{
				int number = Integer.parseInt(charArray[j] + "");
				if (number == 1)
					matrix[i][j] = true;
				else
					matrix[i][j] = false;
			}
		}
		
		
		System.out.println(calculate(n, m, matrix));	
		sc.close();
	}

	private static String calculate(int n, int m, boolean[][] matrix) 
	{
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int maxTopics = 0;
		int maxTeams = 0;
		
		for (int i = 0; i < n; i++) 
		{
			// If last row, break loop
			if (i == n - 1)
			{
				break;
			}
			
			for (int k = i + 1; k < n; k++)
			{
				int temp = 0;
				
				for (int j = 0; j < m; j++)
				{
					if (matrix[i][j] || matrix[k][j])
					{
						temp++;
						if (temp > maxTopics)
						{
							maxTopics = temp;
						}
					}
				}
				
				if (map.containsKey(new Integer(temp)))
				{
					map.put(new Integer(temp), map.get(new Integer(temp)) + 1);
				}
				else
				{
					map.put(new Integer(temp), new Integer(1));
				}
			}
			
		}
		
		return String.valueOf(maxTopics + "\n" + String.valueOf(map.get(new Integer(maxTopics))));
	}
}
