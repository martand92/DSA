package DSA.Bucket2._01_arrays._05_sort;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/shop-in-candy-store1145/1
public class _09_ShopInCandyStore_Nice {

	public static void main(String[] args) {

		int[] candies = { 3, 2, 1, 4 };
		Arrays.sort(candies);
		int N = candies.length;
		int K = 2;

		ArrayList<Integer> al = new ArrayList<Integer>();

		int l = 0, r = N - 1, min = 0, max = 0;

		while (l <= r) {
			min += candies[l];
			l++;
			r = r - K;
		}
		al.add(min);

		l = 0;
		r = N - 1;
		while (l <= r) {
			max += candies[r];
			l = l + K;
			r--;
		}
		al.add(max);

		System.out.println(al);
	}

}