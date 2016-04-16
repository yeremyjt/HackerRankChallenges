package org.yeremy.hackerrank.algorithms.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Manasa is out on a hike with friends. She finds a trail of stones with numbers on them. She starts following the trail and notices that two consecutive stones have a difference of either aa or bb. Legend has it that there is a treasure trove at the end of the trail and if Manasa can guess the value of the last stone, the treasure would be hers. Given that the number on the first stone was 00, find all the possible values for the number on the last stone.

Note: The numbers on the stones are in increasing order.

Input Format 
The first line contains an integer TT, i.e. the number of test cases. TT test cases follow; each has 3 lines. The first line contains nn (the number of stones). The second line contains aa, and the third line contains bb.

Output Format 
Space-separated list of numbers which are the possible values of the last stone in increasing order.

Constraints 
1≤T≤101≤T≤10 
1≤n,a,b≤103
 */

public class ManasaAndStones
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int i = 0; i < T; i++){
            int n = sc.nextInt() - 1;
            int one = sc.nextInt();
            int two = sc.nextInt();
            
            System.out.println(calculateLastStone(n, one, two));
        }
    }

    private static String calculateLastStone(int n, int one, int two)
    {
        StringBuilder stringBuilder = new StringBuilder();
        int a = Math.min(one, two);
        int b = Math.max(one, two);
        int current = a * n;
        int max = b * n;
        int difference = b - a;
        
        if (a == b)
        {
            return Integer.toString(current);
        }
        else
        {
            while (current <= max)
            {
                stringBuilder.append(Integer.toString(current) + " ");
                current += difference;
            }
        }
        
        return stringBuilder.toString();
    }
   
}
