package DSA.Bucket2._03_hash;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/intersection-of-two-arrays2404/1
public class _07_IntersectionOfTwoArrays {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5, 6 };
		int[] b = { 3, 4, 5, 6, 7 };

		int count = 0;

		LinkedHashSet<Integer> hs = new LinkedHashSet<Integer>();

		for (int i = 0; i < a.length; i++)
			hs.add(a[i]);

		for (int j = 0; j < b.length; j++)
			if (hs.contains(b[j]))
				count++;

		System.out.println(count);

	}

}
