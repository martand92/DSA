package DSA.Bucket2._03_hash;

import java.util.Arrays;
import java.util.HashMap;

//https://practice.geeksforgeeks.org/problems/frequency-of-array-elements-1587115620/1
public class _05_FreqOfArrayElements_NonOptimised {

	public static void main(String[] args) {

		// int[] arr = { 3, 3, 3, 3 };
		int[] arr = { 2, 3, 2, 3, 5 };


		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++)
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);

		for (int i = 0; i < arr.length; i++) {

			if (hm.get(i + 1) != null)
				arr[i] = hm.get(i + 1);
			else
				arr[i] = 0;
		}
		
		System.out.println(Arrays.toString(arr));

	}
}
