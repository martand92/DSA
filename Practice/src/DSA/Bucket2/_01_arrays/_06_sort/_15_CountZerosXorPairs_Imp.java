package DSA.Bucket2._01_arrays._06_sort;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/counts-zeros-xor-pairs0349/1
public class _15_CountZerosXorPairs_Imp {

	public static void main(String[] args) {

		// int arr[] = { 1, 3, 4, 1, 4, 4, 4 };
		// int arr[] = { 1, 3, 4, 1, 4};
		int arr[] = { 2, 2, 2 };

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		long count = 0;

		for (int i = 0; i < arr.length; i++) {

			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);

			if (hm.get(arr[i]) == 2)
				count++;

			else if (hm.get(arr[i]) > 2)
				count += hm.get(arr[i]) - 1;
		}

		System.out.println(count);
	}

}
