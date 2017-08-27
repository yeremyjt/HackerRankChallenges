package org.yeremy.hackerrank.contests.goldmansachscodesprint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BuyMaximumStocks
{
    static int buyMaximumProducts(long n, long k, int[] a)
    {
        List<Stock> stocks = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            Stock stock = new Stock(i + 1, a[i]);
            stocks.add(stock);
        }

        Collections.sort(stocks);

        long remainingCash = k;
        int totalStocks = 0;
        for (Stock stock : stocks)
        {
            for (int j = 0; j < stock.max; j++)
            {
                if (remainingCash - stock.price >= 0)
                {
                    remainingCash -= stock.price;
                    totalStocks++;
                }
            }
        }

        return totalStocks;
    }


    static class Stock implements Comparable<Stock>
    {
        int max; // The max number of stocks that can be bought on a single day.
        int price; // The price of the stock

        public Stock (int max, int price)
        {
            this.max = max;
            this.price = price;
        }

        @Override
        public int compareTo(Stock that)
        {
            if (this.price < that.price) return -1;
            if (this.price == that.price) return 0;
            else return 1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        long k = in.nextLong();
        long result = buyMaximumProducts(n, k, arr);
        System.out.println(result);
        in.close();
    }

}
