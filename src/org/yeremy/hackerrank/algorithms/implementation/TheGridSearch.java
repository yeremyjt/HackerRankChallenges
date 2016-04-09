package org.yeremy.hackerrank.algorithms.implementation;

import java.util.Scanner;

/*
 * Given a 2D array of digits, try to find the occurrence of a given 2D pattern of digits. For example, consider the following 2D matrix:

1234567890  
0987654321  
1111111111  
1111111111  
2222222222  
Assume we need to look for the following 2D pattern:

876543  
111111  
111111
If we scan through the original array, we observe that the 2D pattern begins at the second row and the third column of the larger grid (the 88 in the second row and third column of the larger grid is the top-left corner of the pattern we are searching for).

So, a 2D pattern of PP digits is said to be present in a larger grid GG, if the latter contains a contiguous, rectangular 2D grid of digits matching with the pattern PP, similar to the example shown above.

Input Format 
The first line contains an integer, TT, which is the number of test cases. TT test cases follow, each having a structure as described below: 
The first line contains two space-separated integers, RR and CC, indicating the number of rows and columns in the grid GG, respectively. 
This is followed by RR lines, each with a string of CC digits, which represent the grid GG. 
The following line contains two space-separated integers, rr and cc, indicating the number of rows and columns in the pattern grid PP. 
This is followed by rr lines, each with a string of cc digits, which represent the pattern PP.

Constraints 
1≤T≤51≤T≤5 
1≤R,r,C,c≤10001≤R,r,C,c≤1000 
1≤r≤R1≤r≤R 
1≤c≤C
 */
public class TheGridSearch
{
    final public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String line = "";
        
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            char[][] G = new char[R][C];            
            for(int G_i=0; G_i < R; G_i++){                
                line = in.next();
                char[] charArray = line.toCharArray();
                
                for (int j = 0; j < C; j++)
                {
                    G[G_i][j] = charArray[j];
                }                              
            }    
            
            int r = in.nextInt();
            int c = in.nextInt();
            char[][] P = new char[r][c];            
            for(int P_i=0; P_i < r; P_i++){
                line = in.next();
                char[] charArray = line.toCharArray();
                
                for (int j = 0; j < c; j++)
                {
                    P[P_i][j] = charArray[j];
                }
            }
                        
            
            System.out.println(gridSearch(G, R, C, P, r, c));
        }
        
       
    }

    private static String gridSearch(char[][] G, int R, int C, char[][] P, int r, int c)
    {               
        int PindexRow = 0;
        int PindexColumn = 0;        
        
        for (int i = 0; i < R; i++)
        {                    
            for (int j = 0; j < C; j++)
            {                                
                if (G[i][j] == P[PindexRow][PindexColumn])
                {
                    if (checkForPattern(G, i, j, P, r, c))
                    {
                        return  "YES";                        
                    }                                            
                }            
            }
        }// end for loop rows
        
        return "NO";
        
    }

    private static boolean checkForPattern(char[][] G, int i, int j, char[][] P, int r, int c)
    {
        boolean result = false;
        int GindexRow = i;
        int GindexColumn = j;
        
        try
        {
            // Looping through the P matrix.        
            for (int x = 0; x < r; x++)
            {
                for (int y = 0; y < c; y++)
                {
                    if (G[GindexRow][GindexColumn] == P[x][y])
                    {
                        result = true;
                        GindexColumn++;
                    }
                    else
                    {
                        return false;
                    }
                }
                GindexRow++;
                GindexColumn = j;
            }
        }
        catch (IndexOutOfBoundsException e)
        {
            return false;
        }
        
        return result;
    }
}