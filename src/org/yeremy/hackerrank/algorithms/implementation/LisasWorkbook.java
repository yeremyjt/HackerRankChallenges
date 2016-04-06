package org.yeremy.hackerrank.algorithms.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Lisa just got a new math workbook. A workbook contains exercise problems, grouped into chapters.

There are nn chapters in Lisa's workbook, numbered from 11 to nn.
The ii-th chapter has titi problems, numbered from 11 to titi.
Each page can hold up to kk problems. There are no empty pages or unnecessary spaces, so only the last page of a chapter may contain fewer than kk problems.
Each new chapter starts on a new page, so a page will never contain problems from more than one chapter.
The page number indexing starts at 11.
Lisa believes a problem to be special if its index (within a chapter) is the same as the page number where it's located. Given the details for Lisa's workbook, can you count its number of special problems?

Note: See the diagram in the Explanation section for more details.

Input Format

The first line contains two integers nn and kk — the number of chapters and the maximum number of problems per page respectively. 
The second line contains nn integers t1,t2,…,tnt1,t2,…,tn, where titi denotes the number of problems in the ii-th chapter.

Constraints

1≤n,k,ti≤100
 */
public class LisasWorkbook
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        int[] problems = new int[n];
        
        for (int i=0; i<n; i++)
        {
            problems[i] = scanner.nextInt();
        }
        
        System.out.println(calculateSpecialProblems(n, k, problems));
    }

    private static int calculateSpecialProblems(int n, int k, int[] problems)
    {
        int specialProblems = 0;
        int page = 0;
        int problemsPerChapterCounter = 0;
        int problemsPerPageCounter = 0;
        
        // Looping through chapters
        for (int i = 0; i < n; i++)
        {
            // Looping through problems per chapter
            page++;
            problemsPerChapterCounter = 0;
            problemsPerPageCounter = 0;
            for (int j=0; j < problems[i]; j++)
            {
                problemsPerChapterCounter++;
                problemsPerPageCounter++;
                
                if (problemsPerPageCounter > k)
                {
                    page++;
                    problemsPerPageCounter = 1;
                }   
                
                if (problemsPerChapterCounter == page) 
                {
                    specialProblems++;
                }
                            
            }
            
        }
        
        return specialProblems;
    }
}
