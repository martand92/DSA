package DSA.Bucket2._03_hash;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/find-all-pairs-whose-sum-is-x5808/1
public class _08_00_FindAllPairsWithGivenSum_DistinctEle {

	public static void main(String[] args) {

		int[] a = { 1, 2, 4, 5, 7 };

		int[] b = { 5, 6, 3, 4, 8 };

		int givenSum = 9;

		HashSet<Integer> hs = new HashSet<Integer>();
		ArrayList<String> al = new ArrayList<String>();

		for (int i = 0; i < b.length; i++)
			hs.add(b[i]);

		Arrays.sort(a);

		for (int i = 0; i < a.length; i++) {
			if (hs.contains(givenSum - a[i]))
				al.add(a[i] + "," + (givenSum - a[i]));
		}

		System.out.println(al);

	}

}
