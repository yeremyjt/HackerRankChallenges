package org.yeremy.hackerrank.algorithms.implementation;

import java.util.Scanner;

/*
 * You are given a square map of size n×nn×n. Each cell of the map has a value denoting its depth. We will call a cell of the map a cavity if and only if this cell is not on the border of the map and each cell adjacent to it has strictly smaller depth. Two cells are adjacent if they have a common side (edge).

You need to find all the cavities on the map and depict them with the uppercase character X.

Input Format

The first line contains an integer, nn, denoting the size of the map. Each of the following nn lines contains nn positive digits without spaces. Each digit (1-9) denotes the depth of the appropriate area.

Constraints 
1≤n≤1001≤n≤100
Output Format

Output nn lines, denoting the resulting map. Each cavity should be replaced with character X.

Sample Input

4
1112
1912
1892
1234
Sample Output

1112
1X12
18X2
1234
 */
public class CavityMap
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String line = "";
        int[][] matrix = new int[n][n];
        
        for (int i = 0; i < n; i++)
        {
            line = sc.next();
            char[] charArray = line.toCharArray();
            
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = Integer.parseInt(charArray[j] + "");
            }            
        }
        
        System.out.println(cavityMapCalculator(matrix, n));
    }

    private static String cavityMapCalculator(int[][] matrix, int n)
    {
        String result = "";
               
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (!isBorder(i, j, n))
                {
                    if (isCavity(i, j, matrix))
                    {
                        result += "X";
                    }
                    else
                    {
                        result += matrix[i][j];
                    }
                }
                else
                {
                    result += matrix[i][j] + "";                    
                }
            }            
            
            result += "\n";
        }
        
               
        return result;
    }

    private static boolean isCavity(int i, int j, int[][] matrix)
    {
        // Check cell above
        if (isAdjacentSmaller(matrix[i][j], i + 1, j, matrix) &&
                
                // Check cell below
                isAdjacentSmaller(matrix[i][j], i - 1, j, matrix) &&
                
                // Check cell to the right
                isAdjacentSmaller(matrix[i][j], i, j + 1, matrix) &&
                
                // Check cell to the left
                isAdjacentSmaller(matrix[i][j], i, j - 1, matrix)
                )
        {
            return true;
        }
        return false;
    }

    private static boolean isAdjacentSmaller(int number, int i, int j, int[][] matrix)
    {
        try 
        {
            if (number > matrix[i][j])
                return true;
            else 
            {
                return false;
            }   
        }
        catch (IndexOutOfBoundsException e)
        {
            return false;
        }
    }

    private static boolean isBorder(int i, int j, int n)
    {
        // Checking if element is in top or bottom row.
        if (i == 0 || i == (n - 1))
        {
            return true;
        }
        
        // Checking if element is in far left or far right column.
        if (j == 0 || j == (n - 1))
        {
            return true;
        }
        
        return false;
    }

}
