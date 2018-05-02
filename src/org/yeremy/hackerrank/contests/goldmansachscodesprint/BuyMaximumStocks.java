package org.yeremy.hackerrank.contests.goldmansachscodesprint;

import java.util.*;

public class BuyMaximumStocks
{
    static long buyMaximumProducts(int n, long k, int[] a)
    {
        List<Stock> stocks = new ArrayList<>();
        // Creating stock objects
        for (int i = 0; i < a.length; i++)
        {
            Stock stock = new Stock(i + 1, a[i]);
            stocks.add(stock);
        }

        Collections.sort(stocks);

        long remainder = k;
        long maxStocks = 0;

        for (Stock stock : stocks)
        {
            maxStocks += Math.min(stock.getDay(), (remainder / stock.getValue()));
            remainder -= (stock.getValue() * Math.min(stock.getDay(), (remainder / stock.getValue())));
        }

        return maxStocks;
    }

    private static class Stock implements Comparable
    {
        private int day;
        private int value;

        public Stock(int day, int value)
        {
            this.day = day;
            this.value = value;
        }
        public int getDay()
        {
            return day;
        }

        public void setDay(int day)
        {
            this.day = day;
        }

        public int getValue()
        {
            return value;
        }

        public void setValue(int value)
        {
            this.value = value;
        }

        @Override
        public int compareTo(Object o)
        {
            Stock that = (Stock) o;
            if (this.value < that.value)
            {
                return -1;
            }
            else if (this.value == that.value)
            {
                if (this.day <= that.day)
                    return -1;
                else return 1;
            }
            else return 1;
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        long k = in.nextLong();
        long result = buyMaximumProducts(n, k, arr);
        System.out.println(result);
        in.close();
    }
}
