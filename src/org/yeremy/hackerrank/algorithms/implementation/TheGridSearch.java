package org.yeremy.hackerrank.algorithms.implementation;

import java.util.Scanner;

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