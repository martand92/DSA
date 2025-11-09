package DSA.Bucket4._06_stacks;

import java.util.Stack;

//https://www.youtube.com/watch?v=eay-zoSRkVc
//https://leetcode.com/problems/online-stock-span/description/

// Intuition : need to check how many days before you see stock price greater than current. 
// Hence need to find previous greater element

// Algo : 
// As you need to trace back days till you find stock value greater than current, 
// then find pge to current and find difference between current day and this pge's day which will provide ans
public class _27_StockSpan {

	public static class Stock {
		int stockVal;
		int index;

		Stock(int stockVal, int index) {
			this.stockVal = stockVal;
			this.index = index;
		}
	}

	public static Stack<Stock> st = new Stack<Stock>();
	static int currDay = 0;

	public static int next(int stockVal) {
		int stockSpan = 0;

		while (!st.isEmpty() && stockVal >= st.peek().stockVal)
			st.pop();

		if (st.isEmpty())
			stockSpan = currDay - (-1);
		else
			stockSpan = currDay - st.peek().index;

		st.push(new Stock(stockVal, currDay));
		currDay++;

		return stockSpan;
	}

	public static void main(String[] args) {
		System.out.println(next(7));
		System.out.println(next(2));
		System.out.println(next(1));
		System.out.println(next(3));
		System.out.println(next(3));
		System.out.println(next(1));
		System.out.println(next(8));
	}
}