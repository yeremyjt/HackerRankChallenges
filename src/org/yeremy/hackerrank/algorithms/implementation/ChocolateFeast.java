package org.yeremy.hackerrank.algorithms.implementation;

import java.util.Scanner;

/*
 * Little Bob loves chocolate, and he goes to a store with $N$N in his pocket. The price of each chocolate is $C$C. The store offers a discount: for every MM wrappers he gives to the store, he gets one chocolate for free. How many chocolates does Bob get to eat?

Input Format: 
The first line contains the number of test cases, TT. 
TT lines follow, each of which contains three integers, NN, CC, and MM.

Output Format: 
Print the total number of chocolates Bob eats.

Constraints: 
1≤T≤10001≤T≤1000 
2≤N≤1052≤N≤105 
1≤C≤N1≤C≤N 
2≤M≤N
 */

public class ChocolateFeast
{

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n = 0;
        int c = 0;
        int m = 0;
        for(int a0 = 0; a0 < t; a0++){
             n = in.nextInt();
             c = in.nextInt();
             m = in.nextInt();
             System.out.println(chocolateCalculator(n,c,m));
        }       
    }
    
    private static int chocolateCalculator(int n, int c, int m)
    {        
        if (n < c) return 0;
        
        int chocolates = n/c;       
        
        return chocolates + chocolatesFromWrappers(n, c, m);
       
    }

    private static int chocolatesFromWrappers(int n, int c, int m)
    {
        int chocolatesFromWrappers = 0;
        int wrappers = n/c;
        
        while (wrappers >= m)
        {
            chocolatesFromWrappers++;
            wrappers++;
            wrappers -= m;
        }
        
        return chocolatesFromWrappers;
    }
}
